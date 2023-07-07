package br.com.corext.admcorext.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.corext.admcorext.model.Decisoes;

public interface DecisoesRepository extends JpaRepository<Decisoes, Long> {

    @Query("SELECT d FROM Decisoes d WHERE d.decisao ilike %?1%")
    List<Decisoes> findDecisaoByDescricao(String decisao);
    
}
