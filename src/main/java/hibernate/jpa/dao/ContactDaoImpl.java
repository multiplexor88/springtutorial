package hibernate.jpa.dao;

import hibernate.jpa.criteria.Contact_;
import hibernate.jpa.entity.Contact;
import hibernate.jpa.entity.ContactSummary;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.util.List;

/**
 * Created by multi on 22.04.2016.
 */
@Transactional
@Repository
@Service("jpaContactService")
public class ContactDaoImpl implements ContactDao {
    public static final Logger LOG = LoggerFactory.getLogger(ContactDaoImpl.class);

    final static String FIND_ALL = "select * from contact";
    @PersistenceContext
    private EntityManager em;

    @Transactional(readOnly = true)
    @Override
    public List<Contact> findAll() {
        return em.createNamedQuery("Contact.findAll", Contact.class).getResultList();
    }

    @Override
    public List<Contact> findAllWithDetail() {
        return em.createNamedQuery("Contact.findAllWithDetail", Contact.class).getResultList();
    }

    @Override
    public Contact findById(Long id) {
        return em.createNamedQuery("Contact.findById", Contact.class).setParameter("id", id).getSingleResult();
    }

    @Transactional
    @Override
    public Contact save(Contact contact) {
        if(contact.getId() == null){
            LOG.debug("create contact");
            em.persist(contact);
        }else{
            LOG.debug("update contact");
            em.merge(contact);
        }
        LOG.debug("save contact with id = " + contact.getId());
        return contact;
    }

    @Override
    public void delete(Contact contact) {
        if(ObjectUtils.isEmpty(contact))
            return;
        Contact mergedContact = em.merge(contact);
        em.remove(mergedContact);
        LOG.debug("Delete contact with id = " + contact.getId());
    }

    @Override
    public List<ContactSummary> findAllContactSummary() {
        return (List<ContactSummary>) em.createQuery("select new hibernate.jpa.entity.ContactSummary(c.firstName, c.lastName, t.telNumber) from Contact c left join c.contactTelDetails t", ContactSummary.class).getResultList();
    }

    @Override
    public List<Contact> findAllByNativeQuery() {
        return em.createNativeQuery(FIND_ALL, Contact.class).getResultList();
    }

    //can not use!!! because ContactSummary is not an Entity
    @Override
    public List<ContactSummary> findAllContactSummaryByNativeQuery() {
        return em.createNativeQuery("select c.first_name, c.last_name, t.tel_number from contact c JOIN contact_tel_detail t on c.id = t.contact_id", ContactSummary.class).getResultList();
    }

    @Override
    public List<Contact> findAllByNativeQueryReturnResultMap() {
        return em.createNativeQuery(FIND_ALL, "contactResult").getResultList();
    }

    @Override
    public List<ContactSummary> findAllContactSummaryByNativeQueryReturnResultMap() {
        return em.createNativeQuery("select c.first_name as firstName, c.last_name as lastName, t.tel_number as telNumber from contact c JOIN contact_tel_detail t on c.id = t.contact_id", "contactSummaryResult").getResultList();
    }

    @Override
    public List<Contact> findByCriteria(String fname, String lname) {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Contact> query = criteriaBuilder.createQuery(Contact.class);
        Root<Contact> from = query.from(Contact.class);
        from.fetch(Contact_.contactTelDetails, JoinType.LEFT);
        from.fetch(Contact_.hobbies, JoinType.LEFT);
        query.select(from).distinct(true);
        Predicate criteria = criteriaBuilder.conjunction();
        if(fname != null){
            Predicate p = criteriaBuilder.equal(from.get(Contact_.firstName), fname);
            criteria = criteriaBuilder.and(criteria, p);
        }
        if(lname != null){
            Predicate p = criteriaBuilder.equal(from.get(Contact_.lastName), lname);
            criteria = criteriaBuilder.and(criteria, p);
        }
        query.where(criteria);
        return em.createQuery(query).getResultList();
    }
}
