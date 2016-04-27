package spring.core.lookupmethodinjection;

/**
 * Created by multi on 21.04.2016.
 */
public abstract class AbstractLookup implements DemoBean{
    public abstract MyHelper getMyHelper();
    public void someOperation() {
        getMyHelper().operation();
    }
}
