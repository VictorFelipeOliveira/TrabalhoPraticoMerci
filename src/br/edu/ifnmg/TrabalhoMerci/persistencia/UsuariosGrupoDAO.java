package br.edu.ifnmg.TrabalhoMerci.persistencia;

import br.edu.ifnmg.TrabalhoMerci.entidade.GrupoUsuarios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author victor
 */
public class UsuariosGrupoDAO {
    private static final String INSERT_USUARIOS_GRUPO = "INSERT INTO GRUPOUSUARIOS (ID, SIGLAFUNCAO) VALUES (? ?)";
    private static final String SELECT_USUARIOS_GRUPO_LOGIN = "SELECT GRUPOUSUARIOS_FK FROM USUARIOS_GRUPO WHERE USUARIO_FK = ?";
    //private static final String DELETE_USUARIO_GRUPO_USUARIO =" DELETE FROM USUARIO_GRUPO_USUARIO WHERE USUARIO_FK = ?";
    //private static final String UPDADE_LOGIN_USUARIO_GRUPO_USUARIO = "UPDATE USUARIO_GRUPO_USUARIO SET LOGIN = ? WHERE LOGIN = ?";
    
    public boolean cadastrarUsuariosGrupo( String loginUsuario, int funcaoGrupo) throws SQLException {
        
        Connection conexao = null;
        PreparedStatement comando = null;
        boolean status = false;
        
        try{
            
            conexao = BancoDadosUtil.getConnection();
            comando = conexao.prepareStatement(INSERT_USUARIOS_GRUPO);
            comando.setString( 1, loginUsuario);
            comando.setInt(2, funcaoGrupo);
            comando.execute();
     
            conexao.commit();

            status = true;
            
        } catch( Exception ex){
            if( comando != null)
                conexao.rollback();
        }finally{
            BancoDadosUtil.fecharChamadasBancoDados(conexao, comando);
        }
        return status;
    }
    
    public GrupoUsuarios selectGrupoUsuarioLogin(String loginUsuario) throws SQLException {
        GrupoUsuarios grupoUsuarios = new GrupoUsuarios();
        
        ResultSet resultado = null;
        Connection conexao = null;
        PreparedStatement comando = null;
        
        try{
            conexao = BancoDadosUtil.getConnection();
            comando = conexao.prepareStatement( SELECT_USUARIOS_GRUPO_LOGIN);
            comando.setString( 1, loginUsuario);
            
            resultado = comando.executeQuery();
                    
            while(resultado.next()){
                switch(resultado.getInt(1)){
                    case 1: grupoUsuarios.setGerente(1);
                            break;
                    case 2: grupoUsuarios.setGestorEstoque(1);
                            break;
                    case 3: grupoUsuarios.setGestorCompras(1);
                            break;
                    case 4: grupoUsuarios.setCaixeiro(1);
                            break;
                }
            }
        }finally{
            BancoDadosUtil.fecharChamadasBancoDados(conexao, comando, resultado);
        }
        
        return grupoUsuarios;
    }
}
