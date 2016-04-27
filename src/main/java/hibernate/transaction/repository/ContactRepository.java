package hibernate.transaction.repository;

import hibernate.transaction.entity.Contact;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by multi on 25.04.2016.
 */

public interface ContactRepository extends CrudRepository<Contact, Long> {
    @Query("select count(c) from Contact c")
    long countAllContacts();
}
