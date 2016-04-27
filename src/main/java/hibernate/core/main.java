package hibernate.core;

import hibernate.core.dao.ContactDao;
import hibernate.core.entity.Contact;
import hibernate.core.entity.ContactTelDetail;
import hibernate.core.entity.Hobby;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;


/**
 * Created by multi on 20.04.2016.
 */
public class main {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:hibernate.core/db-config.xml");
//        SessionFactory sessionFactory = (SessionFactory) ctx.getBean("sessionFactory");
//        Session session = sessionFactory.openSession();
//        session.getTransaction().begin();
//
//        Hobby h = new Hobby();
//        h.setHobbyId("java");
//
//        session.save(h);
//        session.getTransaction().commit();
//        session.close();

        ContactDao contactDao = ctx.getBean("contactDao", ContactDao.class);
//        contactDao.findAll().stream().forEach(System.out::println);
//        contactDao.findAllWithDetail().stream().forEach(System.out::println);
//        System.out.println(contactDao.findById(10L));

//        Contact contact = new Contact();
//        contact.setBirthDate(new Date());
//        contact.setFirstName("Michael");
//        contact.setLastName("Jackson");
//
//        ContactTelDetail detail = new ContactTelDetail("Mobile", "22222");
//        detail.setContact(contact);
//        contact.getContactTelDetails().add(detail);
//
//        contactDao.save(contact);

//        contactDao.delete(contactDao.findById(11L));

        contactDao.findAllWithDetail().stream().forEach(System.out::println);

    }
}
