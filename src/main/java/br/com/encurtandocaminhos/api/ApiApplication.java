package br.com.encurtandocaminhos.api;

import br.com.encurtandocaminhos.api.model.*;
import br.com.encurtandocaminhos.api.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileOutputStream;
import java.time.LocalDate;

@SpringBootApplication
public class ApiApplication implements CommandLineRunner {

	@Autowired
	private UsuarioService usuarioService; //INJEÇÃO DE SERVIÇO --> REPOSITÓRIO --> MODELO

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("\n*** TESTE DE IMPLEMENTAÇÃO DA CAMADA DE MODELO DE NEGÓCIO ***\n");


		Usuario novoUsuario = new Usuario("ALEX GOMES DA SILVA", "ALEX GOMES", LocalDate.parse("2000-12-29"), "10326172416", "ANALISTA DE DADOS", "ALEXGOMES@GMAIL.COM", "TESTE123");
		System.out.println("OBJETO INSTANCIADO: USUÁRIO\n");
		System.out.println(novoUsuario.toString());

		Usuario usuarioSalvo = usuarioService.salvarUsuario(novoUsuario);
		System.out.println("\nUSUÁRIO SALVO NO BANCO DE DADOS.\n");

		// RECUPERANDO O USUÁRIO DO BANCO DE DADOS
		Usuario usuarioRecuperado = usuarioService.buscarUsuarioPorId(usuarioSalvo.getId());
		if (usuarioRecuperado != null) {
			System.out.println("USUÁRIO RECUPERADO DO BANCO DE DADOS:\n");
			System.out.println(usuarioRecuperado.toString());
		} else {
			System.out.println("USUÁRIO NÃO ENCONTRADO.");
		}
		System.out.println(novoUsuario.toString());

//		Servico divulgarServico = new Servico("Presto serviço de programação","Engenheiro de software", 8000.0,"11933251636", "ALLEFHMEDEIROS@GMAIL.COM", novoUsuario);
//		System.out.println("OBJETO INSTANCIADO: SERVIÇO\n");
//		System.out.println(divulgarServico.toString());
//
//		Evento promoverEvento = new Evento("Meu primeiro evento!", LocalDate.parse("2025-01-02"), LocalDate.parse("2025-01-20"), "Será um encontro incrível", 150.00, novoUsuario);
//		System.out.println("OBJETO INSTANCIADO: EVENTO\n");
//		System.out.println(promoverEvento.toString());
//
//		Recurso recursoPublicacao = new Recurso("www.google.com.br");
//		Publicacao novaPublicacao = new Publicacao(novoUsuario, "Minha primeira publicação!",recursoPublicacao);
//		System.out.println("OBJETO INSTANCIADO: PUBLICAÇÃO\n");
//		System.out.println(novaPublicacao.toString());
//
//		Curtida novaReacao = new Curtida(novoUsuario, novaPublicacao);
//		System.out.println("OBJETO INSTANCIADO: REAÇÃO INICIAL\n");
//		System.out.println(novaReacao.toString());
//		novaReacao.alternarCurtida();
//		System.out.println("OBJETO INSTANCIADO: REAÇÃO NOVA\n");
//		System.out.println(novaReacao.toString());
//		novaReacao.alternarCurtida();
//		System.out.println("OBJETO INSTANCIADO: REAÇÃO NOVA\n");
//		System.out.println(novaReacao.toString());
//
//		System.out.println("OBJETO INSTANCIADO: COMENTÁRIO\n");
//		Comentario novoComentario = new Comentario("Esse é meu novo comentário!", novaPublicacao, novoUsuario);
//		System.out.println(novoComentario.toString());

	}
}
