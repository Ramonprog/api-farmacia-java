package farmacia.farmacia.remedios.dto;

import farmacia.farmacia.remedios.enuns.Via;
import farmacia.farmacia.remedios.enuns.lab;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record DadosCadastroRemedios(
            @NotBlank(message = "Name is mandatory")
            String nome,
            @Enumerated
            Via via,
            @NotBlank
            String lote,
            Integer quantidade,
            LocalDate validade,
            lab laboratorio) {
}
