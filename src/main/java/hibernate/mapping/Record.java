package hibernate.mapping;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Igor Dumchykov on 08.05.2016.
 */
@Entity
@Table(name = "record")
public class Record implements Serializable{
    private String id;
    private String vin;

    private TerminalCompany terminalCompany;

    @ManyToOne
    @JoinColumn(name = "vin", referencedColumnName = "vin", insertable = false, updatable = false)
    public TerminalCompany getTerminalCompany() {
        return terminalCompany;
    }

    public void setTerminalCompany(TerminalCompany terminalCompany) {
        this.terminalCompany = terminalCompany;
    }

    @Id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    @Override
    public String toString() {
        String str = null;
        if(terminalCompany != null){
            str = terminalCompany.toString();
        }
        return "Record{" +
                "id='" + id + '\'' +
                ", vin='" + vin + '\'' +
                ", terminalCompany=" + str +
                '}';
    }
}
