package br.com.corext.admcorext;

// import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
// import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
// import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
// import org.springframework.security.core.userdetails.User;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
// import org.springframework.security.provisioning.JdbcUserDetailsManager;
// import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/login", "/dist/**", "/plugins/**", "/searchDec", "/searchDecResults/**").permitAll().anyRequest().authenticated())
                .formLogin((form) -> form
                        .loginPage("/login")
                        .defaultSuccessUrl("/")
                        .permitAll())
                .logout((logout) -> logout.permitAll());


        // httpSecurity.csrf().disable()
        //         .cors()
        //         .and().authorizeHttpRequests().requestMatchers("xyz").permitAll()
        //         .requestMatchers("abc")
        //         .authenticated()
        //         .and()
        //         .sessionManagement()
        //         .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED);

        return httpSecurity.build();
    }

    @Bean
    public UserDetailsService users() {
        UserDetails user = User.builder()
                .username("user")
                .password("{noop}123")
                .roles("USER")
                .build();
        UserDetails admin = User.builder()
                .username("admin")
                .password("{noop}12345")
                .roles("USER", "ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user, admin);
    }

    // @Bean
    // DataSource dataSource() {
    // return new EmbeddedDatabaseBuilder()
    // .setType(EmbeddedDatabaseType.H2)
    // .addScript(JdbcDaoImpl.DEFAULT_USER_SCHEMA_DDL_LOCATION)
    // .build();
    // }

    // @Bean
    // UserDetailsManager users(DataSource dataSource) {
    // UserDetails user = User.builder()
    // .username("user")
    // .password("12345")
    // .roles("USER")
    // .build();
    // UserDetails admin = User.builder()
    // .username("admin")
    // .password("12345")
    // .roles("USER", "ADMIN")
    // .build();
    // JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);
    // users.createUser(user);
    // users.createUser(admin);
    // return users;
    // }

}
