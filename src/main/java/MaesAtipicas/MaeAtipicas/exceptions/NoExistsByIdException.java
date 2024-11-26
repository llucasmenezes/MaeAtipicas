package MaesAtipicas.MaeAtipicas.exceptions;

public class NoExistsByIdException extends RuntimeException {
    public NoExistsByIdException(Long id) {
        super("Usuario inexistente...");
    }
}
