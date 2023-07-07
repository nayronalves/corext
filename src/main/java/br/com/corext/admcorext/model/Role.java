package br.com.corext.admcorext.model;

import jakarta.persistence.Column;
import jakarta.persistence.Table;

@Table(name = "Role")
public class Role {
    
    @Column
    private Integer id;

    @Column
    private String name;

    public Role(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Role(Integer id, String name) {
        this.id = id;
        this.name = name;
    }    

}
