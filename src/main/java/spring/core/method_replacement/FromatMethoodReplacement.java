package spring.core.method_replacement;

import org.springframework.beans.factory.support.MethodReplacer;

import java.lang.reflect.Method;

/**
 * Created by multi on 21.04.2016.
 */
public class FromatMethoodReplacement implements MethodReplacer {
    public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
        String msg = (String) args[0];
        return "Replaced " + msg;
    }
}
