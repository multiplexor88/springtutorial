package spring.core.bean_initialization;

/**
 * Created by multi on 25.04.2016.
 */
public class UserName {
    private String f_name;
    private String l_name;

    public UserName(String f_name, String l_name) {
        this.f_name = f_name;
        this.l_name = l_name;
    }

    public String getF_name() {
        return f_name;
    }

    public void setF_name(String f_name) {
        this.f_name = f_name;
    }

    public String getL_name() {
        return l_name;
    }

    public void setL_name(String l_name) {
        this.l_name = l_name;
    }

    @Override
    public String toString() {
        return "UserName{" +
                "f_name='" + f_name + '\'' +
                ", l_name='" + l_name + '\'' +
                '}';
    }
}
