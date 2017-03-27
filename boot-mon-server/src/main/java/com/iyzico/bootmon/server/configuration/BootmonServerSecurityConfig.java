package com.iyzico.bootmon.server.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class BootmonServerSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    BootmonServerProperties properties;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .headers()
                .frameOptions()
                .disable();

        if (properties.isSecurityEnabled()) {
            http
                    .authorizeRequests()
                    .anyRequest()
                    .fullyAuthenticated()
                    .and()
                    .httpBasic();
        }
    }

    @Autowired
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        if (properties.isSecurityEnabled()) {
            auth.inMemoryAuthentication()
                    .withUser(properties.getServerUserName())
                    .password(properties.getServerPassword())
                    .roles("USER");
        }
    }
}
