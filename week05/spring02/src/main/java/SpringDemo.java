import bean.config.Person;
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

        Person worker = (Person)context.getBean("Worker-1");

        System.out.println(worker);
    }
}
