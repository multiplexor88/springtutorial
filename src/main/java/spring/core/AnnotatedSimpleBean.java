package spring.core;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by multi on 20.04.2016.
 */
@Component
public class AnnotatedSimpleBean {
    @Value("I am AnnotatedSimpleBean")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AnnotatedSimpleBean(String name) {
        this.name = name;
    }

    public AnnotatedSimpleBean() {
    }
}
