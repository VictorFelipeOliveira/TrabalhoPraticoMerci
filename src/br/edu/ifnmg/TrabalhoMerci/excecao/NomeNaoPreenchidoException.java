package br.edu.ifnmg.TrabalhoMerci.excecao;

/**
 *
 * @author victor
 */
public class NomeNaoPreenchidoException extends TratarMerciExceptions{
    public NomeNaoPreenchidoException(){
        super("Campo nome não preenchido");
    }
}
