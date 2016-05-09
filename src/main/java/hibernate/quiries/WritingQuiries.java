package hibernate.quiries;

import hibernate.jpa.entity.Contact;
import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Igor Dumchykov on 04.05.2016.
 */
public class WritingQuiries {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:hibernate.jpa/db-config.xml");
        EntityManager em = ctx.getBean("emf", EntityManagerFactory.class).createEntityManager();
        Session session = em.unwrap(Session.class);

        Query query = null;
        CriteriaBuilder cb = null;
        CriteriaQuery criteria = null;
        Root<Contact> i = null;

        query = em.createQuery("from Contact");
//        query.getResultList().forEach(System.out::println);
        cb = em.getCriteriaBuilder();
        criteria = cb.createQuery(Contact.class);
        i = criteria.from(Contact.class);
        //this i is like an alias: select i from contact as i
//        criteria.select(i);
//        em.createQuery(criteria).getResultList().forEach(System.out::println);

        //Restrivtions
        //1.
//        em.createQuery("from Contact c where c.id = :id").setParameter("id", 1L).getResultList().forEach(System.out::println);
//        -----------------------------------------------------------
//        criteria.select(i).where(cb.equal(i.get("id"), 1L));
//        em.createQuery(criteria).getResultList().forEach(System.out::println);
        //2.
//        em.createQuery("from Contact c where c.id between 1 and 5").getResultList().forEach(System.out::println);
//        -----------------------------------------------------------
//        criteria.select(i).where(cb.between(i.get("id"), 1L, 5L));
//        em.createQuery(criteria).getResultList().forEach(System.out::println);
        /*
        another restrictions:
            cb.gt           greater (only for Number)
            cb.greaterThan  (for Date)
            cb.in
            cb.equal        (for enum: em.equal(i.get("something"), Something.Som_ENUM)
            cb.isNull
            cb.isNotNull
            cb.like
            cb.like(...).not()
         */
        System.out.println(em.createQuery("from Contact where firstName = 'Scott'").getSingleResult());


    }

}
