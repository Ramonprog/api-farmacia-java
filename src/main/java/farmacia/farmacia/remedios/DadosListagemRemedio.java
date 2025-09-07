package farmacia.farmacia.remedios;

import farmacia.farmacia.remedios.enuns.Via;
import farmacia.farmacia.remedios.enuns.lab;


import java.time.LocalDate;

public record DadosListagemRemedio(
        Long Id,
        String nome,
        Via via,
        String lote,
        Integer quantidade,
        LocalDate validade,
        lab laboratorio
   ) {
    public  DadosListagemRemedio(RemedioEntity remedio){
      this(
              remedio.getId(),
              remedio.getNome(),
              remedio.getVia(),
              remedio.getLote(),
              remedio.getQuantidade(),
              remedio.getValidade(),
              remedio.getLaboratorio()
              );
    }
}
