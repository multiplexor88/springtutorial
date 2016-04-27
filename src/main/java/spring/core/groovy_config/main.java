package spring.core.groovy_config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericGroovyApplicationContext;
import spring.core.SimpleBean;

/**
 * Created by multi on 27.04.2016.
 */
public class main {
    public static void main(String[] args) {
        ApplicationContext ctx = new GenericGroovyApplicationContext("spring/core/groovy_config/appConfig.groovy");
        SimpleBean simpleBean = ctx.getBean("simpleBean", SimpleBean.class);
        System.out.println(simpleBean.getName());
    }
}
