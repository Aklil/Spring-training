package com.aklil.gswebsecurity.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


//Step 1: only security on a class path

//step 2: add configuration and use in memory auth

@Configuration
@EnableWebSecurity   //enables Spring Security’s web security support and provide the Spring MVC integration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

/*
    * STEP 1: with default login page
    * STEP 2: In memory auth with custom login page
    * STEP 3: Auth against DB
    *
    *
    *
     * NOTES: antMatcher vs mvcMathers
     *  https://stackoverflow.com/questions/50536292/difference-between-antmatcher-and-mvcmatcher
     **/


  @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .authorizeRequests()
                    .mvcMatchers("/", "/home").permitAll() //public unauthenticated pages
                    //.mvcMatchers("/employee**").hasRole("USER")
                    .anyRequest().authenticated()// other must be authenticated
                    .and()
                .formLogin()
                    .loginPage("/login")
                    .permitAll()
                    .and()
                .logout()
                    .permitAll();
    }

   /* @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {


       auth
               .inMemoryAuthentication()
               .withUser("dave")
               .password("{noop}1234")
               .roles("USER")
               .and()
               .withUser("abe")
               .password("{noop}1234")
               .roles("USER");


       //.secret(passwordEncoder.encode("secret"))
    }*/

    @Autowired
    private AppUserDetailService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }


    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }



/**
     * The userDetailsService() method sets up an in-memory user store with a single user.
     * That user is given a user name of user, a password of password, and a role of USER.
     *


@Bean     //Configure the UserDetailsService bean used by Spring Security
    @Override
    public UserDetailsService userDetailsService() {

        UserDetails user =
                User.withDefaultPasswordEncoder()
                    .username("user")
                    .password("password")
                    .roles("USER")
                    .build();

        //Note: User.withDefaultPasswordEncoder() is considered unsafe for production and is only intended for sample applications


        return new InMemoryUserDetailsManager(user);
    }*/

}
