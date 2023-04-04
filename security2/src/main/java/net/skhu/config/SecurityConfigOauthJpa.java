package net.skhu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import net.skhu.service.CustomOAuth2UserService;
import net.skhu.entity.Role;

@Configuration
@EnableWebSecurity
public class SecurityConfigOauthJpa { //WebSecurityConfigurerAdapter was deprecated
 
    private final CustomOAuth2UserService customOAuth2UserService;
 
    public SecurityConfigOauthJpa(CustomOAuth2UserService customOAuth2UserService) {
        this.customOAuth2UserService = customOAuth2UserService;
    }
 
    @Bean
    public BCryptPasswordEncoder encoder2() {
        return new BCryptPasswordEncoder();
    }
 
    @Bean
    public SecurityFilterChain filterChain2(HttpSecurity http) throws Exception {
        http
        .csrf().disable().headers().frameOptions().disable() // 2.
        .and()
        .authorizeRequests() // 3.
        .antMatchers("/", "/view/**", "/css/**", "/images/**", "/js/**", "/h2-console/**", "/profile").permitAll().antMatchers("/api/v1/**").hasRole(Role.USER.name()) // 4.
        .anyRequest().authenticated() // 5.
        .and()
        .logout()
        .logoutSuccessUrl("/login") // 6.
        .and()
        .oauth2Login() // 7.
        .userInfoEndpoint() // 8.
        .userService(customOAuth2UserService);
        return http.build();
    }
}
 
