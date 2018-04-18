# SampleAOPExample


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


Reference:
https://www.journaldev.com/2461/spring-ioc-bean-example-tutorial
