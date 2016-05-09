package hibernate.jpa;

import hibernate.jpa.dao.ContactDao;
import hibernate.jpa.entity.Contact;
import hibernate.jpa.entity.ContactTelDetail;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

/**
 * Created by multi on 20.04.2016.
 */
public class main {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:hibernate.jpa/db-config.xml");
        ContactDao contactDao = ctx.getBean("jpaContactService", ContactDao.class);
//        contactDao.findAllWithDetail().stream().forEach(System.out::println);
//        System.out.println(contactDao.findById(1L));
//        contactDao.findAllContactSummary().stream().forEach(System.out::println);

//        Contact contact = new Contact();
//        contact.setBirthDate(new Date());
//        contact.setFirstName("Igorek");
//        contact.setLastName("Dumchykov");
//        contact.setId(12L);
//
//        ContactTelDetail detail = new ContactTelDetail("Home", "22222");
//        detail.setContact(contact);
//        contact.getContactTelDetails().add(detail);
//
//        contactDao.save(contact);


//        contactDao.delete(contactDao.findById(12L));
//        contactDao.findAllContactSummary().stream().forEach(System.out::println);

//        contactDao.findAllByNativeQuery().stream().forEach(System.out::println);

//        contactDao.findAllContactSummaryByNativeQuery().stream().forEach(System.out::println);
//        contactDao.findAllByNativeQueryReturnResultMap().stream().forEach(System.out::println);

//        contactDao.findAllContactSummaryByNativeQueryReturnResultMap().stream().forEach(System.out::println);

//        contactDao.findByCriteria("Michael", null).stream().forEach(System.out::println);

    }
}
