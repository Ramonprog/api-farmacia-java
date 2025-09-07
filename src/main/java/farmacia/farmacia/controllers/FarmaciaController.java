package farmacia.farmacia.controllers;

import farmacia.farmacia.remedios.DadosListagemRemedio;
import farmacia.farmacia.remedios.RemedioEntity;
import farmacia.farmacia.remedios.RemedioRepository;
import farmacia.farmacia.remedios.dto.DadosAtualizarRemedios;
import farmacia.farmacia.remedios.dto.DadosCadastroRemedios;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/remedios")
public class FarmaciaController {
    //Autowired faz com que todos os metodos do repository possam ser usados
    @Autowired
    private RemedioRepository repository;
    @PostMapping
    @Transactional
    //   @Transactional - caso de erro a transição é revertida, evitando quebra de dados ou inconsistencias
    public void insertMedicine(@RequestBody @Valid DadosCadastroRemedios dados){
        repository.save(new RemedioEntity(dados));
    };

    @GetMapping
    public List<DadosListagemRemedio> listar() {
        return repository.findAll() // busca tudo no banco
                .stream()           // transforma em "stream" (tipo array)
                .map(DadosListagemRemedio::new) // mapeia cada entidade -> DTO
                .toList();          // junta de volta em uma lista
    }

    @PutMapping
    @Transactional // se der ruim ela restaura os dados, faz o rollback
    public ResponseEntity<String> atualizar(@RequestBody @Valid DadosAtualizarRemedios dados) {
        var remedioSelecionado = repository.getReferenceById(dados.Id());
        remedioSelecionado.atualizarInfos(dados);
        return ResponseEntity.ok("Dados atualizados com sucesso");
    }
}

