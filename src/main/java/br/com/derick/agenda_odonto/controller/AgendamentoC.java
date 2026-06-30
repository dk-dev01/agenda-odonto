package br.com.derick.agenda_odonto.controller;

//import br.com.derick.agenda_odonto.model.Agendamento;
import br.com.derick.agenda_odonto.service.AgendamentoS;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping ("/api/agendamentos") //caminho padrao no navegador
public class AgendamentoC {
    private final AgendamentoS service;

    public AgendamentoC(AgendamentoS service){
        this.service=service;
    }

    @GetMapping
    public List<br.com.derick.agenda_odonto.model.Agendamento> listar(){
        return service.listar();
    }

    @PostMapping
    public ResponseEntity<?> criar(@Valid @RequestBody br.com.derick.agenda_odonto.model.Agendamento a){ //valida e faz peghar json
        try{
            return ResponseEntity.ok(service.salvar(a)); //metodo no service
        }
        catch(Exception e){
            return ResponseEntity.badRequest().body("Erro: "+e.getMessage()); //erro 400
        }
    }

    @PutMapping ("/{id}") //tipo where id = 1
    public ResponseEntity<?> atualizar (Long id, @Valid @RequestBody br.com.derick.agenda_odonto.model.Agendamento a){
        try{
            return ResponseEntity.ok(service.atualizar(id, a)); //200 ok
        }
        catch(Exception e){
            return ResponseEntity.badRequest().body("Erro: "+e.getMessage());
        }
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<?> deletar (Long id){
        try{
            service.deletar(id);
            return ResponseEntity.noContent().build(); //204 no content
        }
        catch(Exception e){
            return ResponseEntity.badRequest().body("Erro: "+e.getMessage());
        }
    }
}
