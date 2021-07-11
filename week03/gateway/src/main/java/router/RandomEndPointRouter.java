package router;

import java.util.List;

/**
 * @author duruo.cy
 * @description
 * @date 2021/7/11 11:42 PM
 */
public class RandomEndPointRouter implements EndpointRouter{
    /**
     * 路由
     *
     * @param endpoints
     * @return
     */
    @Override
    public String route(List<String> endpoints) {
        int size = endpoints.size();
        // 0 - (size - 1)
        int random = (int)(Math.random() * size);
        return endpoints.get(random);
    }
}
