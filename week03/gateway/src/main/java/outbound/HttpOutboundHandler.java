package outbound;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.*;
import org.apache.commons.codec.binary.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.concurrent.FutureCallback;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClients;
import org.apache.http.util.EntityUtils;
import router.EndpointRouter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static io.netty.handler.codec.http.HttpHeaderNames.CONNECTION;
import static io.netty.handler.codec.http.HttpHeaderValues.KEEP_ALIVE;

/**
 * @author Kelvin Chen
 * @description
 * @date 2021/7/11 10:55 PM
 */
public class HttpOutboundHandler {
    CloseableHttpAsyncClient httpclient = HttpAsyncClients.createDefault();

    private EndpointRouter router;

    private final List<String> testApis = Arrays.asList("localhost:8080/test", "localhost:8081/test");
    public void handle(FullHttpRequest fullHttpRequest, ChannelHandlerContext ctx) {
        String uri = fullHttpRequest.uri();
        String url = null;
        if (uri.contains("/test")) {
            url = router.route(testApis);
        }
        if (Objects.nonNull(url)) {
            handle(fullHttpRequest, ctx, url);
        }
    }
    public void handle(FullHttpRequest fullHttpRequest, ChannelHandlerContext ctx, String url) {

        try {
            // Start the client
            httpclient.start();

            // Execute request
            final HttpGet request = new HttpGet(url);

            httpclient = HttpAsyncClients.custom().setMaxConnTotal(40)
                    .setMaxConnPerRoute(8)
                    .setKeepAliveStrategy((response,context) -> 6000)
                    .build();

            httpclient.execute(request, new FutureCallback<HttpResponse>() {
                @Override
                public void completed(HttpResponse httpResponse) {
                    handlerResponse(fullHttpRequest, ctx, httpResponse);
                }

                @Override
                public void failed(Exception e) {
                    System.out.println(request.getRequestLine() + "->" + e);
                }

                @Override
                public void cancelled() {
                    System.out.println(request.getRequestLine() + " cancelled");
                }
            });
        } finally {
            try {
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private void handlerResponse(FullHttpRequest fullHttpRequest, ChannelHandlerContext ctx, HttpResponse httpResponse) {
        FullHttpResponse response = null;
        try {
            byte[] bytes = EntityUtils.toByteArray(httpResponse.getEntity());
            response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK,
                    Unpooled.wrappedBuffer(bytes));
            response.headers().set("Content-Type", "application/json");
            response.headers().setInt("Content-Length", response.content().readableBytes());
        } catch (UnsupportedEncodingException e) {
            System.out.println("处理出错：" + e.getMessage());
            response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.NO_CONTENT);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fullHttpRequest != null) {
                if (!HttpUtil.isKeepAlive(fullHttpRequest)) {
                    ctx.write(response).addListener(ChannelFutureListener.CLOSE);
                } else  {
                    ctx.write(response);
                }
                ctx.flush();
            }
        }
    }
}
