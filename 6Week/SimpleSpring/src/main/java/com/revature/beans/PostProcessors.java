package com.revature.beans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PostProcessors {

	@Bean
	public BeanPostProcessor processor() {
		return new MyPostProcessor("This Is some Custom Config");
	}
	
	class MyPostProcessor implements BeanPostProcessor{
		
		private String config;
		public MyPostProcessor(String config) {
			this.config = config;
		}

		public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
			//with the post processor you directly get the created and whatever you return becomes that bean
			System.out.println("Step 4: Post Processor Before");
			System.out.println("BeanName is: " + beanName);
			return bean;
		}

		public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
			System.out.println("Step 7: Post Processor After");
			System.out.println("BeanName is: " + beanName);
			return bean;
		}
		
	}
	
}
