package br.com.encurtandocaminhos.api.controller;

import br.com.encurtandocaminhos.api.model.Usuario;
import br.com.encurtandocaminhos.api.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    //ENDPOINT PARA BUSCAR UM USUÁRIO PELO ID
    @GetMapping("{id}")
    public Usuario getUsuarioById(@PathVariable Long id){
        return usuarioService.buscarUsuarioPorId(id);
    }

    @GetMapping
    public List<Usuario> getUsuarios(){
        return usuarioService.getAllUsuarios();
    }

    @DeleteMapping("{id}")
    public void deleteUsuario(@PathVariable Long id){
        usuarioService.deleteUsuario(id);
    }

    @PostMapping
    public ResponseEntity<Usuario> adicionarUsuario(@RequestBody Usuario usuario){
        Usuario usuarioSalvo = usuarioService.salvarUsuario(usuario);
        return new ResponseEntity<>(usuarioSalvo, HttpStatus.CREATED); //RETORNARÁ 201 COM O USUÁRIO SALVO
    }

}
