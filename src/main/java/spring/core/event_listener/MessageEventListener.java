package spring.core.event_listener;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * Created by multi on 27.04.2016.
 */
@Component
public class MessageEventListener implements ApplicationListener<MessageEvent> {
    @Override
    public void onApplicationEvent(MessageEvent event) {
        System.out.println("Received message: " + event.getMessage());
    }
}
