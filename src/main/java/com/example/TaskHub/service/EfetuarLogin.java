package com.example.TaskHub.service;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class EfetuarLogin {
    
    @JsonProperty("login")
    private String login;

    @JsonProperty("senha")
    private String senha;

    public EfetuarLogin() {
    }

    public EfetuarLogin(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

}
