package net.skhu.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true, securedEnabled=true, jsr250Enabled=true)
public class SecurityConfig {



	@Autowired
    UserDetailsService userDetailsService;
	
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
    	  http.authorizeRequests()
          .antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
          .antMatchers("/professor/**").access("hasRole('ROLE_PROFESSOR')")
          .antMatchers("/user/**").authenticated();

      http.formLogin()
          .loginPage("/login")
          .loginProcessingUrl("/login_processing")
          .failureUrl("/login?error")
          .defaultSuccessUrl("/user/redirect", true)	
          .usernameParameter("userid")
          .passwordParameter("passwd");

      http.logout()
          .logoutRequestMatcher(new AntPathRequestMatcher("/logout_processing"))
          .logoutSuccessUrl("/login")
          .invalidateHttpSession(true);
      
      
      
      return http.build();
    }

  

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    AuthenticationManager authenticationManager(
    		AuthenticationConfiguration authenticationConfigration) throws Exception{
    	return authenticationConfigration.getAuthenticationManager();
    }
    

    @Bean 
    public WebSecurityCustomizer webSecurityCustomizer() {
    	return (web)-> web.ignoring().antMatchers("/res/**");
    }
  



}
