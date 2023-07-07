package br.com.corext.admcorext.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.corext.admcorext.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

    User findByUsername(String username);
    
}
