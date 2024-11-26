package MaesAtipicas.MaeAtipicas.exceptions;

public class NoIdException extends RuntimeException {
    public NoIdException(Long id) {
        super("nao existe usuarios");
    }
}
