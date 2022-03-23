package buzz.yixiaobai.config;

import buzz.yixiaobai.bean.Pet;
import buzz.yixiaobai.bean.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *  1、配置类里面使用@Bean标注在方法上给容器注册组件，默认是单实例的
 *  2、配置类本身也是组件
 *  3、@Configuration 注解中添加了一个默认属性proxyBeanMethods：代理Bean方法
 *              Full(proxyBeanMethods = true)
 *              Lite(proxyBeanMethods = false)
 *              组件依赖
 * @author YiXiaoBai
 */
@Configuration(proxyBeanMethods = true) // 这是一个配置类 == 配置文件 beans.xml
public class MyConfig {

    @Bean
    public User getUser(){
        User user = new User("ZhangSanFeng", 18);
        user.setPet(pet01());
        return user;
    }

    @Bean
    public Pet tomcatPet(){
        return new Pet("tomcatPet");
    }

    @Bean
    public Pet pet01(){
        return new Pet("pet01");
    }
}
