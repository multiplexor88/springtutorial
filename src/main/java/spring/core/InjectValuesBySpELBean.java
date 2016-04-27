package spring.core;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by multi on 20.04.2016.
 */
@Component
public class InjectValuesBySpELBean {
    @Value("#{constants._intVal}")
    private int intVal;
    @Value("#{constants._stringVal}")
    private String stringVal;
    @Value("#{constants._doubleVal}")
    private double doubleVal;
    @Value("#{constants._boolVal}")
    private boolean boolVal;
    @Value("#{constants._floatVal}")
    private float floatVal;
    @Value("#{constants._longVal}")
    private long longVal;

    public int getIntVal() {
        return intVal;
    }

    public void setIntVal(int intVal) {
        this.intVal = intVal;
    }

    public String getStringVal() {
        return stringVal;
    }

    public void setStringVal(String stringVal) {
        this.stringVal = stringVal;
    }

    public double getDoubleVal() {
        return doubleVal;
    }

    public void setDoubleVal(double doubleVal) {
        this.doubleVal = doubleVal;
    }

    public boolean isBoolVal() {
        return boolVal;
    }

    public void setBoolVal(boolean boolVal) {
        this.boolVal = boolVal;
    }

    public float getFloatVal() {
        return floatVal;
    }

    public void setFloatVal(float floatVal) {
        this.floatVal = floatVal;
    }

    public long getLongVal() {
        return longVal;
    }

    public void setLongVal(long longVal) {
        this.longVal = longVal;
    }


    @Override
    public String toString() {
        return "InjectValuesBySpELBean{" +
                "intVal=" + intVal +
                ", stringVal='" + stringVal + '\'' +
                ", doubleVal=" + doubleVal +
                ", boolVal=" + boolVal +
                ", floatVal=" + floatVal +
                ", longVal=" + longVal +
                '}';
    }
}


