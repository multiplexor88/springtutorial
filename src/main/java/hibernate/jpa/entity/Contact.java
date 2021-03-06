package hibernate.jpa.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by multi on 21.04.2016.
 */
@Entity
@Table(name="contact")
@NamedQueries({
        @NamedQuery(name = "Contact.findAllWithDetail",
        query = "select distinct c from Contact c left join fetch c.contactTelDetails t " +
                "left join fetch c.hobbies h"),
        @NamedQuery(name = "Contact.findById",
                query = "select distinct c from Contact c left join fetch c.contactTelDetails t " +
                        "left join fetch c.hobbies h where c.id = :id"),
        @NamedQuery(name = "Contact.findAll", query = "select c from Contact c")
})
@SqlResultSetMappings({
        @SqlResultSetMapping(
                name = "contactResult",
                entities = @EntityResult(entityClass = Contact.class)
        ),
        @SqlResultSetMapping(
                name = "contactSummaryResult",
                classes = {
                        @ConstructorResult(
                                targetClass = ContactSummary.class,
                                columns = {
                                        @ColumnResult(name = "firstName"),
                                        @ColumnResult(name = "lastName"),
                                        @ColumnResult(name = "telNumber")
                                }
                        )
                }
        )
})
public class Contact implements Serializable{

    private Long id;

    private int version;

    private String firstName;

    private String lastName;

    private Date birthDate;

    private Set<ContactTelDetail> contactTelDetails = new HashSet<>();

    private Set<Hobby> hobbies = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "contact_hobby_detail", joinColumns = @JoinColumn(name = "CONTACT_ID"),
    inverseJoinColumns = @JoinColumn(name="HOBBY_ID"))
    public Set<Hobby> getHobbies() {
        return hobbies;
    }

    public void setHobbies(Set<Hobby> hobbies) {
        this.hobbies = hobbies;
    }

    @OneToMany(mappedBy = "contact", cascade = CascadeType.ALL, orphanRemoval = true)
    public Set<ContactTelDetail> getContactTelDetails() {
        return this.contactTelDetails;
    }

    public void setContactTelDetails(Set<ContactTelDetail> contactTelDetails) {
        this.contactTelDetails = contactTelDetails;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Version
    @Column(name = "VERSION")
    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @Column(name = "FIRST_NAME")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "LAST_NAME")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "BIRTH_DATE")
    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", version=" + version +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", contactTelDetails=" + contactTelDetails +
                ", hobbies=" + hobbies +
                '}';
    }

}
