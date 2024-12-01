package MaesAtipicas.MaeAtipicas.exceptions;



public class CpfDuplicadoException extends RuntimeException {
    public CpfDuplicadoException(String cpf) {
        super("A mãe com o CPF: " + cpf + " já está cadastrada no sistema. :) ");
    }

}


