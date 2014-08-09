package com.ofg.microservice.facebook

import groovy.transform.TypeChecked
import org.springframework.boot.bind.RelaxedPropertyResolver
import org.springframework.context.EnvironmentAware
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Scope
import org.springframework.core.env.Environment
import org.springframework.social.facebook.api.Facebook
import org.springframework.social.facebook.connect.FacebookConnectionFactory
import org.springframework.social.oauth2.AccessGrant

import javax.servlet.http.HttpServletRequest

import static org.springframework.context.annotation.ScopedProxyMode.INTERFACES

@Configuration
@TypeChecked
class FacebookConfig implements EnvironmentAware {

    public static final String AUTH_PREFIX = 'bearer '

    private RelaxedPropertyResolver properties;

    @Override
    void setEnvironment(Environment environment) {
        properties = new RelaxedPropertyResolver(environment, 'spring.social.facebook.');
    }

    @Bean
    FacebookConnectionFactory facebookConnectionFactory() {
        return new FacebookConnectionFactory(
            properties.getRequiredProperty('app-id'),
            properties.getRequiredProperty('app-secret'));
    }

    @Bean
    @Scope(value = "request", proxyMode = INTERFACES)
    Facebook facebook(HttpServletRequest request) {
        String header = request.getHeader('Authorization')
        String token = (header.toLowerCase().startsWith(AUTH_PREFIX) ?
            header.substring(AUTH_PREFIX.length()) : header)
        return facebookConnectionFactory().createConnection(new AccessGrant(token)).api
    }

}