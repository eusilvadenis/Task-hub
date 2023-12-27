package com.example.TaskHub.service;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize

public class CadastroUsuario {
    
    @JsonProperty("nome")
    private String nome;
    
    @JsonProperty("login")
    private String login;

    @JsonProperty("email")
    private String email;

    @JsonProperty("senha")
    private String senha;

    public CadastroUsuario(){

    }
    
    public CadastroUsuario(String nome, String login, String email, String senha) {
        this.nome = nome;
        this.login = login;
        this.email = email;
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "CadastroUsuario [nome=" + nome + ", login=" + login + ", email=" + email + ", senha=" + senha + "]";
    }

    public String getNome() {
        return nome;
    }

    public String getLogin() {
        return login;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }
}
