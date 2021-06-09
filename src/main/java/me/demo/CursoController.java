package me.demo;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CursoController{
    private final CursoRepository repository;

    public CursoController(CursoRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/curso")
    List<Curso> all() {
        return repository.findAll();
    }

    @PostMapping("/curso")
    Curso newCurso(@RequestBody Curso newCurso){
        
        return repository.save(newCurso);
    }

    @PutMapping("/curso/{id}")
    Curso replaceCurso(@RequestBody Curso newCurso, @PathVariable Long id){
        return repository.findById(id)
                .map(curso -> {
        curso.setNome(newCurso.getNome());
        curso.setDescricao(newCurso.getDescricao());
        curso.setEmenta(newCurso.getEmenta());
        curso.setDataCadastro(newCurso.getDataCadastro());
        curso.setDataInicio(newCurso.getDataInicio());
        curso.setValor(newCurso.getValor());

        return repository.save(curso);
      })
      .orElseGet(() -> {
        newCurso.setId(id);
        return repository.save(newCurso);
      });
    }

    @DeleteMapping("/curso/{id}")
    void deleteEmployee(@PathVariable long id){
        repository.deleteById(id);
    }
}