package br.com.indtexbr.sigo.consultoriaseassessorias;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@SpringBootApplication
@EnableResourceServer
public class ConsultoriasEAssessoriasApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsultoriasEAssessoriasApplication.class, args);
	}

}
