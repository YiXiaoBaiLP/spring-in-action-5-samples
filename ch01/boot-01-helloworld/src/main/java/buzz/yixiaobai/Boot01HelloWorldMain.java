package buzz.yixiaobai;

import buzz.yixiaobai.bean.Pet;
import buzz.yixiaobai.bean.User;
import buzz.yixiaobai.config.MyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * 主程序类
 * @author YiXiaoBai
 * @SpringBootApplication： 这是一个Spring Boot程序
 */
@SpringBootApplication
public class Boot01HelloWorldMain {

    public static void main(String[] args){
        ConfigurableApplicationContext context = SpringApplication.run(Boot01HelloWorldMain.class, args);
        // 获取容器中的所有组件
        String[] beans = context.getBeanDefinitionNames();
        for(String beanName : beans){
            System.out.println(beanName);
        }

        //从容器中获取组件
        Pet pet01 = (Pet) context.getBean("tomcatPet");
        Pet pet02 = context.getBean("tomcatPet", Pet.class);
        System.out.println("pet01与pet02是同一个对象吗：" + (pet01 == pet02));

        // 从容器中获取配置类
        MyConfig myConfig = context.getBean(MyConfig.class);
        System.out.println("容器中获取的配置类：" + myConfig);

        // 从配置类中获取的Bean是单例吗
        // 是否可以调用配置类中的方法
        // @Configuration(proxyBeanMethods = true)代理对象调用方法。Spring Boot总会检查这个组件是否在容器中有。
        // 为了保持组件单实例
        User user01 = myConfig.getUser();
        User user02 = myConfig.getUser();
        System.out.println("配置类中获取的Bean是单例吗：" + (user02 == user01));

        // 当@Configuration(proxyBeanMethods = true)时userBean对象中的pet对象与MyConfig类中pet01()方法为一个对象
        // 当@Configuration(proxyBeanMethods = false)时userBean对象中的pet对象与MyConfig类中pet01()方法不为一个对象
        Pet pet03 = myConfig.pet01();
        User userBean = (User) context.getBean("getUser");
        Pet userBeanPet = userBean.getPet();
        System.out.println("userBean中的pet对象与Pet方法中的是同一个吗？" + (pet03 == userBeanPet));
    }
}
