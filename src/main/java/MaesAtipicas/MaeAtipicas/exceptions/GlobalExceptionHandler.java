package MaesAtipicas.MaeAtipicas.exceptions;

import MaesAtipicas.MaeAtipicas.util.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CpfDuplicadoException.class)
    public ResponseEntity<ErrorResponse> handleCpfDuplicadoException(CpfDuplicadoException e){
        ErrorResponse errorResponse = new ErrorResponse("Cpf Existente!", e.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoExistsByIdException.class)
    public ResponseEntity<ErrorResponse> handleNoExistsById(NoExistsByIdException e){
        ErrorResponse errorResponse = new ErrorResponse("Usuario nao encontrado!", e.getMessage());
        return  new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoIdException.class)
    public ResponseEntity<ErrorResponse> handleNoId(NoIdException e){
        ErrorResponse errorResponse = new ErrorResponse("Nenhum usuario", e.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGenericException(Exception e){
        // Log detalhado para identificar a origem do erro
        e.printStackTrace();  // Ou use algum framework de logging, como SLF4J

        ErrorResponse errorResponse = new ErrorResponse("Erro Interno do Servidor", e.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
