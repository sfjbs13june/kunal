package com.kunal.app.config;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HospitalSecurity extends WebSecurityConfigurerAdapter{

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().and().authorizeRequests()
                .antMatchers(HttpMethod.GET,"/doctor/doctorappointment").hasAnyRole("DOCTOR")
                .antMatchers(HttpMethod.POST,"/doctor/save").hasAnyRole("DOCTOR")
                .antMatchers(HttpMethod.GET,"/prescription/viewprescription").hasAnyRole("DOCTOR","PATIENT")
                .antMatchers(HttpMethod.POST,"/prescription/saveprescription").hasAnyRole("DOCTOR","PATIENT")
                .antMatchers(HttpMethod.GET,"/patient/myappointment").hasAnyRole("PATIENT")
                .antMatchers(HttpMethod.POST,"/patient/save").hasAnyRole("PATIENT")
                .and().csrf().disable().headers()
                .frameOptions().disable();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("doctor1").password("{noop}password").roles("DOCTOR").and()
                .withUser("patient1").password("{noop}password").roles("PATIENT");
    }
}