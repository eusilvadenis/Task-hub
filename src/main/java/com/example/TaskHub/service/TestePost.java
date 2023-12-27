package com.example.TaskHub.service;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class TestePost {
    @JsonProperty("title")
    String title;


    @JsonProperty("body")
    String body;

    @JsonProperty("userId")
    long userId;

    public TestePost(String title, String body, long userId) {
        this.title = title;
        this.body = body;
        this.userId = userId;
    }

    public TestePost() {
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public long getUserId() {
        return userId;
    }
}
