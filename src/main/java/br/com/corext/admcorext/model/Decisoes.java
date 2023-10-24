package br.com.corext.admcorext.model;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
public class Decisoes {
    
    @Id
    private Long Id;

    @Column(columnDefinition="text")
    private String decisao;

    @Column
    private String num_documento;

    @Column
    private int id_protocolo_1;

    @Column
    private int id_protocolo_2;

    @Column
    private LocalDateTime data_assinatura;
    
    @Column
    private String num_processo;
    
    @Column
    private String assinante;

    @Column
    private String protocolo;

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

    public String getNum_documento() {
        return num_documento;
    }

    public void setNum_documento(String num_documento) {
        this.num_documento = num_documento;
    }

    public int getId_protocolo_1() {
        return id_protocolo_1;
    }

    public void setId_protocolo_1(int id_protocolo_1) {
        this.id_protocolo_1 = id_protocolo_1;
    }

    public int getId_protocolo_2() {
        return id_protocolo_2;
    }

    public void setId_protocolo_2(int id_protocolo_2) {
        this.id_protocolo_2 = id_protocolo_2;
    }

    public LocalDateTime getData_assinatura() {
        return data_assinatura;
    }

    public void setData_assinatura(LocalDateTime data_assinatura) {
        this.data_assinatura = data_assinatura;
    }

    public String getNum_processo() {
        return num_processo;
    }

    public void setNum_processo(String num_processo) {
        this.num_processo = num_processo;
    }

    public String getAssinante() {
        return assinante;
    }

    public void setAssinante(String assinante) {
        this.assinante = assinante;
    }

    public String getProtocolo() {
        return protocolo;
    }

    public void setProtocolo(String protocolo) {
        this.protocolo = protocolo;
    }

    @Override
    public String toString() {
        return "Decisoes [Id=" + Id + ", decisao=" + decisao + ", num_documento=" + num_documento + ", id_protocolo_1="
                + id_protocolo_1 + ", id_protocolo_2=" + id_protocolo_2 + ", data_assinatura=" + data_assinatura
                + ", num_processo=" + num_processo + ", assinante=" + assinante + ", protocolo=" + protocolo + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((Id == null) ? 0 : Id.hashCode());
        result = prime * result + ((decisao == null) ? 0 : decisao.hashCode());
        result = prime * result + ((num_documento == null) ? 0 : num_documento.hashCode());
        result = prime * result + id_protocolo_1;
        result = prime * result + id_protocolo_2;
        result = prime * result + ((data_assinatura == null) ? 0 : data_assinatura.hashCode());
        result = prime * result + ((num_processo == null) ? 0 : num_processo.hashCode());
        result = prime * result + ((assinante == null) ? 0 : assinante.hashCode());
        result = prime * result + ((protocolo == null) ? 0 : protocolo.hashCode());
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
        Decisoes other = (Decisoes) obj;
        if (Id == null) {
            if (other.Id != null)
                return false;
        } else if (!Id.equals(other.Id))
            return false;
        if (decisao == null) {
            if (other.decisao != null)
                return false;
        } else if (!decisao.equals(other.decisao))
            return false;
        if (num_documento == null) {
            if (other.num_documento != null)
                return false;
        } else if (!num_documento.equals(other.num_documento))
            return false;
        if (id_protocolo_1 != other.id_protocolo_1)
            return false;
        if (id_protocolo_2 != other.id_protocolo_2)
            return false;
        if (data_assinatura == null) {
            if (other.data_assinatura != null)
                return false;
        } else if (!data_assinatura.equals(other.data_assinatura))
            return false;
        if (num_processo == null) {
            if (other.num_processo != null)
                return false;
        } else if (!num_processo.equals(other.num_processo))
            return false;
        if (assinante == null) {
            if (other.assinante != null)
                return false;
        } else if (!assinante.equals(other.assinante))
            return false;
        if (protocolo == null) {
            if (other.protocolo != null)
                return false;
        } else if (!protocolo.equals(other.protocolo))
            return false;
        return true;
    }
    
    

}
