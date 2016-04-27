package spring.core.lookupmethodinjection;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * Created by multi on 21.04.2016.
 */
public class main {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/core/lookupmethodinjection/appContext.xml");
        ctx.refresh();

        DemoBean abstractBean_1 = (DemoBean) ctx.getBean("abstractLookup");
        DemoBean standardBean_1 = (DemoBean) ctx.getBean("standardLookup");

        DemoBean abstractBean_2 = (DemoBean) ctx.getBean("abstractLookup");
        DemoBean standardBean_2 = (DemoBean) ctx.getBean("standardLookup");

        System.out.println(abstractBean_1.getMyHelper() == abstractBean_2.getMyHelper());
        System.out.println(standardBean_1.getMyHelper() == standardBean_2.getMyHelper());

    }
}
