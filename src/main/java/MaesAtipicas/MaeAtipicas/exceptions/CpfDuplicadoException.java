package MaesAtipicas.MaeAtipicas.exceptions;

public class CpfDuplicadoException extends RuntimeException {
    public CpfDuplicadoException(String cpf) {
        super("CPF " + cpf + " já está cadastrado no sistema.");
    }
}
