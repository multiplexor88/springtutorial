package spring.core.autowiring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.core.method_replacement.StandardTarget;

/**
 * Created by multi on 21.04.2016.
 */
public class main {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/core/autowiring/appContext.xml");

        Target t = null;
        System.out.println("BY NAME:");
        t = (Target) ctx.getBean("byName");
        System.out.println(t);
        System.out.println();
        System.out.println("BY TYPE:");
        t = (Target) ctx.getBean("byType");
        System.out.println(t);
        System.out.println();
        System.out.println("BY CONSTRUCTOR");
        t = (Target) ctx.getBean("constructor");
        System.out.println(t);

    }
}
