package generator.Interceptor;


import generator.Common.ThreadUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import static generator.util.Jwt.getIdfromToken;

@Component
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {

    public static final String AUTHORIZATION_HEADER = "Authorization";

    /**
     * 拦截器处理
     *
     * @param request
     * @param response
     * @param handler
     * @return boolean
     */
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) {
        final String token = request.getHeader(AUTHORIZATION_HEADER);

        try {
            Long id = getIdfromToken(token);
            if (id == null) {
                throw new RuntimeException("过期或未登录");
            }
            ThreadUtil.set(id);
            return true;
        } catch (Exception e) {
            response.setStatus(401);
            return false;
        }
    }


    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        ThreadUtil.remove();
    }
}
