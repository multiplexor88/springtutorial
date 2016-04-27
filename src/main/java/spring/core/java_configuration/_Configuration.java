package spring.core.java_configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import spring.core.SetterDIBean;
import spring.core.SimpleBean;

/**
 * Created by multi on 27.04.2016.
 */
@Configuration
@ImportResource(value = "classpath:spring/core/java_configuration/appContext.xml")
@PropertySource(value = "classpath:spring/core/java_configuration/message.properties")
@ComponentScan(basePackages = {"spring.core.java_configuration"})
@Import(AnotherConfiguration.class)
public class _Configuration {
    @Autowired
    private Environment env;

    @Bean(name = "arg1Bean")
    public SimpleBean simpleBean(){
        SimpleBean bean = new SimpleBean();
        bean.setName(env.getProperty("arg1"));
        return bean;
    }
    @Bean
    public SetterDIBean setterDIBean(){
        SetterDIBean bean = new SetterDIBean();
        bean.setSimpleBean(simpleBean());
        return bean;
    }

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(_Configuration.class);
        SimpleBean bean = ctx.getBean("simpleBeanDefault", SimpleBean.class);
        SimpleBean bean2 = ctx.getBean("arg1Bean", SimpleBean.class);
        System.out.println(bean.getName());
        System.out.println(bean2.getName());
    }
}
