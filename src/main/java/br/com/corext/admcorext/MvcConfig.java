package br.com.corext.admcorext;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    public void addViewController(ViewControllerRegistry registry) {
        // registry.addViewController("/").setViewName("home");
        registry.addViewController("/").setViewName("index.html");
        registry.addViewController("/login").setViewName("login.html");
        // registry.addViewController("/sgext/faqform").setViewName("faqform.html");
        // registry.addViewController("/searchDec").setViewName("pages/search/searchDec.html");
    }

}
