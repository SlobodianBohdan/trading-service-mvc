package com.trading.tradingservice.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    //@Value("${app.adminPanelUrl}")
    private String adminPanelUrl = "admin";

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf()
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/")
                .and()
                .authorizeRequests()
                .antMatchers("/trade/" + adminPanelUrl + "/**")
                .authenticated()
                .and()
                .authorizeRequests()
                .antMatchers("/**")
                .permitAll();
    }
}
