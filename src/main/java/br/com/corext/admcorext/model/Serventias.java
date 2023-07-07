package br.com.corext.admcorext.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;

@Entity
public class Serventias {

    public interface Serventia {};
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    
    @Column
    private String nome;
    
    @Column
    private String logradouro;
    
    @Column
    private String email;

    @Column
    private String telefone;
    
    @Column
    private String cnpj;
    
    @Column 
    private String cns;
    
    @Column 
    private String municipio;
    
    @Column 
    private String bairro;

    @Column 
    private String cod_sei;

    @Column 
    private String instalacao;
    
    @Column 
    private String situacao;
    
    @Column 
    private String num_oficio;
    
    @Column 
    private String proc_sei;

    @Column
    private String responsavel;

    @Column
    private String data_ingresso;

    @Column
    private String portaria;

    public Serventias(){
    }

    @JsonCreator
    public Serventias(
        @JsonProperty("nome") String nome,
        @JsonProperty("logradouro") String logradouro,
        @JsonProperty("email") String email,
        @JsonProperty("telefone") String telefone,
        @JsonProperty("cnpj") String cnpj,
        @JsonProperty("cns") String cns,
        @JsonProperty("municipio") String municipio,
        @JsonProperty("bairro") String bairro,
        @JsonProperty("cod_sei") String cod_sei,
        @JsonProperty("instalacao") String instalacao,
        @JsonProperty("situacao") String situacao,
        @JsonProperty("num_oficio") String num_oficio,
        @JsonProperty("proc_sei") String proc_sei,
        @JsonProperty("responsavel") String responsavel,
        @JsonProperty("data_ingresso") String data_ingresso,
        @JsonProperty("portaria") String portaria
        ){
            this.nome = nome;
            this.logradouro = logradouro;
            this.email = email;
            this.telefone = telefone;
            this.cnpj = cnpj;
            this.cns = cns;
            this.municipio = municipio;
            this.bairro = bairro;
            this.cod_sei = cod_sei;
            this.instalacao = instalacao;
            this.situacao = situacao;
            this.num_oficio = num_oficio;
            this.proc_sei = proc_sei;
            this.responsavel = responsavel;
            this.data_ingresso = data_ingresso;
            this.portaria = portaria;
    }

