package br.edu.ifnmg.TrabalhoMerci.excecao;

/**
 *
 * @author victor
 */
public class SenhaNaoPreenchidaException extends TratarMerciExceptions{
    public SenhaNaoPreenchidaException(){
        super("Campo Senha não preenchida");
    }
}
