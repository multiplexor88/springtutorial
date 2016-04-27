package hibernate.core.dao;

import hibernate.core.entity.Contact;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by multi on 22.04.2016.
 */
@Transactional
@Repository("contactDao")
public class ContactDaoImpl implements ContactDao {
    public static final Logger LOG = LoggerFactory.getLogger(ContactDaoImpl.class);

    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Resource(name = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Contact> findAll() {
        return sessionFactory.getCurrentSession().createQuery(
                "from Contact c"
        ).list();
    }

    @Override
    public List<Contact> findAllWithDetail() {
        return sessionFactory.getCurrentSession().getNamedQuery(
                "Contact.findAllWithDetail"
        ).list();
    }

    @Override
    public Contact findById(Long id) {
        return (Contact) sessionFactory.getCurrentSession().getNamedQuery(
                "Contact.findById"
        ).setParameter("id", id).uniqueResult();
    }

    @Transactional
    @Override
    public Contact save(Contact contact) {
        sessionFactory.getCurrentSession().saveOrUpdate(contact);
        LOG.debug("save contact with id = " + contact.getId());
        return contact;
    }

    @Override
    public void delete(Contact contact) {
        if(ObjectUtils.isEmpty(contact))
            return;
        sessionFactory.getCurrentSession().delete(contact);
        LOG.debug("Delete contact with id = " + contact.getId());
    }
}
