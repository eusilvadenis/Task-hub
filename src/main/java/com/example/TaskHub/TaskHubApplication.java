package com.example.TaskHub;



import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.TaskHub.service.CadastroUsuario;
import com.example.TaskHub.service.ConsumoApi;
import com.example.TaskHub.service.ConverteDados;
import com.example.TaskHub.service.EfetuarLogin;
import com.example.TaskHub.service.TestePost;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class TaskHubApplication implements CommandLineRunner {

	private ConverteDados conversor = new ConverteDados();
	private ConsumoApi consumo = new ConsumoApi();


	public static void main(String[] args) {
		SpringApplication.run(TaskHubApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var endereco = "https://taskhubapi-production.up.railway.app/usuarios";
		//var cadastro = new CadastroUsuario("John",  "johnpalmeiras", "john.andres@gmail.com", "palmeiras123");
		var login = new EfetuarLogin( "johnpalmeiras","palmeiras123");
		//var teste = new TestePost("foo", "bar", 1);
		ObjectMapper objectMapper = new ObjectMapper();
        String dadosJson = objectMapper.writeValueAsString(login);	
		System.out.println(dadosJson);	
		consumo.enviarDadosPost(endereco, dadosJson);
		
	}
	
	

}
