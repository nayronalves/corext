package br.com.corext.admcorext.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.corext.admcorext.model.Decisoes;

public interface DecisoesRepository extends JpaRepository<Decisoes, Long> {

    @Query("select d from Decisoes d where d.decisao ilike %?1%")
    List<Decisoes> findDecisaoByDescricao(String decisao);
    
}
