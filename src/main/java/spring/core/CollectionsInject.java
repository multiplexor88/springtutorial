package spring.core;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * Created by multi on 21.04.2016.
 */
public class CollectionsInject {

    private List myList;
    private Set mySet;
    private Map<String, Object> myMap;
    private Properties myProps;

    public List getMyList() {
        return myList;
    }

    public void setMyList(List myList) {
        this.myList = myList;
    }

    public Set getMySet() {
        return mySet;
    }

    public void setMySet(Set mySet) {
        this.mySet = mySet;
    }

    public Map<String, Object> getMyMap() {
        return myMap;
    }

    public void setMyMap(Map<String, Object> myMap) {
        this.myMap = myMap;
    }

    public Properties getMyProps() {
        return myProps;
    }

    public void setMyProps(Properties myProps) {
        this.myProps = myProps;
    }

    @Override
    public String toString() {
        return "CollectionsInject{" +
                "myList=" + myList +
                ", mySet=" + mySet +
                ", myMap=" + myMap +
                ", myProps=" + myProps +
                '}';
    }
}
