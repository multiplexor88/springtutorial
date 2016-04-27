package spring.core;

import org.springframework.beans.factory.annotation.Value;

/**
 * Created by multi on 20.04.2016.
 */
public class ConstructorDIBeanWithMessage
{
    private String message;

    private String secondaryMessage;

    public String getMessage() {
        return message;
    }

    public ConstructorDIBeanWithMessage(String message) {
        this.message = message;
    }

    public String getSecondaryMessage() {
        return secondaryMessage;
    }

    public ConstructorDIBeanWithMessage(String message, String secondaryMessage) {

        this.message = message;
        this.secondaryMessage = secondaryMessage;
    }
}
