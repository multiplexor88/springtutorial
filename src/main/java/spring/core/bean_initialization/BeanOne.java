package spring.core.bean_initialization;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by multi on 25.04.2016.
 */
public class BeanOne implements InitializingBean, BeanNameAware{
    private String name;
    private String beanName;
    private int age = Integer.MIN_VALUE;
    public static final String DEFAULT_NAME = "Luke Skywalker";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void init(){
        System.out.println("Initialize:" + BeanOne.class.getName());
        if(name == null){
            System.out.println("Using default name for bean: " + beanName);
            name = DEFAULT_NAME;
        }
        if(age == Integer.MIN_VALUE){
            throw new IllegalArgumentException("You must set age property for bean: " + BeanOne.class);
        }
    }

    @Override
    public String toString() {
        return "BeanOne{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("After properties set for bean: " + beanName);
    }

    @PostConstruct
    private void postConstrut(){
        System.out.println("Postconstruct for bean: " + beanName);
    }

    @PreDestroy
    private void preDestroy(){
        System.out.println("Predestroy for bean: " + beanName);
    }

    @Override
    public void setBeanName(String name) {
        this.beanName = name;
    }
}
