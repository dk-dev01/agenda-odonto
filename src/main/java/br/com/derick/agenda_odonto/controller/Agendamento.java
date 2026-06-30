package br.com.derick.agenda_odonto.controller;

import br.com.derick.agenda_odonto.service.Agendamento;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping
public class Agendamento {
    private final Agendamento service;

    public Agendamento (Agendamento service){
        this.service=service;
    }

    @GetMapping
    public List<br.com.derick.agenda_odonto.model.Agendamento> listar(){
        return service.listar();
    }

    @PostMapping
    public ResponseEntity<?> criar(){
        try{
            return service.salvar(agendamento); //metodo no service
        }
        catch(Exception e){
            return "Erro: "+e.getMessage();
        }
    }

    @PutMapping
    public ResponseEntity<?> atualizar (Long id, br.com.derick.agenda_odonto.model.Agendamento agendamento){
        try{
            return service.atualizar(id, agendamento); //metodo no service
        }
        catch(Exception e){
            return "Erro: "+e.getMessage();
        }
    }

    @DeleteMapping
    public ResponseEntity<?> deletar (Long id){
        try{
            return service.deletar(id); //metodo no service
        }
        catch(Exception e){
            return "Erro: "+e.getMessage();
        }
    }
}
