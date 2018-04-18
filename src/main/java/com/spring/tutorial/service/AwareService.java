package com.spring.tutorial.service;

import java.util.Arrays;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.ImportAware;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.stereotype.Service;

@Service("awareService")
public class AwareService implements ApplicationContextAware, ApplicationEventPublisherAware, BeanClassLoaderAware,
		BeanFactoryAware, BeanNameAware, EnvironmentAware, ImportAware, ResourceLoaderAware {

	public void setApplicationContext(ApplicationContext ctx) throws BeansException {
		System.out.println("setApplicationContext called");
		System.out.println(
				"setApplicationContext:: Bean Definition Names=" + Arrays.toString(ctx.getBeanDefinitionNames()));
	}

	public void setBeanName(String beanName) {
		System.out.println(" setBeanName called");
		System.out.println("setBeanName:: Bean Name defined in context=" + beanName);
	}

	public void setBeanClassLoader(ClassLoader classLoader) {
		System.out.println(" setBeanClassLoader called");
		System.out.println("setBeanClassLoader:: ClassLoader Name=" + classLoader.getClass().getName());
	}

	public void setResourceLoader(ResourceLoader resourceLoader) {
		System.out.println(" setResourceLoader called");
		Resource resource = resourceLoader.getResource("classpath:spring.xml");
		System.out.println("setResourceLoader:: Resource File Name=" + resource.getFilename());
	}

	public void setImportMetadata(AnnotationMetadata annotationMetadata) {
		System.out.println(" setImportMetadata called");
	}

	public void setEnvironment(Environment env) {
		System.out.println("setEnvironment called");
	}

	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println("setBeanFactory called");
		System.out.println("setBeanFactory:: employeeManager bean singleton= " + beanFactory.isSingleton("employeeManager"));
	}

	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		System.out.println("setApplicationEventPublisher called");
	}

}