package spring.core.java_configuration;

import org.springframework.stereotype.Component;

/**
 * Created by multi on 27.04.2016.
 */
@Component
public class BeanA {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
