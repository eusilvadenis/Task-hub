package com.example.TaskHub.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsumoApi {

    public String obterDados(String endereco) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();
        HttpResponse<String> response = null;
        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        String json = response.body();
        return json;
    }
    public void enviarDadosPost(String endereco, String json){
         try {
            // URL da API
            URL url = new URL(endereco);

            // Abrindo a conexão
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Configurando a conexão para enviar dados e receber resposta
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("User-Agent", "PostmanRuntime/7.36.0");

            // Dados que você deseja enviar para a API (no formato de query string ou JSON, dependendo da API)
            String dadosParaAPI = json;
            System.out.println(dadosParaAPI);

            // Escrevendo os dados na requisição
            try (OutputStream os = connection.getOutputStream();
                 OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8")) {
                osw.write(dadosParaAPI);
                osw.flush();
            }

            // Obtendo a resposta da API
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Lendo a resposta
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                    String linha;
                    StringBuilder resposta = new StringBuilder();
                    while ((linha = reader.readLine()) != null) {
                        resposta.append(linha);
                    }
                    System.out.println("Resposta da API: " + resposta.toString());
                }
            } else {
                System.out.println("Falha na requisição. Código de resposta: " + responseCode);
            }

            // Fechando a conexão
            connection.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    }

 
    

