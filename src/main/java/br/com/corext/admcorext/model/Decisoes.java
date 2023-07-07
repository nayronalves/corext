package br.com.corext.admcorext.model;

import jakarta.persistence.*;

@Entity
public class Decisoes {
    
    @Id
    private Long Id;

    @Column
    private String decisao;

    @Column
    private String numero;

    @Column
    private String ano;

    public Decisoes(){
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getDecisao() {
        return decisao;
    }

    public void setDecisao(String decisao) {
        this.decisao = decisao;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public Decisoes(Long id, String decisao, String numero, String ano) {
        Id = id;
        this.decisao = decisao;
        this.numero = numero;
        this.ano = ano;
    }

    @Override
    public String toString() {
        return "Decisoes [Id=" + Id + ", decisao=" + decisao + ", numero=" + numero + ", ano=" + ano + "]";
    }

}
