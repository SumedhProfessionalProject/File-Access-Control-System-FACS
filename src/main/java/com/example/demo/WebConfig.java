package com.example.demo;


import java.io.IOException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.example.demo.Config.CustomUserDetails;
import com.example.demo.SERVICE.UserPOJOService;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



@ComponentScan("com.example.demo")
@Configuration
@EnableWebSecurity
public class WebConfig {



    @Bean
    UserDetailsService userDetailsService() {
        return new UserPOJOService();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
         
        return authProvider;
    }


    @Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
        http.authenticationProvider(authenticationProvider());

        http
			.authorizeHttpRequests((requests) -> requests
				.requestMatchers("/register","/registerhtml").permitAll()
				.anyRequest().authenticated()
			)
			.formLogin((form) -> form
				.loginPage("/login")
                .successHandler(new CustomAuthenticationSuccessHandler())
				.permitAll()
			)
			.logout((logout) -> logout.logoutSuccessUrl("/login")
                                .invalidateHttpSession(true)  // Invalidate the session
                                .deleteCookies("JSESSIONID")        
                                .permitAll()            
            );

		return http.
                build();
	}

    

}

class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws IOException, ServletException {
                
                CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
                request.getSession().setAttribute("user", authentication.getName());
                request.getSession().setAttribute("fullname", userDetails.getName());
                // Redirect to default URL or any other logic
                response.sendRedirect("/");
    }
    
}
