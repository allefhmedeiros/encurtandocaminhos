package br.com.encurtandocaminhos.api.services;

import br.com.encurtandocaminhos.api.model.Evento;
import br.com.encurtandocaminhos.api.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventoService {
    @Autowired
    private EventoRepository eventoRepository;

    //MÉTODO RESPONSÁVEL POR SALVAR NOVO EVENTO
    public Evento salvarEvento(Evento evento){
        return eventoRepository.save(evento);
    }

    //MÉTODO RESPONSÁVEL POR BUSCAR DETERMINADO EVENTO UTILIZANDO O ID COMO PARAMETRO.
    public Optional<Evento> buscarPorId(Long id){
        return eventoRepository.findById(id);
    }

    //MÉTODO RESPONSÁVEL POR BUSCAR TODOS OS EVENTOS CADASTRADOS.
    public List<Evento> listarEventos(){
        return eventoRepository.findAll();
    }

    //MÉTODO RESPONSÁVEL POR ATUALIZAR EVENTO PREVIAMENTE CADASTRADO.
    public Evento atualizarEvento(Long id, Evento eventoAtualizado){
        Optional<Evento> eventoExistente = eventoRepository.findById(id);
        if(eventoExistente.isPresent()){
            Evento evento = eventoExistente.get();
            evento.setTitulo(eventoAtualizado.getTitulo());
            evento.setDtInicio(eventoAtualizado.getDtInicio());
            evento.setDtFim(eventoAtualizado.getDtFim());
            evento.setResumo(eventoAtualizado.getResumo());
            evento.setValorEntrada(eventoAtualizado.getValorEntrada());
            return eventoRepository.save(evento);
        }else{
            throw new IllegalArgumentException("Evento não encontrado para o ID = " + id + " fornecido");
        }
    }

}
