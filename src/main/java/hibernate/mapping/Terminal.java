package hibernate.mapping;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Igor Dumchykov on 07.05.2016.
 */
@Entity
@Table(name = "terminal")
//@SecondaryTable(name = "terminal_company", pkJoinColumns = @PrimaryKeyJoinColumn(name = "terminal_vin"))
public class Terminal implements Serializable{
    private String id;
    private String terminalVin;

    private TerminalCompany terminalCompany;

    private Company company;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "terminal_vin", referencedColumnName = "vin", insertable = false, updatable = false)
    public TerminalCompany getTerminalCompany() {
        return terminalCompany;
    }

    public void setTerminalCompany(TerminalCompany terminalCompany) {
        this.terminalCompany = terminalCompany;
    }

    //    @OneToOne
//    @JoinColumn(name = "vin", referencedColumnName = "vin", insertable = false, updatable = false)
//    public AnotherTerminal getAnotherTerminal() {
//        return anotherTerminal;
//    }
//
//    public void setAnotherTerminal(AnotherTerminal anotherTerminal) {
//        this.anotherTerminal = anotherTerminal;
//    }

    //    @ManyToOne(targetEntity = Company.class)
//    @JoinTable(name = "terminal_company",
//            joinColumns = @JoinColumn(name = "terminal_id"),
//            inverseJoinColumns = @JoinColumn(name = "company_id"))
//    public Company getCompany() {
//        return company;
//    }
//    public void setCompany(Company company) {
//        this.company = company;
//    }

    @Column(name = "terminal_vin")
    public String getTerminalVin() {
        return terminalVin;
    }

    public void setTerminalVin(String terminalVin) {
        this.terminalVin = terminalVin;
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
        String str = null;
        if(terminalCompany != null) {
            str = terminalCompany.toString();
        }
//        String str2 = null;
//        if(anotherTerminal != null){
//            str2 = anotherTerminal.toString();
//        }
        return "Terminal{" +
                "id='" + id + '\'' +
                ", vin='" + terminalVin + '\'' +
                ", company='" + str + '\'' +
//                ", another='" + str2 + '\'' +
                '}';
    }
}
