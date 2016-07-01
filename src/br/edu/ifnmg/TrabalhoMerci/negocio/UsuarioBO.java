package br.edu.ifnmg.TrabalhoMerci.negocio;
import br.edu.ifnmg.TrabalhoMerci.apresentacao.TelaUsuarios;
import br.edu.ifnmg.TrabalhoMerci.entidade.GrupoUsuarios;
import br.edu.ifnmg.TrabalhoMerci.entidade.Usuarios;
import br.edu.ifnmg.TrabalhoMerci.excecao.SenhaNaoPreenchidaException;
import br.edu.ifnmg.TrabalhoMerci.excecao.UsuarioNaoEncontradoException;
import br.edu.ifnmg.TrabalhoMerci.persistencia.UsuariosDAO;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.LinkedList;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Victor 
 */
public class UsuarioBO {
    
    private static UsuariosDAO usuariosDAO = new UsuariosDAO();
    private static UsuariosGrupoBO usuariosGruposBO = new UsuariosGrupoBO();
    
    public Usuarios autenticar(String login, String senha) throws SQLException, UsuarioNaoEncontradoException{
        Usuarios usuarioExistente = null;
        UsuariosDAO usuarioDAO = new UsuariosDAO();
        usuarioExistente = usuarioDAO.autenticar(login, senha);
        if(usuarioExistente == null)
            throw new UsuarioNaoEncontradoException();
         
        return usuarioExistente;
    }
    
    public boolean inserirUsuario(Usuarios usuarios)throws SQLException{
        UsuariosDAO usuariosDAO = new UsuariosDAO();
        usuariosDAO.inserir(usuarios);
        return true;
    }
    
    public void atualizar(Usuarios usuarios) throws SQLException{
        UsuariosDAO usuariosDAO = new UsuariosDAO();
        usuariosDAO.atualizar(usuarios);
    }
    
    
    private LinkedList<String> selecionaUsuariosCadastrados() throws SQLException{
        return usuariosDAO.selecionaUsuariosCadastrados();
    }
}
