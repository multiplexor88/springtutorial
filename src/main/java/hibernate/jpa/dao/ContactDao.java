package hibernate.jpa.dao;

import hibernate.jpa.entity.Contact;
import hibernate.jpa.entity.ContactSummary;

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
    List<ContactSummary> findAllContactSummary();
    List<Contact> findAllByNativeQuery();
    List<ContactSummary> findAllContactSummaryByNativeQuery();
    List<Contact> findAllByNativeQueryReturnResultMap();
    List<ContactSummary> findAllContactSummaryByNativeQueryReturnResultMap();
    List<Contact> findByCriteria(String fname, String lname);
}
