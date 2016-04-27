package spring.core.method_replacement;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by multi on 21.04.2016.
 */
public class main {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/core/method_replacement/appContext.xml");
        StandardTarget standardTarget = (StandardTarget) ctx.getBean("standardTarget");
        System.out.println(standardTarget.someOperation("Hello"));

        StandardTarget replacedTarget = (StandardTarget) ctx.getBean("replacementTarget");
        System.out.println(replacedTarget.someOperation("Hello"));
    }
}
