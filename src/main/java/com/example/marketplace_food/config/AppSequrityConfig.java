package com.example.marketplace_food.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.filter.HiddenHttpMethodFilter;

import javax.servlet.ServletContext;

@Configuration
public class AppSequrityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("producer1").password(passwordEncoder().encode("producer1")).roles("PRODUCER")
                .and()
                .withUser("producer2").password(passwordEncoder().encode("producer2")).roles("PRODUCER")
                .and()
                .withUser("producer3").password(passwordEncoder().encode("producer3")).roles("PRODUCER")
                .and()
                .withUser("consumer1").password(passwordEncoder().encode("consumer1")).roles("CONSUMER")
                .and()
                .withUser("consumer2").password(passwordEncoder().encode("consumer2")).roles("CONSUMER")
                .and()
                .withUser("consumer3").password(passwordEncoder().encode("consumer3")).roles("CONSUMER");
    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/basket").hasRole("CONSUMER")
                .antMatchers("/producer", "/edit", "/delete").hasRole("PRODUCER")
                .anyRequest().permitAll()
                .and().logout().logoutSuccessUrl("/")
                .and().formLogin();

    }
}
