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

    @ExceptionHandler(NoExistsById.class)
    public ResponseEntity<ErrorResponse> handleNoExistsById(NoExistsById e){
        ErrorResponse errorResponse = new ErrorResponse("Usuario nao encontrado!", e.getMessage());
        return  new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<ErrorResponse> handleNoId(NoId e){
        ErrorResponse errorResponse = new ErrorResponse("Nenhum usuario", e.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
