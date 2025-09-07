package farmacia.farmacia.exceptions;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//@RestControllerAdvice responsavel para toda vez que acontecer alguma exception
//a class vai verificar se está tratando a exception e determinar o tratamento
//caso nao tenha, o spriing retorna o 500
@RestControllerAdvice
public class Erros {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<?> tratarErro404() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> Tratator400(MethodArgumentNotValidException ex){
        var erro = ex.getFieldError();
        return ResponseEntity.badRequest()
                .body("Erro de validação no campo: " + erro.getField() + " - " + erro.getDefaultMessage());
    }

    // Tratamento genérico para outros erros não previstos
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> tratarErro500(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Ocorreu um erro inesperado: " + ex.getMessage());
    }
}
