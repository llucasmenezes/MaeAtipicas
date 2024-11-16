package MaesAtipicas.MaeAtipicas.exceptions;

public class NoId extends RuntimeException {
    public NoId(Long id) {
        super("nao existe usuarios");
    }
}
