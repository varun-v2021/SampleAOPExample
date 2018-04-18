# SampleAOPExample

# Spring IoC Container

Spring IoC container classes are part of org.springframework.beans and org.springframework.context packages. Spring IoC container provides us different ways to decouple the object dependencies.

BeanFactory is the root interface of Spring IoC container. ApplicationContext is the child interface of BeanFactory interface that provide Spring AOP features, i18n etc.

Some of the useful child-interfaces of ApplicationContext are ConfigurableApplicationContext and WebApplicationContext. Spring Framework provides a number of useful ApplicationContext implementation classes that we can use to get the spring context and then the Spring Bean.

Some of the useful ApplicationContext implementations that we use are;

AnnotationConfigApplicationContext: If we are using Spring in standalone java applications and using annotations for Configuration, then we can use this to initialize the container and get the bean objects.

ClassPathXmlApplicationContext: If we have spring bean configuration xml file in standalone application, then we can use this class to load the file and get the container object.

FileSystemXmlApplicationContext: This is similar to ClassPathXmlApplicationContext except that the xml configuration file can be loaded from anywhere in the file system.

AnnotationConfigWebApplicationContext and XmlWebApplicationContext for web applications.
Usually if you are working on Spring MVC application and your application is configured to use Spring Framework, Spring IoC container gets initialized when application starts and when a bean is requested, the dependencies are injected automatically.

However for standalone application, you need to initialize the container somewhere in the application and then use it to get the spring beans.


# Spring Aware Interfaces


Sometimes we need Spring Framework objects in our beans to perform some operations, for example reading ServletConfig and ServletContext parameters or to know the bean definitions loaded by the ApplicationContext. That’s why spring framework provides a bunch of *Aware interfaces that we can implement in our bean classes.

org.springframework.beans.factory.Aware is the root marker interface for all these Aware interfaces. All of the *Aware interfaces are sub-interfaces of Aware and declare a single setter method to be implemented by the bean. Then spring context uses setter-based dependency injection to inject the corresponding objects in the bean and make it available for our use.

Spring Aware interfaces are similar to servlet listeners with callback methods and implementing observer design pattern.

Some of the important Aware interfaces are:

ApplicationContextAware – to inject ApplicationContext object, example usage is to get the array of bean definition names.
BeanFactoryAware – to inject BeanFactory object, example usage is to check scope of a bean.
BeanNameAware – to know the bean name defined in the configuration file.
ResourceLoaderAware – to inject ResourceLoader object, example usage is to get the input stream for a file in the classpath.
ServletContextAware – to inject ServletContext object in MVC application, example usage is to read context parameters and attributes.
ServletConfigAware – to inject ServletConfig object in MVC application, example usage is to get servlet config parameters


References:
https://www.journaldev.com/2461/spring-ioc-bean-example-tutorial
https://www.journaldev.com/2637/spring-bean-life-cycle
https://www.journaldev.com/2888/spring-tutorial-spring-core-tutorial
