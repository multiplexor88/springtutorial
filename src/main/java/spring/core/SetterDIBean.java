package spring.core;

/**
 * Created by multi on 20.04.2016.
 */
public class SetterDIBean {
    private SimpleBean simpleBean;

    public SimpleBean getSimpleBean() {
        return simpleBean;
    }

    public void setSimpleBean(SimpleBean simpleBean) {
        this.simpleBean = simpleBean;
    }
}
