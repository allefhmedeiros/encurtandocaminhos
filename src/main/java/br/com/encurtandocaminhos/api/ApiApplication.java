package br.com.encurtandocaminhos.api;

import br.com.encurtandocaminhos.api.model.Usuario;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class ApiApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("\n*** TESTE DE IMPLEMENTAÇÃO DA CAMADA DE MODELO DE NEGÓCIO ***\n");
		Usuario novoUsuario = new Usuario("JESSUS ALLEFH DE MEDEIROS SILVA", "JESSUS SILVA", LocalDate.parse("1993-10-28"), "10326172416", "ENGENHEIRO DE SOFTWARE", "ALLEFHMEDEIROS@GMAIL.COM", "TESTE123");
		System.out.println(novoUsuario.toString());
		//Scanner leituraTeclado = new Scanner(System.in);
		//var teste = leituraTeclado.nextLine();

	}
}
