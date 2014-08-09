package com.ofg.microservice

import com.ofg.infrastructure.environment.EnvironmentSetupVerifier
import groovy.transform.TypeChecked
import org.springframework.amqp.core.BindingBuilder
import org.springframework.amqp.core.TopicExchange
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.social.FacebookAutoConfiguration
import org.springframework.cache.annotation.EnableCaching
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.EnableAspectJAutoProxy
import org.springframework.scheduling.annotation.EnableAsync
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
@TypeChecked
@Configuration
@EnableAutoConfiguration(exclude = [FacebookAutoConfiguration])
@EnableAspectJAutoProxy(proxyTargetClass = true)
@ComponentScan(basePackages = ["com.ofg.microservice", "com.mangofactory.swagger"])
//@EnableCaching
@EnableAsync
class Application {
    final static String queueName = "facebook";
    final static String topicName = "facebook";
    static void main(String[] args) {
        SpringApplication application = new SpringApplication(Application)
        application.addListeners(new EnvironmentSetupVerifier(Profiles.all()))
        application.run(args)
    }

//    	@Bean
//    	Queue queue() {
//    		return new Queue(queueName, false);
//    	}
//
//    	@Bean
//    	TopicExchange exchange() {
//    		return new TopicExchange(topicName);
//    	}
//
//    	@Bean
//    	Binding binding(Queue queue, TopicExchange exchange) {
//    		return BindingBuilder.bind(queue).to(exchange).with(queueName);
//    	}

}
