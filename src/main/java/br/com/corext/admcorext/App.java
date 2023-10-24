package br.com.corext.admcorext;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import br.com.corext.admcorext.controller.StorageProperties;
import br.com.corext.admcorext.controller.StorageService;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class App {
    public static void main(String[] args) {
        // final Logger LOG = LoggerFactory.getLogger(App.class);

        SpringApplication.run(App.class, args);
        // LOG.info("APLICACAO INICIADA COM SUCESSO!");
        System.out.println("##########   APLICACAO INICIADA COM SUCESSO!   ##########");
    }

    @Bean
    CommandLineRunner init(StorageService storageService) {
        return (args) -> {
            storageService.deleteAll();
            storageService.init();
        };
    }

    // @Bean
    // public BCryptPasswordEncoder bCryptPasswordEncoder(){
    // return new BCryptPasswordEncoder();
    // }
}
