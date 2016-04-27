package spring.core.event_listener;

import org.springframework.context.ApplicationEvent;

/**
 * Created by multi on 27.04.2016.
 */
public class MessageEvent extends ApplicationEvent {
    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public MessageEvent(Object source, String message) {
        super(source);
        this.message = message;
    }
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
