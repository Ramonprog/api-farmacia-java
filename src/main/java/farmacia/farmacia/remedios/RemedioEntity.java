package farmacia.farmacia.remedios;

import farmacia.farmacia.remedios.dto.DadosAtualizarRemedios;
import farmacia.farmacia.remedios.dto.DadosCadastroRemedios;
import farmacia.farmacia.remedios.enuns.Via;
import farmacia.farmacia.remedios.enuns.lab;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Future;
import lombok.*;

import java.time.LocalDate;

@Table(name="remedio")
@Entity(name="remedios")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class RemedioEntity {
    public RemedioEntity(DadosCadastroRemedios dados) {
        this.nome = dados.nome();
        this.via = dados.via();
        this.lote = dados.lote();
        this.quantidade = dados.quantidade();
        this.validade = dados.validade();
        this.laboratorio = dados.laboratorio();
    }

    public void atualizarInfos(@Valid DadosAtualizarRemedios dados){
        if(dados.nome() != null){
            this.nome = dados.nome();
        }

        if(dados.via() != null) {
            this.nome = String.valueOf(dados.via());
        }
    }

    @Id
    //identifica que o DB gera o ID autometicamente
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    //Tipo de atributo é um enum e tem que ser mapeado pelo JPA
    @Enumerated(EnumType.STRING)
    private Via via;
    private String lote;
    private Integer quantidade;
    //não permite datas anteriores
    @Future
    private LocalDate validade;
    @Enumerated(EnumType.STRING)
    private lab laboratorio;

}
