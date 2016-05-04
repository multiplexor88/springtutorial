package hibernate.quiries;

import hibernate.jpa.entity.Contact;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.persistence.*;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Iterator;

/**
 * Created by Igor Dumchykov on 03.05.2016.
 */
public class main {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:hibernate.jpa/db-config.xml");
        EntityManager em = ctx.getBean("emf", EntityManagerFactory.class).createEntityManager();
        Session session = em.unwrap(Session.class);

        Query query = null;
        CriteriaBuilder cb = null;
        CriteriaQuery criteria = null;

        //1. Query
        query = em.createQuery("select c from Contact c");

        //2. CriteriaBuiler
        cb = em.getCriteriaBuilder();
        criteria = cb.createQuery();//can be typed: cb.CreateQuery(Contact.class)
        criteria.select(criteria.from(Contact.class));
        query = em.createQuery(criteria);

        //3. Native query
        query = em.createNativeQuery("select * from contact", Contact.class);

        //4. Typed query
        query = em.createQuery("select c from Contact c where c.id = :id").setParameter("id", 1L);
        Contact item = (Contact) query.getSingleResult();
        TypedQuery<Contact> tQuery = em.createQuery("select c from Contact c where c.id = :id", Contact.class).setParameter("id", 1L);
        item = (Contact) tQuery.getSingleResult();

        //5. Hibernate query
        org.hibernate.Query hQuery = null;
        hQuery = session.createQuery("select c from Contact c");

        //6. Hiberbate criteria
        Criteria hCriteria = null;
        hCriteria = session.createCriteria(Contact.class);
        hCriteria.add(Restrictions.eq("id", 1L));
        item = (Contact) hCriteria.uniqueResult();

        //7. CriteriaBuilder Root
        cb = em.getCriteriaBuilder();
        criteria = cb.createQuery(Contact.class);
        Root<Contact> from = criteria.from(Contact.class);
        query = em.createQuery(
                criteria.select(from).where(
                        cb.equal(from.get("firstName"), cb.parameter(String.class))))
                .setParameter(cb.parameter(String.class), "Scott");

        //8. Positional parameters
        query = em.createQuery("select c from Contact c where c.id = ?1");
        query.setParameter(1, 1L);

        //9. Paging
        query = em.createQuery("select c from Contact c");
        query.setFirstResult(40).setMaxResults(10);

        //10. Listing
//        query.getResultList();
//        query.getSingleResult();

        //11. Iterating
        hQuery = session.createQuery("select c from Contact c");
        Iterator<Contact> it = hQuery.iterate();
        while(it.hasNext()){
            it.next();
        }
        Hibernate.close(it);

        //12. Named quiries (see class Contact)
//        em.createNamedQuery("findContacts");
//        session.getNamedQuery("findContacts");


    }
}
