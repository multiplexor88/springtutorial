package spring.core.resources;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;

import java.io.IOException;

/**
 * Created by multi on 27.04.2016.
 */
public class main {
    public static void main(String[] args) throws IOException {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/core/beanFactoryConfiguration.xml");
        Resource resource = context.getResource("https://www.ya.ru");
        System.out.println(resource.getURL().getUserInfo());
    }
}
