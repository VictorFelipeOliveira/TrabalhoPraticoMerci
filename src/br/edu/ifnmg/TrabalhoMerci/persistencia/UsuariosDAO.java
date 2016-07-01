package br.edu.ifnmg.TrabalhoMerci.persistencia;

import br.edu.ifnmg.TrabalhoMerci.entidade.Usuarios;
import br.edu.ifnmg.TrabalhoMerci.excecao.UsuarioNaoEncontradoException;
import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author victor
 */
public class UsuariosDAO {
    
    private static final String SQL_AUTENTICAR = "SELECT * FROM USUARIOS WHERE LOGIN = ? AND SENHA = ?";
    private static final String SQL_INSERT = "INSERT INTO USUARIOS (LOGIN, NOME, SENHA) VALUES (?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE USUARIOS SET SENHA = ? WHERE ID = ?";
    private static final String SQL_DELETE = "DELETE USUARIOS SET LOGIN = ?, NOME = ?, SENHA = ? WHERE ID = ?";
    private static final String SQL_SELECT_USUARIO_LOGIN = "SELECT CODIGO, NOME, LOGIN, SENHA FROM USUARIO WHERE LOGIN = ?;";
    private static final String SQL_LISTAR_TODOS = "SELECT ID, LOGIN, NOME, SENHA FROM USUARIOS";
    
    public Usuarios autenticar(String login, String senha) throws SQLException{
    
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;
        Usuarios usuarioAutenticar = null;   
        try{
            conexao = BancoDadosUtil.getConnection();
            comando = conexao.prepareStatement(SQL_AUTENTICAR); 
            comando.setString(1, login); 
            comando.setString(2, senha);
            resultado = comando.executeQuery();
            
            while(resultado.next()){
                usuarioAutenticar = new Usuarios();
                usuarioAutenticar.setNome(resultado.getString(1));
                usuarioAutenticar.setLogin(resultado.getString(2));
            }
        }catch(Exception e){
            if(conexao != null)
                conexao.rollback();           
        }finally{
            BancoDadosUtil.fecharChamadasBancoDados(conexao, comando, resultado);
        }
        return usuarioAutenticar;
    }
    
    public void inserir(Usuarios usuarios) throws SQLException{
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultSet;
               
        try{
            conexao = BancoDadosUtil.getConnection();
            comando = conexao.prepareStatement(SQL_INSERT);

            comando.setString(1, usuarios.getLogin());
            comando.setString(2, usuarios.getNome());
            comando.setString(3, usuarios.getSenha());

            comando.execute();
            conexao.commit();
         
        }catch(Exception e){
            if(conexao != null)
                conexao.rollback();
            throw e;
        }finally{
            BancoDadosUtil.fecharChamadasBancoDados(conexao, comando);
        }
    }
    
    public void atualizar(Usuarios usuarios) throws SQLException {
        Connection conexao = null;
        PreparedStatement comando = null;

        try {
           
            conexao = BancoDadosUtil.getConnection();
            comando = conexao.prepareStatement(SQL_UPDATE);
            comando.setString(1, usuarios.getLogin());
            comando.setString(2, usuarios.getNome());
            comando.setString(3, usuarios.getSenha());
            comando.execute();
            conexao.commit();
        } catch (Exception e){
            if (conexao != null){
                conexao.rollback();
            }
            throw e;
        } finally {
            BancoDadosUtil.fecharChamadasBancoDados(conexao, comando);
        }
    } 
    
    public void remover(Usuarios usuarios) throws SQLException{
        Connection conexao = null;
        PreparedStatement comando = null;
        
        try{
            conexao = BancoDadosUtil.getConnection();
            comando = conexao.prepareStatement(SQL_DELETE);
            comando.setString(1,usuarios.getSenha());
            comando.execute();
            conexao.commit();
        }catch(Exception e){
            if(conexao!=null)
                conexao.rollback();
            throw e;
        }finally{
            BancoDadosUtil.fecharChamadasBancoDados(conexao, comando);
        }
    }
    
    public Usuarios buscarUsuarioLogin(String login) throws SQLException, UsuarioNaoEncontradoException {      //funcao clonada
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;
        
        Usuarios usuarios = null;
        
        try{
            conexao = BancoDadosUtil.getConnection();
            comando = conexao.prepareStatement(SQL_SELECT_USUARIO_LOGIN);
            comando.setString( 1,login);
            resultado = comando.executeQuery();
            
            if( resultado.next()){
                usuarios = this.extrairLinha( resultado);
               
            }else
                throw new UsuarioNaoEncontradoException();
        }finally{
            BancoDadosUtil.fecharChamadasBancoDados(conexao, comando, resultado);
        }
        
        return usuarios;
    }
    
    private Usuarios extrairLinha(ResultSet resultado) throws SQLException {    //funcao clonada
        
        Usuarios usuarioNovo = new Usuarios();
        
        //usuarioNovo.setID( resultado.getInt( 1));
        usuarioNovo.setNome( resultado.getString(2));
        usuarioNovo.setLogin( resultado.getString(3));
        usuarioNovo.setSenha( resultado.getString(4));
                
        return usuarioNovo;
    }
    
    public LinkedList<String> selecionaUsuariosCadastrados() throws SQLException{
        Connection conexao = null;
        PreparedStatement comando = null;
        ResultSet resultado = null;
        LinkedList<String> listaUsuarios = new LinkedList<>();
        
        try{
            conexao = BancoDadosUtil.getConnection();
            comando = conexao.prepareStatement(SQL_LISTAR_TODOS);
         
            resultado = comando.executeQuery();
            
            while( resultado.next())
                listaUsuarios.add( resultado.getString(1));
        }finally{
            BancoDadosUtil.fecharChamadasBancoDados(conexao, comando, resultado);
        }
        
        return listaUsuarios;
    }
}
