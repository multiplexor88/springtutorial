package spring.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by multi on 20.04.2016.
 */
@Component
public class AnnotatedAutowiredSetterDIBean {
    private SimpleBean simpleBean;

    public SimpleBean getSimpleBean() {
        return simpleBean;
    }
    @Autowired
    public void setSimpleBean(SimpleBean simpleBean) {
        this.simpleBean = simpleBean;
    }
}
