import bean.annotations.Person2;
import bean.config.Person1;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author duruo.cy
 * @description
 * @date 2021/7/22 8:34 PM
 */
public class SpringDemo {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // 根据xml声明
        Person1 person1 = (Person1)context.getBean("person1");
        System.out.println(person1);

        // 使用@Configuration注解 并使用xml配置component-scan
        Person2 person2 = (Person2)context.getBean("person2");
        System.out.println(person2);

    }
}
