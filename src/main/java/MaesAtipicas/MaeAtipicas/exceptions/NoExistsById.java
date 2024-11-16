package MaesAtipicas.MaeAtipicas.exceptions;

public class NoExistsById extends RuntimeException {
    public NoExistsById(Long id) {
        super("Usuario nao encontrado!");
    }
}
