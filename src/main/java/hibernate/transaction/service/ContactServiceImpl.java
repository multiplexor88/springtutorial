package hibernate.transaction.service;

import com.google.common.collect.Lists;
import hibernate.transaction.entity.Contact;
import hibernate.transaction.repository.ContactRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by multi on 25.04.2016.
 */
@Service("contactService")
@Repository
@Transactional
public class ContactServiceImpl implements ContactService {
    @Resource
    private ContactRepository contactRepository;

    public ContactRepository getContactRepository() {
        return contactRepository;
    }

    public void setContactRepository(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Contact> findAll() {
        return Lists.newArrayList(contactRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public Contact findById(Long id) {
        return contactRepository.findOne(id);
    }

    @Override
    public Contact save(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.NEVER)
    public long countAll() {
        return contactRepository.countAllContacts();
    }
}
