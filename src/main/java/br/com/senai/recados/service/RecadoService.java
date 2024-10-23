package br.com.senai.recados.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senai.recados.entity.Recado;
import br.com.senai.recados.repository.RecadoRepository;

@Service
public class RecadoService {

    @Autowired
    private RecadoRepository recadoRepository;

    public List<Recado> findAll(){
        return recadoRepository.findAll();
    }

    public Recado findById(Long id){
        return recadoRepository.findById(id).orElse(null);
    }

    public Recado insertNew(Recado recado){
        return recadoRepository.save(recado);
    }

    public Recado update(Long id, Recado recadoAlterado){
        Recado recadoAtual = findById(id);
        recadoAtual.setDescricao(recadoAlterado.getDescricao());
        recadoAtual.setCompletado(recadoAlterado.getCompletado());
        return recadoRepository.save(recadoAtual);
    }

    public Boolean deleteById(Long id){
        Recado recado = findById(id);
        if (recado == null){
            return false;
        }else{
            recadoRepository.deleteById(id);
            return true;
        }
    }
}
