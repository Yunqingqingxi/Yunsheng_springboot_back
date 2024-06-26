package generator.Common;

import generator.Interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * 拦截器
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    private static final List<String> PASS_PATH = List.of(
            "/user/login",
            "/user/register",
            "/error"
    );

    /**
     * 注册拦截器
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry
                .addInterceptor(new LoginInterceptor())
                .excludePathPatterns(PASS_PATH);
    }
}
