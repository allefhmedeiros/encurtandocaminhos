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

    public List<Servico> listarServicos() {
        return servicoRepository.findAll();
    }

    public Optional<Servico> buscarPorId(Long id) {
        return servicoRepository.findById(id);
    }

    public Servico salvarServico(Servico servico) {
        return servicoRepository.save(servico);
    }

    public boolean deletarServico(Long id) {
        servicoRepository.deleteById(id);
        return false;
    }

    // Implementação do método para atualizar serviço
    public Servico atualizarServico(Long id, Servico servicoAtualizado) {
        Optional<Servico> servicoExistente = servicoRepository.findById(id);

        if (servicoExistente.isPresent()) {
            Servico servico = servicoExistente.get();

            // Atualizando os campos do serviço existente com os dados do serviço atualizado
            servico.setTitulo(servicoAtualizado.getTitulo());
            servico.setResumo(servicoAtualizado.getResumo());
            servico.setValor(servicoAtualizado.getValor());
            servico.setContato(servicoAtualizado.getContato());
            servico.setEmail(servicoAtualizado.getEmail());
            servico.setPrestador(servicoAtualizado.getPrestador());

            return servicoRepository.save(servico); // Salva o serviço atualizado
        } else {
            return null; // Retorna null caso o serviço não seja encontrado
        }
    }

    public List<Servico> buscarPorFornecedor(Long prestadorId) {
        return servicoRepository.findByPrestadorId(prestadorId);
    }
}
