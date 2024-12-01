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
        ErrorResponse errorResponse = new ErrorResponse("Erro ao se cadastrar... ",e.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoExistsByIdException.class)
    public ResponseEntity<ErrorResponse> handleNoExistsById(NoExistsByIdException e){
        ErrorResponse errorResponse = new ErrorResponse("Ops... mãe não encontrada", e.getMessage());
        return  new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGenericException(Exception e){
        e.printStackTrace();

        ErrorResponse errorResponse = new ErrorResponse("Erro Interno do Servidor", e.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
