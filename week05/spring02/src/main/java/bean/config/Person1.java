package bean.config;

import lombok.Data;

/**
 * @author duruo.cy
 * @description
 * @date 2021/7/22 8:31 PM
 */
@Data
public class Person1 {
    private String name;

    private Integer age;


    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
