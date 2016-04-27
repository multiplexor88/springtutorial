package hibernate.transaction;

import hibernate.transaction.entity.Contact;
import hibernate.transaction.service.ContactService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.List;

/**
 * Created by multi on 25.04.2016.
 */
public class main {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("hibernate/transaction/db-config.xml");
        ContactService service = ctx.getBean(ContactService.class);
//        List<Contact> all = service.findAll();
//        System.out.println(service.countAll());

        Contact contact = new Contact();
        contact.setFirstName("F");
        contact.setBirthDate(new Date());
        contact.setLastName("L");
        contact.setVersion(1);
        service.save(contact);
    }
}
