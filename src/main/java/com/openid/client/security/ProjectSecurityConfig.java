package com.openid.client.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class ProjectSecurityConfig  {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        System.out.println("in security ");

        http.authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/userportal").authenticated()
                        .anyRequest().permitAll()
                )
                .oauth2Login(withDefaults())
                .logout((logout) -> logout.permitAll());
        return http.build();


                /*
        .formLogin((form) -> form
                .loginPage("/login")
                .permitAll()
        )*/

    }
/*
    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user =
                User.withDefaultPasswordEncoder()
                        .username("user")
                        .password("password")
                        .roles("USER")
                        .build();

        return new InMemoryUserDetailsManager(user);
    }*/
}
