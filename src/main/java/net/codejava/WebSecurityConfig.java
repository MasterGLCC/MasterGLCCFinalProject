package net.codejava;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private DataSource dataSource;
	
	@Bean
	public UserDetailsService userDetailsService() {
		return new CustomUserDetailsService();
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService());
		authProvider.setPasswordEncoder(passwordEncoder());
		
		return authProvider;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}

	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/users").authenticated()
			.antMatchers("/dashboard").authenticated()// Require authentication for dashboard.
			.antMatchers("/ourForums").authenticated()
			.antMatchers("/createASK").authenticated()
			.antMatchers("/createForum").authenticated()
			.antMatchers("/showForumSpec/*").authenticated()
			.antMatchers("/deleteForumSpec/*").authenticated()
			.antMatchers("/editForum/*").authenticated()
			.antMatchers("/profil").authenticated()
			.antMatchers("/deleteMessage/*").authenticated()
			.anyRequest().permitAll()// Allow other URLs without authentication
			.and()
			.formLogin()
			.loginPage("/login")// Specify your custom login page URL if you have one
				.usernameParameter("email")
				.defaultSuccessUrl("/dashboard",true)// Redirect to /dashboard after successful login
				.permitAll()
			.and()
			.logout()
				.logoutSuccessUrl("/")
			     .invalidateHttpSession(true) // Invalidate session
	             .deleteCookies("JSESSIONID") // Delete session cookie
				.permitAll();
	}
	
	
}
