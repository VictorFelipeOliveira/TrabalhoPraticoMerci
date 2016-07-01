package br.edu.ifnmg.TrabalhoMerci.excecao;

/**
 *
 * @author victor
 */
public class UsuarioNaoEncontradoException extends TratarMerciExceptions{
    public UsuarioNaoEncontradoException(){
        super("Usuário não encontrado");
    }
}
