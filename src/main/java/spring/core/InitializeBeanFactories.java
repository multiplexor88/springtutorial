package spring.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * Created by multi on 20.04.2016.
 */
public class InitializeBeanFactories {
    public static final Logger log = LoggerFactory.getLogger(InitializeBeanFactories.class);

    public static void main(String[] args) {
        log.debug("Custom factory");
        DefaultListableBeanFactory factory1 = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory1);
        reader.loadBeanDefinitions("classpath:spring/core/beanFactoryConfiguration.xml");
        SimpleBean bean1 = factory1.getBean(SimpleBean.class);
        log.debug(bean1.getName());
        AnnotatedSimpleBean bean2 = factory1.getBean(AnnotatedSimpleBean.class);
        log.debug(bean2.getName());

        log.debug("ClassPathXmlApplicationContext factory");
        ApplicationContext factory2 = new ClassPathXmlApplicationContext("spring/core/beanFactoryConfiguration.xml");
        bean2 = factory2.getBean(AnnotatedSimpleBean.class);
        log.debug(bean2.getName());

        log.debug("GenericXmlApplicationContext factory");
        GenericXmlApplicationContext factory3 = new GenericXmlApplicationContext();
        factory3.load("spring/core/beanFactoryConfiguration.xml");
        factory3.refresh();
        bean2 = factory3.getBean(AnnotatedSimpleBean.class);
        log.debug(bean2.getName());

        log.debug("Extracting beans from container");
        SetterDIBean setterDIBean = factory2.getBean(SetterDIBean.class);
        log.debug("Injected simpleBean in setterDIBean value: " + setterDIBean.getSimpleBean().getName());

        AnnotatedAutowiredSetterDIBean annotatedAutowiredSetterDIBean = factory2.getBean(AnnotatedAutowiredSetterDIBean.class);
        log.debug("Injected simpleBean in annotatedAutowiredSetterDIBean value: " + annotatedAutowiredSetterDIBean.getSimpleBean().getName());

        ConstructorDIBean constructorDIBean = factory2.getBean(ConstructorDIBean.class);
        log.debug("Injected simpleBean in constructorDIBean value: " + constructorDIBean.getSimpleBean().getName());

        ConstructorDIBeanWithMessage constructorDIBeanWithMessage = factory2.getBean("constructorDIBeanWithMessage", ConstructorDIBeanWithMessage.class);
        log.debug("Injected message in constructorDIBeanWithMessage value: " + constructorDIBeanWithMessage.getMessage());

        ConstructorDIBeanWithMessage constructorDIBeanWithMessageWith2Messages = factory2.getBean("constructorDIBeanWith2Messages", ConstructorDIBeanWithMessage.class);
        log.debug("Injected message in constructorDIBeanWithMessage values: " + constructorDIBeanWithMessageWith2Messages.getMessage() +
                " " + constructorDIBeanWithMessageWith2Messages.getSecondaryMessage());

        AnnotatedAutowiredConstructorDIBeanWith2Messages annotatedAutowiredConstructorDIBeanWith2Messages = factory2.getBean(AnnotatedAutowiredConstructorDIBeanWith2Messages.class);
        log.debug("Injected message in annotatedAutowiredConstructorDIBeanWith2Messages values: " + annotatedAutowiredConstructorDIBeanWith2Messages.getMessage() +
                " " + annotatedAutowiredConstructorDIBeanWith2Messages.getSecondaryMessage());

        InjectValuesBySpELBean injectValuesBySpELBean = factory2.getBean(InjectValuesBySpELBean.class);
        log.debug("injectValuesBySpELBean: " + injectValuesBySpELBean);

        GenericXmlApplicationContext childOfFactory2 = new GenericXmlApplicationContext();
        childOfFactory2.load("classpath:spring/core/childAppContext.xml");
        childOfFactory2.setParent(factory2);
        childOfFactory2.refresh();

        SimpleBeanFromChildAppContext simpleBeanFromChildAppContext = childOfFactory2.getBean(SimpleBeanFromChildAppContext.class);
        log.debug("SimpleBeanFromChildAppContext: " + simpleBeanFromChildAppContext.getName());

        SimpleBean simpleBeanFromChild = childOfFactory2.getBean(SimpleBean.class);
        log.debug("Extract SimpleBean by child factory: " + simpleBeanFromChild.getName());

        CollectionsInject collectionsInject = childOfFactory2.getBean(CollectionsInject.class);
        log.debug("CollectionsInject: " + collectionsInject);

    }
}
