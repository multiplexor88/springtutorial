package spring.core.event_listener;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Created by multi on 27.04.2016.
 */
@Component
public class Publisher implements ApplicationContextAware {
    private ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

    public void publish(String message){
        context.publishEvent(new MessageEvent(this, message));
    }

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/core/beanFactoryConfiguration.xml");
        Publisher bean = context.getBean(Publisher.class);
        bean.publish("Hello");
    }
}
