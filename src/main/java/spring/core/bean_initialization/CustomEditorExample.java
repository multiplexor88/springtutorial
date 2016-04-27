package spring.core.bean_initialization;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by multi on 25.04.2016.
 */
public class CustomEditorExample {
    private UserName name;

    @Override
    public String toString() {
        return "CustomEditorExample{" +
                "name=" + name +
                '}';
    }

    public UserName getName() {
        return name;
    }

    public void setName(UserName name) {
        this.name = name;
    }

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext(
                "spring/core/bean_initialization/appContext.xml");

        CustomEditorExample nameSurname = ctx.getBean("nameSurname", CustomEditorExample.class);
        System.out.println(nameSurname);
    }


}
