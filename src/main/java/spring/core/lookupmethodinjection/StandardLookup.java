package spring.core.lookupmethodinjection;

/**
 * Created by multi on 21.04.2016.
 */
public class StandardLookup implements DemoBean {
    private MyHelper myHelper;
    public MyHelper getMyHelper() {
        return myHelper;
    }

    public void someOperation() {
        myHelper.operation();
    }

    public void setMyHelper(MyHelper myHelper) {
        this.myHelper = myHelper;
    }
}
