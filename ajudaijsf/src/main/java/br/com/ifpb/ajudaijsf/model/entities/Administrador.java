package br.com.ifpb.ajudaijsf.model.entities;

import java.time.LocalDate;

public class Administrador {
    private String nomeCompleto;
    private String email;
    private String senha;
    private LocalDate dataInicio;

    public Administrador() {
    }

    public Administrador(String nomeCompleto, String email, String senha, LocalDate dataInicio) {
        this.nomeCompleto = nomeCompleto;
        this.email = email;
        this.senha = senha;
        this.dataInicio = dataInicio;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }
}
