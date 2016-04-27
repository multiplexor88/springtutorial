package spring.core.internationalization;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Locale;

/**
 * Created by multi on 25.04.2016.
 */
public class main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring/core/internationalization/appContext.xml");
        String en = ctx.getMessage("arg1", null, Locale.ENGLISH);
        Locale RU = new Locale("ru", "RU");
        String ru = ctx.getMessage("arg1", null, RU);
        System.out.println(en + " " + ru);
    }
}
