package br.com.encurtandocaminhos.api.services;

import br.com.encurtandocaminhos.api.model.Servico;
import br.com.encurtandocaminhos.api.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicoService {
    @Autowired
    private ServicoRepository servicoRepository;

    public List<Servico> listarServicos(){
        return servicoRepository.findAll();
    }

    public Optional<Servico> buscarPorId(Long id){
        return servicoRepository.findById(id);
    }

    public Servico salvarServico(Servico servico){
        return servicoRepository.save(servico);
    }

    public void deletarServico(Long id){
        servicoRepository.deleteById(id);
    }

}
