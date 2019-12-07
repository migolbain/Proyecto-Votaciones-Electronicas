/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloDAO;

import util.ConexionBD;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import modeloVO.PropuestaVO;
import java.util.ArrayList;
import util.InterfaceCRUD;

/**
 *
 * @author APRENDIZ
 */
public class PropuestaDAO extends ConexionBD implements InterfaceCRUD {

    private Connection conexion = null;
    private Statement puente = null;
    private ResultSet mensajero = null;

    private String ID_Propuesta = "";
    private String VideoURL_Propuesta = "";
    private String Descripcion_Propuesta = "";
    private String No_Propuesta = "";
    private String ID_Persona = "";
    private String Nombres_persona = "";
    private String PrimerApellido_Persona = "";
    private String Documento_Persona = "";
    private boolean operaciones = false;

    public PropuestaDAO(PropuestaVO propuestaVO) {
        super();
        try {
            conexion = this.obtenerConexion();
            puente = conexion.createStatement();

            ID_Propuesta = propuestaVO.getID_Propuesta();
            VideoURL_Propuesta = propuestaVO.getVideoURL_Propuesta();
            Descripcion_Propuesta = propuestaVO.getDescripcion_Propuesta();
            No_Propuesta = propuestaVO.getNo_Propuesta();
            ID_Persona = propuestaVO.getID_Persona();
            Nombres_persona = propuestaVO.getNombres_persona();
            PrimerApellido_Persona = propuestaVO.getPrimerApellido_Persona();
            Documento_Persona = propuestaVO.getDocumento_Persona();
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        }
    }

    @Override
    public boolean agregarRegistro() {
        try {
            CallableStatement call = conexion.prepareCall("call pa_insertarpropuesta (?,?,?,?,?);");

            call.setString(1, ID_Propuesta);
            call.setString(2, No_Propuesta);
            call.setString(3, VideoURL_Propuesta);
            call.setString(4, Descripcion_Propuesta);
            call.setString(5, ID_Persona);

            call.executeUpdate();
            operaciones = true;
            this.cerrarConexion();
        } catch (Exception e) {
            System.out.println("¡Error!: " + e.toString());
        }
        return operaciones;
    }

    @Override
    public boolean actualizarRegistro() {
        try {
            CallableStatement call = conexion.prepareCall("call pa_actualizarpropuesta(?,?,?);");

            call.setString(1, ID_Propuesta);
            call.setString(2, No_Propuesta);
            call.setString(3, Descripcion_Propuesta);

            call.executeUpdate();
            operaciones = true;
            this.cerrarConexion();
        } catch (Exception e) {
            System.out.println("¡Error!: " + e.toString());
        }
        return operaciones;

    }

    public boolean eliminarRegistro(int id_propuesta) {
        try {
            CallableStatement call = conexion.prepareCall("call pa_eliminarpropuesta(?);");
            call.setInt(1, id_propuesta);

            call.executeUpdate();
            operaciones = true;
            this.cerrarConexion();
        } catch (Exception e) {
            System.out.println("¡Error!: " + e.toString());
        }

        return operaciones;

    }

    public ArrayList<PropuestaVO> listarpropuestasusuario(int id_persona) {

        ConexionBD conexion2 = new ConexionBD();
        ArrayList<PropuestaVO> listapropuestasusuario = new ArrayList<>();

        try {

            CallableStatement callStat = conexion2.obtenerConexion().prepareCall("call listapropuestasusuario(?)");

            callStat.setInt(1, id_persona);

            mensajero = callStat.executeQuery();

            while (mensajero.next()) {

                ID_Propuesta = mensajero.getString("ID_Propuesta");
                VideoURL_Propuesta = mensajero.getString("VideoURL_Propuesta");
                Descripcion_Propuesta = mensajero.getString("Descripcion_Propuesta");
                No_Propuesta = mensajero.getString("No_Propuesta");
                ID_Persona = mensajero.getString("ID_Persona");

                PropuestaVO PropuestaVO2 = new PropuestaVO();

                PropuestaVO2.setDescripcion_Propuesta(Descripcion_Propuesta);
                PropuestaVO2.setVideoURL_Propuesta(VideoURL_Propuesta);
                PropuestaVO2.setID_Propuesta(ID_Propuesta);
                PropuestaVO2.setNo_Propuesta(No_Propuesta);
                PropuestaVO2.setID_Persona(ID_Persona);

                listapropuestasusuario.add(PropuestaVO2);

            }
        } catch (SQLException e) {

            System.out.println("¡Error!: " + e.toString());
        }
        return listapropuestasusuario;
    }

