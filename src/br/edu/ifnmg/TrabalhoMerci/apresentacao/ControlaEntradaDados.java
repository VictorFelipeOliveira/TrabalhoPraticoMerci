package br.edu.ifnmg.TrabalhoMerci.apresentacao;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class ControlaEntradaDados extends PlainDocument{
    int tamanhoTotal = 0;
    String defineTipoDados = "";
    public ControlaEntradaDados(int tamanho,String tipoDados) {
            this.tamanhoTotal = tamanho;
            this.defineTipoDados = tipoDados;
    }
    
    @Override
    public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
        int tamanhoTotalString = this.getLength() + str.length();
        if(str == null)
               return;
        
        if(tamanhoTotalString<=tamanhoTotal){
            String filtraCaractereEspecial = str.replaceAll(defineTipoDados,"");
            super.insertString(offs, filtraCaractereEspecial, a);
        }
        else {
            super.insertString(offs, "", a);
        }
    }
}

