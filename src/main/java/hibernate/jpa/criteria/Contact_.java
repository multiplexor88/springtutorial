package hibernate.jpa.criteria;

import hibernate.jpa.entity.Contact;
import hibernate.jpa.entity.ContactTelDetail;
import hibernate.jpa.entity.Hobby;
import org.springframework.transaction.TransactionDefinition;

import javax.naming.event.ObjectChangeListener;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.util.Date;

/**
 * Created by multi on 22.04.2016.
 */

@StaticMetamodel(Contact.class)
public class Contact_ {
    public static volatile SingularAttribute<Contact, Long> id;
    public static volatile SetAttribute<Contact, ContactTelDetail> contactTelDetails;
    public static volatile SingularAttribute<Contact, String> firstName;
    public static volatile SingularAttribute<Contact, String> lastName;
    public static volatile SingularAttribute<Contact, Date> birthDate;
    public static volatile SetAttribute<Contact, Hobby> hobbies;
    public static volatile SingularAttribute<Contact, Integer> version;
}
