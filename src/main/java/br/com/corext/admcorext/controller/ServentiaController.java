package br.com.corext.admcorext.controller;

import java.util.List;
// import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.corext.admcorext.model.Serventias;
import br.com.corext.admcorext.repository.ServentiasRepository;

@RestController
@RequestMapping("/serventias")
public class ServentiaController {

    @Autowired
    private ServentiasRepository serventiasRepository;

    @GetMapping
    public List<Serventias> getAllServentias() {

        List<Serventias> serventias = serventiasRepository.findAll();

        return serventias;
    }

    @GetMapping("/{id}")
    Serventias one(@PathVariable Long id) {

        List<Serventias> serv = serventiasRepository.findAll();
        for (Serventias o : serv) {
            System.out.println(o.getId());
        }
        return serventiasRepository.getReferenceById(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> newServentia(@RequestBody Serventias newServentia) throws Exception {

        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom Header", "CREATED SUCCESS!");

        String respBody = "Serventia Criada com Sucesso";

        ResponseEntity<Object> entity = ResponseEntity.status(200).headers(headers).body(respBody);

        Serventias serv = new Serventias();
        serv.setNome(newServentia.getNome());
        serv.setEmail(newServentia.getEmail());
        serv.setBairro(newServentia.getBairro());
        serventiasRepository.save(serv);

        System.out.println(newServentia);

        return entity;
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> deleteServentia(@PathVariable("id") Serventias entityId){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom Header", "COMANDO RECEBIDO COM SUCESSO!");
 
        String respBody = entityId + " EXCLUÍDO COM SUCESSO!";
        
        ResponseEntity<Object> entity = ResponseEntity.status(200).headers(headers).body(respBody);
        serventiasRepository.delete(entityId);

        System.out.println(respBody);

        return entity;
    }

}