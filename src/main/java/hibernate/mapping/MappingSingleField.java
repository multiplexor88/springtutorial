package hibernate.mapping;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 * Created by Igor Dumchykov on 07.05.2016.
 */
public class MappingSingleField {
    public static void main(String[] args) throws Exception {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:hibernate/mapping/db-config.xml");
        SessionFactory sessionFactory = (SessionFactory) ctx.getBean("sessionFactory");
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
//        Company company = new Company();
//        company.setId("2");
//        company.setName("n_2");
//        session.save(company);

//        TerminalCompany tc = new TerminalCompany();
//        tc.setId("3000");
//        tc.setVin("vin1");
//        tc.setCompanyId("2");
//        session.save(tc);

        Terminal t = new Terminal();
        t.setId("300");
        t.setTerminalVin("vin2");
//        session.save(t);
//        t.setTerminalCompany(tc);
//        session.createQuery("delete from Terminal t where t.id = '100' and t.terminalCompany.companyId = '2'").executeUpdate();
//        Criteria criteria = session.createCriteria(Terminal.class);
//        criteria.createCriteria("terminalCompany").add(Restrictions.eq("companyId", "2"));
//        session.delete(criteria);
//        session.delete(t);
//        session.update(t);
//        t.setId("100");
//        t.setTerminalVin("vin1");
//        session.save(t);
//        session.delete(t);
//        t.setTerminalCompany(tc);
//        session.save(tc);
//        session.save(t);

//        Record r = new Record();
//        r.setId("30000");
//        r.setVin("vin3");
//        session.save(r);
//        TerminalCompany tc = new TerminalCompany();

//        String []ids = new String[]{"100","200", "300"};
//        session.createQuery("delete from TerminalCompany tc where tc.vin = ? and tc.companyId = ?").setParameter(0, "vin1").setParameter(1,"2").executeUpdate();
        session.getTransaction().commit();


//        Query q = session.createQuery("from Terminal t where t.id = '100' and t.terminalCompany.companyId = '2'");
//        System.out.println(q.list());
//        Criteria c = session.createCriteria(Terminal.class);
//        c.createCriteria("terminalCompany").add(Restrictions.eq("companyId", "2")).add(Restrictions.eq("vin", "vin2"));
//        System.out.println(c.list());
//        System.out.println(session.createQuery("from Terminal").list());
        System.out.println(session.createQuery("from TerminalCompany ").list());
//        System.out.println(session.createQuery("from Record ").list());
    }

}
