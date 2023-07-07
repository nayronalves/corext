package br.com.corext.admcorext.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.corext.admcorext.model.Faq;

public interface FaqRepository extends JpaRepository<Faq, Long>{
    
}
