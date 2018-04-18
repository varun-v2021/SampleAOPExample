package com.spring.tutorial.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = {"com.spring.tutorial"})
//this is same as <aop:aspectj-autoproxy /> defined in applicationContext.xml
//will enable support for handling components marked with AspectJ’s @Aspect annotation.
@EnableAspectJAutoProxy	
public class AppConfig {

}
