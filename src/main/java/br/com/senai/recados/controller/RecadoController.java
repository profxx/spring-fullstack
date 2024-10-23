package br.com.senai.recados.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.senai.recados.entity.Recado;
import br.com.senai.recados.repository.RecadoRepository;
import br.com.senai.recados.service.RecadoService;

@RestController
@RequestMapping("/recados")
public class RecadoController {

    @Autowired
    private RecadoService recadoService;

    @Autowired
    private RecadoRepository recadoRepository;

    @GetMapping
    public List<Recado> findAll(){
        return recadoService.findAll();
    }
    @GetMapping("/{id}")
    public Recado findById(@PathVariable Long id){
        return recadoService.findById(id);
    }
    @PostMapping
    public Recado insertNew(@RequestBody Recado recado){
        return recadoRepository.save(recado);
    }
    @PutMapping("/{id}")
    public Recado conclude(Long id){
        Recado recadoAtual = recadoService.findById(id);
        recadoAtual.setCompletado(true);
        return recadoAtual;
    }
    @DeleteMapping("{id}")
    public Boolean deleteById(Long id){
        return recadoService.deleteById(id);
    }
}
