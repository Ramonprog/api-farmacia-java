package farmacia.farmacia.remedios.dto;

import farmacia.farmacia.remedios.enuns.Via;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizarRemedios(@NotNull Long Id, String nome, Via via) {

}
