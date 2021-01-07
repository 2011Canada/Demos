package com.revature.beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.revature.services.UserService;

@Component
public class LifeCycleBean implements ApplicationContextAware, BeanNameAware, BeanFactoryAware, InitializingBean, DisposableBean{
	
	
	private UserService us;
	
	public LifeCycleBean() {
		System.out.println("Step 1: Instantiation");
	}

	@Autowired//Hey Spring, find a UserService Bean and call this method with that bean
	public void setUs(UserService us) {
		this.us = us;
		System.out.println("Step 2: Populating Properties");
	}

	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		// TODO Auto-generated method stub
		System.out.println("Step 3: beanFactory here");
	}

	public void setBeanName(String name) {
		System.out.println("Step 3: My name is " + name);
		
	}

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		// TODO Auto-generated method stub
		System.out.println("Step 3: ApplicationContext here");
	}

	public void afterPropertiesSet() throws Exception {
		System.out.println("Step 6: Initializing Bean");
		
	}

	@PostConstruct
	public void customInit() {
		System.out.println("Step 5: Custom init");
	}

	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Step 10: Disposable Bean");
	}
	
	@PreDestroy
	public void customDestroy() {
		System.out.println("Step 9: Custom Destroy");
	}
	
}
