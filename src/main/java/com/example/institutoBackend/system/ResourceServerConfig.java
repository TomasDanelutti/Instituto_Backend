package com.example.institutoBackend.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;

@Configuration
@EnableResourceServer
@EnableGlobalMethodSecurity(securedEnabled = true, proxyTargetClass = true, prePostEnabled = true)
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Autowired
    private DefaultTokenServices defaultTokenServices;

    @Override
    public void configure(ResourceServerSecurityConfigurer config) throws Exception {
        config.tokenServices(defaultTokenServices);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers( "oauth/token").permitAll()
                .antMatchers( "curso/**").permitAll()
                .anyRequest().authenticated()
                .and().csrf().disable().cors();
    }

}
