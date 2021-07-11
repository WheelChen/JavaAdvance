package router;

import java.util.List;

/**
 * @author duruo.cy
 * @description
 * @date 2021/7/11 11:40 PM
 */
public interface EndpointRouter {
    /**
     * 路由
     *
     * @param endpoints
     * @return
     */
    String route(List<String> endpoints);
}
