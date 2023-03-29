package net.skhu.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled=true, securedEnabled=true, jsr250Enabled=true)
//3.0 이상 버전은 EnableMethodSecurity 권장
public class SecurityConfig {

	//websecurityconfigureradapter가 Deprecated되었음
	
	//https://www.javaguides.net/2022/08/spring-security-without-webSecurityconfigureradapter.html
    @Autowired UserDetailsService userDetailsService;


    

 

    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
            .passwordEncoder(passwordEncoder());
       
    }
    
    

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() throws Exception {
        return (web)-> web.ignoring().requestMatchers("/res/**");
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    	http.csrf().disable()
        .authorizeHttpRequests()
       
        .requestMatchers("/admin/**").hasRole("ROLE_ADMIN")
        .requestMatchers("/professor/**").hasRole("ROLE_PROFESSOR")
        .requestMatchers("/user/**").authenticated();

    	//antMatchers가 requestMatcher로 대체됨

        http.formLogin(
        	
        	form->form
        	.loginPage("/login")
            .loginProcessingUrl("/login_processing")
            .failureUrl("/login?error")
            .defaultSuccessUrl("/", true)
            .usernameParameter("userid")
            .passwordParameter("passwd")
        		).logout(
        	logout->logout
            .logoutRequestMatcher(new AntPathRequestMatcher("/logout_processing"))
            .logoutSuccessUrl("/login")
            .invalidateHttpSession(true)
            );
        return http.build();
    }

}
