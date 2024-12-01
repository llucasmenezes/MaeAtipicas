package MaesAtipicas.MaeAtipicas.exceptions;

public class NoExistsByIdException extends RuntimeException {
    public NoExistsByIdException(Long id) {
        super("Mae, verifique se os dados estão corrretos " + 
                " e tente novamente ! ");
    }
}
