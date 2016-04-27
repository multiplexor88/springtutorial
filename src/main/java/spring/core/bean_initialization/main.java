package spring.core.bean_initialization;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.security.MessageDigest;

/**
 * Created by multi on 25.04.2016.
 */
public class main {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext(
                "spring/core/bean_initialization/appContext.xml");

//        BeanOne one_1 = ctx.getBean("one_1", BeanOne.class);

//        ctx.destroy();
//        BeanOne one_2 = ctx.getBean("one_2", BeanOne.class);

//        MessageDigest digest = ctx.getBean("shaDigest", MessageDigest.class);
//        MessageDigest digest2 = ctx.getBean("shaDigest", MessageDigest.class);
//        System.out.println(digest == digest2);

//        MessageDigest digest3 = ctx.getBean("MD2Digest", MessageDigest.class);
        PropertyEditorBean customBeanBundle = ctx.getBean("customBeanBundle", PropertyEditorBean.class);


    }
}
