package br.edu.ifnmg.TrabalhoMerci.excecao;

public class loginNaoPreenchidoException extends TratarMerciExceptions{
    public loginNaoPreenchidoException(){
        super("Campo login não preenchido");
    }
}
