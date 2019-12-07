/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloDAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import modeloVO.LanzarseCandidatoVO;
import util.ConexionBD;
import util.InterfaceCRUD;

/**
 *
 * @author migol
 */
public class LanzarseCandidatoDAO extends ConexionBD implements InterfaceCRUD {

    private Connection conexion = null;
    private Statement puente = null;
    private ResultSet mensajero = null;
 
    private String ID_Usuario = "";
    private String ID_Persona = "";
    private String Estado_Candidato = "";
    private String ID_RolUsu = "";
    
    private boolean operaciones = false;
    
    public LanzarseCandidatoDAO(LanzarseCandidatoVO lanzarseCandidatoVO) {

        super();
        try {

            conexion = this.obtenerConexion();
            puente = conexion.createStatement();

            ID_Usuario = lanzarseCandidatoVO.getID_Usuario();
            ID_Persona = lanzarseCandidatoVO.getID_Persona();
            Estado_Candidato = lanzarseCandidatoVO.getEstado_Candidato();
            ID_RolUsu = lanzarseCandidatoVO.getID_RolUsu();

        } catch (Exception e) {
            System.out.println("¡Error!: " + e.toString());
        }

    }

    @Override
    public boolean agregarRegistro() {
        return operaciones; 
    }

    @Override
    public boolean actualizarRegistro() {
 try {
            CallableStatement call = conexion.prepareCall("call pa_lanzarsecandidatousuario (?,?);");
            CallableStatement call2 = conexion.prepareCall("call pa_lanzarsecandidatopersona (?,?);");
            call.setString(1, ID_Usuario);
            call.setString(2, ID_RolUsu);

            
            call2.setString(1, ID_Persona);
            call2.setString(2, Estado_Candidato);
           
            call.executeUpdate();
            call2.executeUpdate();
        } catch (Exception e) {
            System.out.println("¡Error!: " + e.toString());
        }
        return operaciones;    
    }
}
    


