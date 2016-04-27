package hibernate.core.dao;

import hibernate.core.entity.Contact;

import java.util.List;

/**
 * Created by multi on 22.04.2016.
 */
public interface ContactDao {
    List<Contact> findAll();
    List<Contact> findAllWithDetail();
    Contact findById(Long id);
    Contact save(Contact contact);
    void delete(Contact contact);
}
