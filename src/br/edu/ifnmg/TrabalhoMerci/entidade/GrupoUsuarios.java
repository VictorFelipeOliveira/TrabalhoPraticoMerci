package br.edu.ifnmg.TrabalhoMerci.entidade;

/**
 *
 * @author victor
 */
public class GrupoUsuarios {
    private int gerente;
    private int gestorEstoque;
    private int gestorCompras;
    private int caixeiro;

    public void setGerente(int gerente) {
        this.gerente = gerente;
    }

    public int getGerente() {
        return gerente;
    }

    public void setGestorEstoque(int gestorEstoque) {
        this.gestorEstoque = gestorEstoque;
    }

    public int getGestorEstoque() {
        return gestorEstoque;
    }

    public void setGestorCompras(int gestorCompras) {
        this.gestorCompras = gestorCompras;
    }

    public int getGestorCompras() {
        return gestorCompras;
    }

    public void setCaixeiro(int caixeiro) {
        this.caixeiro = caixeiro;
    }

    public int getCaixeiro() {
        return caixeiro;
    }
}
