package br.edu.ifnmg.TrabalhoMerci.entidade;

public class Usuarios {
    private String nome;
    private String login;
    private String senha;
    private GrupoUsuarios grupoUsuarios = new GrupoUsuarios();

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getSenha() {
        return senha;
    }

    public void setGrupoUsuarios(GrupoUsuarios grupoUsuarios) {
        this.grupoUsuarios = grupoUsuarios;
    }

    public GrupoUsuarios getGrupoUsuarios() {
        return grupoUsuarios;
    }
}
