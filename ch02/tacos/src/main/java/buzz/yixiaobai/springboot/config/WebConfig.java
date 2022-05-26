package buzz.yixiaobai.springboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author yixiaobai
 * @create 2022/05/25 下午11:25
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    // 实现了WebMvcConfigurer接口，并重写addViewControllers()方法
    // 所有的配置类，都可以实现此接口
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // 可以使用ViewControllerRegistry对象来注册一个或多个视图控制器
        registry.addViewController("/").setViewName("home");
    }
}
