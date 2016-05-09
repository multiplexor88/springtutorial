package hibernate.mapping;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Igor Dumchykov on 07.05.2016.
 */
@Entity
@Table(name = "another_terminal")
//@SecondaryTable(name = "terminal_company", pkJoinColumns = @PrimaryKeyJoinColumn(name = "terminal_vin"))
public class AnotherTerminal implements Serializable{
    private String id;
    private String vin;
    private String fieldA;

    @Column(name = "field_a")
    public String getFieldA() {
        return fieldA;
    }

    public void setFieldA(String fieldA) {
        this.fieldA = fieldA;
    }

    @Column(name = "vin")
    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "AnotherTerminal{" +
                "id='" + id + '\'' +
                ", vin='" + vin + '\'' +
                ", fieldA='" + fieldA + '\'' +
//                ", companyId='" + companyId + '\'' +
                '}';
    }
}
