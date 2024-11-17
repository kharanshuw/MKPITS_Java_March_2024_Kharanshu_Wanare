package com.usermanagement.securityconfig;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class UserSecurityConfig {

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        jdbcUserDetailsManager.setUsersByUsernameQuery("select email,password,enable from users where email=? ");

        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("select u.email as username, a.role AS authority from users u join users_authorities ua on u.id=ua.user_id join authorities a on a.id=ua.authorities_id where u.email=?");

        return jdbcUserDetailsManager;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(
                        c -> c.requestMatchers("/resources/**", "/login", "/logout", "/signup", "/register").permitAll()
                                .requestMatchers(HttpMethod.GET, "/home").hasRole("USER")
                                .anyRequest().authenticated()

                )
                .formLogin(
                        f -> f.loginPage("/login")
                                .loginProcessingUrl("/authenticateTheUser")
                                .permitAll()
                )

        ;


        httpSecurity.csrf(csrf -> csrf.disable());

        httpSecurity.httpBasic(Customizer.withDefaults());


        return httpSecurity.build();

    }


}


