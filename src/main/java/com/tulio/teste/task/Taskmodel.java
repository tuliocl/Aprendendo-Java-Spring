package com.tulio.teste.task;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;

@Entity(name = "tb_Task")
public class Taskmodel {
    
    @jakarta.persistence.Id
    @GeneratedValue(generator = "UUID")
    UUID id;
    UUID cadastradoPor;

    String Status;
    
    String descricao;
    String titulo;
   
    public String getStatus() {
        return this.Status;
    }
    public void setStatus(String status) {
        this.Status = status;
    }
    public UUID getCadastradoPor() {
        return this.cadastradoPor;
    }
    public void setCadastradoPor(UUID cadastradoPor) {
        this.cadastradoPor = cadastradoPor;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public UUID getId() {
        return id;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public String getDescricao() {
        return descricao;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getTitulo() {
        return titulo;
    }

}
