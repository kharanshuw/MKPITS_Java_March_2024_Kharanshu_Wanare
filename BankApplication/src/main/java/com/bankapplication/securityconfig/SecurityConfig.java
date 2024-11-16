package com.bankapplication.securityconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class SecurityConfig {

	// Bean to manage user details using JDBC
	@Bean
	public UserDetailsManager userDetailsManager(DataSource dataSource) {
		JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

		// Custom query to fetch user details

		jdbcUserDetailsManager.setUsersByUsernameQuery("select email,password,enable from users where email=? ");

		// Custom query to fetch user authorities/roles

		jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
				"select u.email as username, a.role_name as authority from users u join user_role ua on u.id=ua.user_id join role a on a.id=ua.role_id where u.email=?");

		return jdbcUserDetailsManager;
	}

	// Bean to configure the security filter chain

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.authorizeHttpRequests(c ->

		// Permit all users to access these paths
		c.requestMatchers("/login", "/logout", "/", "/register", "/processregistration").permitAll()

				.requestMatchers("/successful/**", "/successful", "/access-denied", "/error").permitAll()

				// Only allow users with user role,or admin role to access /home2
				.requestMatchers(HttpMethod.GET, "/home2").hasAnyRole("USER", "ADMIN")

				.requestMatchers("/admin/profile").hasRole("ADMIN")

//                                .requestMatchers("/").hasRole("USER")

				.requestMatchers(HttpMethod.GET, "/admin/alluser").hasRole("ADMIN")

				.requestMatchers("/admin/pending").hasRole("ADMIN")

				.requestMatchers("/admin/request").hasRole("ADMIN")

				.requestMatchers(HttpMethod.GET, "/admin/rolemanagement").hasRole("ADMIN")

				.requestMatchers(HttpMethod.GET, "/admin/addrolepage").hasRole("ADMIN")

				.requestMatchers(HttpMethod.GET, "/admin/removerolepage").hasRole("ADMIN")

				.requestMatchers(HttpMethod.GET, "/admin/addrole").hasRole("ADMIN")

				.requestMatchers(HttpMethod.GET, "/admin/removerole").hasRole("ADMIN")

				.requestMatchers(HttpMethod.GET, "/user/profile").hasRole("USER")

				.requestMatchers(HttpMethod.GET, "/admin/home").hasRole("ADMIN")

				.requestMatchers(HttpMethod.GET, "/api/countries").permitAll()

				.requestMatchers(HttpMethod.GET, "/api/states/**").permitAll()

				.requestMatchers(HttpMethod.GET, "/api/districts/**").permitAll()

				.requestMatchers(HttpMethod.GET, "/api/**").permitAll()
				
				.requestMatchers(HttpMethod.GET,"/api/cities/**").permitAll()

				.requestMatchers(HttpMethod.GET, "/user/update").hasRole("USER")

				.requestMatchers(HttpMethod.POST, "/user/processupdate").hasRole("USER")

				.requestMatchers(HttpMethod.GET, "/user/home").hasRole("USER")

				.requestMatchers(HttpMethod.GET, "/admin/update").hasRole("ADMIN")
				
				.requestMatchers(HttpMethod.GET,"/admin/processupdate").hasRole("ADMIN")
				
				.requestMatchers(HttpMethod.GET,"/admin/branch/create").hasRole("ADMIN")
				
				.requestMatchers(HttpMethod.POST,"/admin/branch/processbranch").hasRole("ADMIN")

				.anyRequest().authenticated()

		).formLogin(
				// Custom login page
				// URL to submit the username and password

				f -> f.loginPage("/login")

						// URL to submit the username and password
						.loginProcessingUrl("/authenticatetheuser")

						// Redirect to home2 after a successful login
						.defaultSuccessUrl("/home2", true)

						.permitAll()

		)

				// Allow all users to logout
				.logout(LogoutConfigurer::permitAll)

				// Disable CSRF protection
				.csrf(AbstractHttpConfigurer::disable)

				// Redirect to access denied page if authorization fails
				.exceptionHandling(configure -> configure.accessDeniedPage("/access-denied"));

		// Enable basic authentication
		httpSecurity.httpBasic(Customizer.withDefaults());

		return httpSecurity.build();
	}
}
