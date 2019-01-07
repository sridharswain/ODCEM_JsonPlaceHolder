package com.odcem.jsonplaceholderwithjwt;

import com.odcem.jsonplaceholderwithjwt.security.JwtSecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.web.servlet.FilterRegistrationBean;

/**
 * Hello world!
 *
 */

@SpringBootApplication
public class App 
{
    public static void main( String[] args )
    {
        //SSL Confriguration
        System.setProperty("https.protocols", "TLSv1.2,TLSv1.1,TLSv1");

        SpringApplication.run(App.class, args);
    }

    @Bean
    public FilterRegistrationBean<JwtSecurity> jwtFilter(){
        final FilterRegistrationBean<JwtSecurity> registrationBean = new FilterRegistrationBean<>();
		registrationBean.setFilter(new JwtSecurity());
		registrationBean.addUrlPatterns("/secure/*");

		return registrationBean;
    }
}
