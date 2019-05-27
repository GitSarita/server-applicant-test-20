//package com.mytaxi.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//
//@Configuration
//@EnableWebSecurity
//public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//
//        auth.inMemoryAuthentication()
//                .withUser("user").password("{noop}password").roles("USER");
//
//    }
//
//    // Secure the endpoints with HTTP Basic authentication
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//
//        http
//                .authorizeRequests()
//                .antMatchers("/drivers/*").hasRole("USER")
//                .antMatchers("/cars/**").hasRole("USER")
//                .antMatchers("/searches/**").hasRole("USER")
//                .and()
//                .httpBasic();
////                .and()
////                .csrf().disable().headers().frameOptions().disable();
//    }
//
//    @Bean
//    public static NoOpPasswordEncoder passwordEncoder(){
//         return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
//    }
//
//}
