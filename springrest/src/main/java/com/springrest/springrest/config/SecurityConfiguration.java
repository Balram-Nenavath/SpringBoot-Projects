package com.springrest.springrest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/**");
    }

    
    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
    return super.authenticationManagerBean();
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
//    	http.authorizeRequests().antMatchers("/oauth/**","/oauth/authorize/**","/login","/token").permitAll().antMatchers("/getEmployeesList").hasAnyRole("ADMIN")
//    	.anyRequest().authenticated().and().logout().permitAll();
//	
		 http.authorizeRequests().antMatchers("/").permitAll().antMatchers(
		 "/getEmployeesList")
		  .hasAnyRole("ADMIN").anyRequest().authenticated().and().formLogin()
		  .permitAll().and().logout().permitAll();
		 
        http.csrf().disable();
    }

    @Override
    public void configure(AuthenticationManagerBuilder authenticationMgr) throws Exception {
    	authenticationMgr.inMemoryAuthentication().withUser("balram").password("{noop}balram@1998").authorities("ROLE_ADMIN");
    }
}
