package spring.core;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by multi on 20.04.2016.
 */
@Component
public class AnnotatedAutowiredConstructorDIBeanWith2Messages {

    @Value("default 1")
    private String message;
    @Value("default 2")
    private String secondaryMessage;

    public String getMessage() {
        return message;
    }

    public AnnotatedAutowiredConstructorDIBeanWith2Messages(@Value("Constructor: 1 arg") String message) {
        this.message = message;
    }

    public String getSecondaryMessage() {
        return secondaryMessage;
    }

    public AnnotatedAutowiredConstructorDIBeanWith2Messages(@Value("Constructor: 2 arg, value=1")String message, @Value("Constructor: 2 arg, value=2")String secondaryMessage) {

        this.message = message;
        this.secondaryMessage = secondaryMessage;
    }

    public AnnotatedAutowiredConstructorDIBeanWith2Messages() {
    }
}
