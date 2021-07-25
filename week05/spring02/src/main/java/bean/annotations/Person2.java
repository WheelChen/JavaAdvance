package bean.annotations;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author duruo.cy
 * @description
 * @date 2021/7/22 8:31 PM
 */
@Data
@Configuration
public class Person2 {
    @Value("1")
    private String name;

    @Value("1")
    private Integer age;


    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
