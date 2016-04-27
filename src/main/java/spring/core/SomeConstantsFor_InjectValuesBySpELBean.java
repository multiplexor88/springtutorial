package spring.core;

import org.springframework.stereotype.Component;

/**
 * Created by multi on 20.04.2016.
 */
@Component("constants")
public class SomeConstantsFor_InjectValuesBySpELBean {
    public int _intVal=1;
    public String _stringVal="string";
    public double _doubleVal=1.0;
    public boolean _boolVal=false;
    public float _floatVal=1.0f;
    public long _longVal=1L;
}
