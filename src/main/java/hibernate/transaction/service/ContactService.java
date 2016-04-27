package hibernate.transaction.service;

import hibernate.transaction.entity.Contact;

import java.util.List;

/**
 * Created by multi on 25.04.2016.
 */
public interface ContactService {
    List<Contact> findAll();
    Contact findById(Long id);
    Contact save(Contact contact);
    long countAll();
}
