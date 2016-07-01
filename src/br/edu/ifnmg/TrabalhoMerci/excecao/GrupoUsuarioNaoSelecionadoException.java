package br.edu.ifnmg.TrabalhoMerci.excecao;

/**
 *
 * @author victor
 */
public class GrupoUsuarioNaoSelecionadoException extends TratarMerciExceptions{
    public GrupoUsuarioNaoSelecionadoException(){
        super("Nenhuma opção de função selecionada");
    }
}