    public Serventias(Long id, String nome, String logradouro, String email, String telefone, String cnpj, String cns,
            String municipio, String bairro, String cod_sei, String instalacao, String situacao, String num_oficio,
            String proc_sei, String responsavel, String data_ingresso, String portaria) {
        Id = id;
        this.nome = nome;
        this.logradouro = logradouro;
        this.email = email;
        this.telefone = telefone;
        this.cnpj = cnpj;
        this.cns = cns;
        this.municipio = municipio;
        this.bairro = bairro;
        this.cod_sei = cod_sei;
        this.instalacao = instalacao;
        this.situacao = situacao;
        this.num_oficio = num_oficio;
        this.proc_sei = proc_sei;
        this.responsavel = responsavel;
        this.data_ingresso = data_ingresso;
        this.portaria = portaria;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getCns() {
        return cns;
    }

    public void setCns(String cns) {
        this.cns = cns;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCod_sei() {
        return cod_sei;
    }

    public void setCod_sei(String cod_sei) {
        this.cod_sei = cod_sei;
    }

    public String getInstalacao() {
        return instalacao;
    }

    public void setInstalacao(String instalacao) {
        this.instalacao = instalacao;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getNum_oficio() {
        return num_oficio;
    }

    public void setNum_oficio(String num_oficio) {
        this.num_oficio = num_oficio;
    }

    public String getProc_sei() {
        return proc_sei;
    }

    public void setProc_sei(String proc_sei) {
        this.proc_sei = proc_sei;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public String getData_ingresso() {
        return data_ingresso;
    }

    public void setData_ingresso(String data_ingresso) {
        this.data_ingresso = data_ingresso;
    }

    public String getPortaria() {
        return portaria;
    }

    public void setPortaria(String portaria) {
        this.portaria = portaria;
    }

    @Override
    public String toString() {
        return "Serventias [Id=" + Id + ", nome=" + nome + ", logradouro=" + logradouro + ", email=" + email
                + ", telefone=" + telefone + ", cnpj=" + cnpj + ", cns=" + cns + ", municipio=" + municipio
                + ", bairro=" + bairro + ", cod_sei=" + cod_sei + ", instalacao=" + instalacao + ", situacao="
                + situacao + ", num_oficio=" + num_oficio + ", proc_sei=" + proc_sei + ", responsavel=" + responsavel
                + ", data_ingresso=" + data_ingresso + ", portaria=" + portaria + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((Id == null) ? 0 : Id.hashCode());
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + ((logradouro == null) ? 0 : logradouro.hashCode());
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((telefone == null) ? 0 : telefone.hashCode());
        result = prime * result + ((cnpj == null) ? 0 : cnpj.hashCode());
        result = prime * result + ((cns == null) ? 0 : cns.hashCode());
        result = prime * result + ((municipio == null) ? 0 : municipio.hashCode());
        result = prime * result + ((bairro == null) ? 0 : bairro.hashCode());
        result = prime * result + ((cod_sei == null) ? 0 : cod_sei.hashCode());
        result = prime * result + ((instalacao == null) ? 0 : instalacao.hashCode());
        result = prime * result + ((situacao == null) ? 0 : situacao.hashCode());
        result = prime * result + ((num_oficio == null) ? 0 : num_oficio.hashCode());
        result = prime * result + ((proc_sei == null) ? 0 : proc_sei.hashCode());
        result = prime * result + ((responsavel == null) ? 0 : responsavel.hashCode());
        result = prime * result + ((data_ingresso == null) ? 0 : data_ingresso.hashCode());
        result = prime * result + ((portaria == null) ? 0 : portaria.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Serventias other = (Serventias) obj;
        if (Id == null) {
            if (other.Id != null)
                return false;
        } else if (!Id.equals(other.Id))
            return false;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (logradouro == null) {
            if (other.logradouro != null)
                return false;
        } else if (!logradouro.equals(other.logradouro))
            return false;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        if (telefone == null) {
            if (other.telefone != null)
                return false;
        } else if (!telefone.equals(other.telefone))
            return false;
        if (cnpj == null) {
            if (other.cnpj != null)
                return false;
        } else if (!cnpj.equals(other.cnpj))
            return false;
        if (cns == null) {
            if (other.cns != null)
                return false;
        } else if (!cns.equals(other.cns))
            return false;
        if (municipio == null) {
            if (other.municipio != null)
                return false;
        } else if (!municipio.equals(other.municipio))
            return false;
        if (bairro == null) {
            if (other.bairro != null)
                return false;
        } else if (!bairro.equals(other.bairro))
            return false;
        if (cod_sei == null) {
            if (other.cod_sei != null)
                return false;
        } else if (!cod_sei.equals(other.cod_sei))
            return false;
        if (instalacao == null) {
            if (other.instalacao != null)
                return false;
        } else if (!instalacao.equals(other.instalacao))
            return false;
        if (situacao == null) {
            if (other.situacao != null)
                return false;
        } else if (!situacao.equals(other.situacao))
            return false;
        if (num_oficio == null) {
            if (other.num_oficio != null)
                return false;
        } else if (!num_oficio.equals(other.num_oficio))
            return false;
        if (proc_sei == null) {
            if (other.proc_sei != null)
                return false;
        } else if (!proc_sei.equals(other.proc_sei))
            return false;
        if (responsavel == null) {
            if (other.responsavel != null)
                return false;
        } else if (!responsavel.equals(other.responsavel))
            return false;
        if (data_ingresso == null) {
            if (other.data_ingresso != null)
                return false;
        } else if (!data_ingresso.equals(other.data_ingresso))
            return false;
        if (portaria == null) {
            if (other.portaria != null)
                return false;
        } else if (!portaria.equals(other.portaria))
            return false;
        return true;
    }
  
}
