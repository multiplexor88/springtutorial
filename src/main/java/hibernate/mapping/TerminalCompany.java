package hibernate.mapping;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Igor Dumchykov on 08.05.2016.
 */
@Entity
@Table(name = "terminal_company")
public class TerminalCompany implements Serializable {
    private String id;
    private String vin;
    private String companyId;

    @Id
    @Column(name = "id", unique = true, nullable = false)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(name = "vin", unique = true, nullable = false)
    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    @Column(name = "company_id", unique = true, nullable = false)
    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    @Override
    public String toString() {
        return "TerminalCompany{" +
                "id='" + id + '\'' +
                ", vin='" + vin + '\'' +
                ", companyId='" + companyId + '\'' +
                '}';
    }
}
