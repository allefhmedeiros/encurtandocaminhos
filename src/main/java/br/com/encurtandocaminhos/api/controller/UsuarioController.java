package br.com.encurtandocaminhos.api.controller;

import br.com.encurtandocaminhos.api.model.Usuario;
import br.com.encurtandocaminhos.api.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    //ENDPOINT PARA BUSCAR UM USUÁRIO PELO ID
    @GetMapping("/usuarios/{id}")
    public Usuario getUsuarioById(@PathVariable Long id){
        return usuarioService.buscarUsuarioPorId(id);
    }

    @GetMapping("/usuarios")
    public List<Usuario> getUsuarios(){
        return usuarioService.getAllUsuarios();
    }

    @DeleteMapping("/usuarios/{id}")
    public void deleteUsuario(@PathVariable Long id){
        usuarioService.deleteUsuario(id);
    }

}
