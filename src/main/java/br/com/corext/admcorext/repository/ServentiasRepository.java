package br.com.corext.admcorext.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.corext.admcorext.model.Serventias;

public interface ServentiasRepository extends JpaRepository<Serventias, Long> {

    List<Serventias> findByResponsavelIsNotNull();
 
}