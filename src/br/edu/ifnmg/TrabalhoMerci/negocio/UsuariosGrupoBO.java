package br.edu.ifnmg.TrabalhoMerci.negocio;

import br.edu.ifnmg.TrabalhoMerci.entidade.GrupoUsuarios;
import br.edu.ifnmg.TrabalhoMerci.entidade.Usuarios;
import br.edu.ifnmg.TrabalhoMerci.persistencia.UsuariosGrupoDAO;
import java.sql.SQLException;

/**
 *
 * @author victor
 */
public class UsuariosGrupoBO {
    private static UsuariosGrupoDAO usuariosGrupoDAO = new UsuariosGrupoDAO(); 
    
    public boolean cadastrarGrupoUsuario( Usuarios usuarios,GrupoUsuarios grupoUsuarios, String loginUsuario) throws SQLException{
        
        boolean status = false;
        
        if( usuarios.getLogin().equals(loginUsuario)){
            System.out.println(usuarios.getLogin());
            if(grupoUsuarios.getGerente()==1){
                  if(usuariosGrupoDAO.cadastrarUsuariosGrupo(loginUsuario, 1)){
                        status = true;
                    }
                }

            if(grupoUsuarios.getGestorCompras()==1){
                if(usuariosGrupoDAO.cadastrarUsuariosGrupo(loginUsuario, 2)){
                    status = true;
                }
            }

            if(grupoUsuarios.getGestorEstoque() == 1){
                if( usuariosGrupoDAO.cadastrarUsuariosGrupo(loginUsuario, 3))
                    status = true;
            }

            if( grupoUsuarios.getCaixeiro() == 1){
                if( usuariosGrupoDAO.cadastrarUsuariosGrupo(loginUsuario, 4))
                    status = true;
            }  
        }
        
        return status;
    }
}