    public ArrayList<PropuestaVO> listarpropuestaadministrador() {
        ArrayList<PropuestaVO> listapropuestasadmin = new ArrayList<>();
        ConexionBD conexion2 = new ConexionBD();
        try {

            CallableStatement callStat = conexion2.obtenerConexion().prepareCall("call listapropuestasadministrador");
            mensajero = callStat.executeQuery();
            while (mensajero.next()) {

                ID_Propuesta = mensajero.getString("ID_Propuesta");
                VideoURL_Propuesta = mensajero.getString("VideoURL_Propuesta");
                Descripcion_Propuesta = mensajero.getString("Descripcion_Propuesta");
                No_Propuesta = mensajero.getString("No_Propuesta");
                ID_Persona = mensajero.getString("ID_Persona");

                Nombres_persona = mensajero.getString("Nombres_Persona");
                PrimerApellido_Persona = mensajero.getString("PrimerApellido_Persona");
                Documento_Persona = mensajero.getString("Documento_Persona");
                PropuestaVO PropuestaVO2 = new PropuestaVO();

                PropuestaVO2.setDescripcion_Propuesta(Descripcion_Propuesta);
                PropuestaVO2.setVideoURL_Propuesta(VideoURL_Propuesta);
                PropuestaVO2.setID_Propuesta(ID_Propuesta);
                PropuestaVO2.setNo_Propuesta(No_Propuesta);
                PropuestaVO2.setID_Persona(ID_Persona);
                PropuestaVO2.setNombres_persona(Nombres_persona);
                PropuestaVO2.setPrimerApellido_Persona(PrimerApellido_Persona);
                PropuestaVO2.setDocumento_Persona(Documento_Persona);

                listapropuestasadmin.add(PropuestaVO2);
            }
        } catch (SQLException e) {

            System.out.println("¡Error!: " + e.toString());
        }
        return listapropuestasadmin;
    }

    public ArrayList<PropuestaVO> listarpropuestasactualizar(int id_propuesta) {

        ConexionBD conexion2 = new ConexionBD();
        ArrayList<PropuestaVO> listapropuestasactualizar = new ArrayList<>();

        try {

            CallableStatement callStat = conexion2.obtenerConexion().prepareCall("call listapropuestaactualizar(?)");

            callStat.setInt(1, id_propuesta);

            mensajero = callStat.executeQuery();

            while (mensajero.next()) {

                ID_Propuesta = mensajero.getString("id_propuesta");
                VideoURL_Propuesta = mensajero.getString("VideoURL_Propuesta");
                Descripcion_Propuesta = mensajero.getString("Descripcion_Propuesta");
                No_Propuesta = mensajero.getString("No_Propuesta");
                ID_Persona = mensajero.getString("ID_Persona");

                PropuestaVO PropuestaVO2 = new PropuestaVO();

                PropuestaVO2.setDescripcion_Propuesta(Descripcion_Propuesta);
                PropuestaVO2.setVideoURL_Propuesta(VideoURL_Propuesta);
                PropuestaVO2.setID_Propuesta(ID_Propuesta);
                PropuestaVO2.setNo_Propuesta(No_Propuesta);
                PropuestaVO2.setID_Persona(ID_Persona);

                listapropuestasactualizar.add(PropuestaVO2);

            }
        } catch (SQLException e) {

            System.out.println("¡Error!: " + e.toString());
        }
        return listapropuestasactualizar;
    }

    public ArrayList<PropuestaVO> listarpropuestainsertar(int id_persona) {

        ConexionBD conexion2 = new ConexionBD();
        ArrayList<PropuestaVO> listapropuestasactualizar = new ArrayList<>();

        try {

            CallableStatement callStat = conexion2.obtenerConexion().prepareCall("call listapropuestainsertar(?)");

            callStat.setInt(1, id_persona);

            mensajero = callStat.executeQuery();

            while (mensajero.next()) {

                ID_Propuesta = mensajero.getString("id_propuesta");
                VideoURL_Propuesta = mensajero.getString("VideoURL_Propuesta");
                Descripcion_Propuesta = mensajero.getString("Descripcion_Propuesta");
                No_Propuesta = mensajero.getString("No_Propuesta");
                ID_Persona = mensajero.getString("ID_Persona");

                PropuestaVO PropuestaVO2 = new PropuestaVO();

                PropuestaVO2.setDescripcion_Propuesta(Descripcion_Propuesta);
                PropuestaVO2.setVideoURL_Propuesta(VideoURL_Propuesta);
                PropuestaVO2.setID_Propuesta(ID_Propuesta);
                PropuestaVO2.setNo_Propuesta(No_Propuesta);
                PropuestaVO2.setID_Persona(ID_Persona);

                listapropuestasactualizar.add(PropuestaVO2);

            }
        } catch (SQLException e) {

            System.out.println("¡Error!: " + e.toString());
        }
        return listapropuestasactualizar;
    }

    public ArrayList<PropuestaVO> listarpropuestaultimaid() {
        ArrayList<PropuestaVO> listapropuestaultimaid = new ArrayList<>();
        ConexionBD conexion2 = new ConexionBD();
        try {

            CallableStatement callStat = conexion2.obtenerConexion().prepareCall("call listapropuestaultimaid");
            mensajero = callStat.executeQuery();
            while (mensajero.next()) {

                ID_Propuesta = mensajero.getString("id_propuesta");
                VideoURL_Propuesta = mensajero.getString("VideoURL_Propuesta");
                Descripcion_Propuesta = mensajero.getString("Descripcion_Propuesta");
                No_Propuesta = mensajero.getString("No_Propuesta");
                ID_Persona = mensajero.getString("ID_Persona");

                PropuestaVO PropuestaVO2 = new PropuestaVO();

                PropuestaVO2.setDescripcion_Propuesta(Descripcion_Propuesta);
                PropuestaVO2.setVideoURL_Propuesta(VideoURL_Propuesta);
                PropuestaVO2.setID_Propuesta(ID_Propuesta);
                PropuestaVO2.setNo_Propuesta(No_Propuesta);
                PropuestaVO2.setID_Persona(ID_Persona);

                listapropuestaultimaid.add(PropuestaVO2);

                listapropuestaultimaid.add(PropuestaVO2);
            }
        } catch (SQLException e) {

            System.out.println("¡Error!: " + e.toString());
        }
        return listapropuestaultimaid;
    }

    public PropuestaDAO() {

    }
}
