/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloDAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modeloVO.JornadaVotacionVO;
import modeloVO.VotoVO;
import util.ConexionBD;
import util.InterfaceCRUD;

/**
 *
 * @author migol
 */
public class JornadaVotacionDAO extends ConexionBD implements InterfaceCRUD {

    private Connection conexion = null;
    private Statement puente = null;
    private ResultSet mensajero = null;
    private ResultSet mensajero2 = null;

    private String ID_JornadaVotacion = "";
    private String Fecha_JornadaApertura = "";
    private String Fecha_JornadaCierre = "";
    private String Estado_JornadaVotacion = "";
    private String Fecha_Jornada = "";
    private String Estado_Voto = "";

    private String id_persona = "";
    private String tipoid_persona = "";
    private String documento_persona = "";
    private String nombres_persona = "";
    private String primerapellido_persona = "";
    private String segundoapellido_persona = "";
    private String genero_persona = "";
    private String correo_persona = "";
    private String estado_formacion = "";
    private String estado_candidato = "";
    private String id_usuario = "";
    private String id_jornada = "";

    private String ID_Detallejornada = "";

    private boolean operaciones = false;

    public JornadaVotacionDAO(JornadaVotacionVO jornadaVotacionVO) {
        super();
        try {
            conexion = this.obtenerConexion();
            puente = conexion.createStatement();

            ID_JornadaVotacion = jornadaVotacionVO.getID_JornadaVotacion();
            Fecha_JornadaApertura = jornadaVotacionVO.getFecha_JornadaApertura();
            Fecha_JornadaCierre = jornadaVotacionVO.getFecha_JornadaCierre();
            Estado_JornadaVotacion = jornadaVotacionVO.getEstado_JornadaVotacion();
            Fecha_Jornada = jornadaVotacionVO.getFecha_Jornada();
            Estado_Voto = jornadaVotacionVO.getEstado_Voto();

            id_persona = jornadaVotacionVO.getId_persona();
            nombres_persona = jornadaVotacionVO.getNombres_persona();
            primerapellido_persona = jornadaVotacionVO.getPrimerapellido_persona();
            segundoapellido_persona = jornadaVotacionVO.getSegundoapellido_persona();
            tipoid_persona = jornadaVotacionVO.getTipoid_persona();
            documento_persona = jornadaVotacionVO.getDocumento_persona();
            genero_persona = jornadaVotacionVO.getGenero_persona();
            correo_persona = jornadaVotacionVO.getCorreo_persona();
            estado_formacion = jornadaVotacionVO.getEstado_formacion();
            estado_candidato = jornadaVotacionVO.getEstado_candidato();
            id_jornada = jornadaVotacionVO.getId_jornada();
            id_usuario = jornadaVotacionVO.getId_usuario();

            ID_Detallejornada = jornadaVotacionVO.getID_Detallejornada();

        } catch (Exception e) {
            System.out.println("¡Error!: " + e.toString());
        }
    }

    @Override
    public boolean agregarRegistro() {
        try {
            CallableStatement call = conexion.prepareCall("call crearjornada(?,?,?,?,?);");

            call.setString(1, ID_JornadaVotacion);
            call.setString(2, Fecha_Jornada);
            call.setString(3, Fecha_JornadaApertura);
            call.setString(4, Fecha_JornadaCierre);
            call.setString(5, Estado_JornadaVotacion);

            call.executeUpdate();

            operaciones = true;
        } catch (Exception e) {
            System.out.println("¡Error!: " + e.toString());
        }
        return operaciones;
    }

    @Override
    public boolean actualizarRegistro() {
        try {
            CallableStatement call = conexion.prepareCall("call cerrarjornada (?,?,?);");
            CallableStatement call2 = conexion.prepareCall("call actualizarestadovoto(?)");
            call.setString(1, ID_JornadaVotacion);
            call.setString(2, Fecha_JornadaCierre);
            call.setString(3, Estado_JornadaVotacion = "Inactivo");

            call2.setString(1, Estado_Voto);
            call.executeUpdate();
            call2.executeUpdate();

            operaciones = true;
            this.cerrarConexion();
        } catch (Exception e) {
            System.out.println("¡Error!: " + e.toString());
        }
        return operaciones;
    }

    public boolean insertarpersonasdetalle() {

        ConexionBD conexion2 = new ConexionBD();
        try {

            CallableStatement callStat = conexion2.obtenerConexion().prepareCall("call consultarpersonas");

            mensajero = callStat.executeQuery();
            while (mensajero.next()) {

                id_persona = mensajero.getString("id_persona");
                tipoid_persona = mensajero.getString("TipoIdentificacion_persona");
                documento_persona = mensajero.getString("documento_persona");
                nombres_persona = mensajero.getString("Nombres_persona");
                primerapellido_persona = mensajero.getString("PrimerApellido_Persona");
                segundoapellido_persona = mensajero.getString("SegundoApellido_Persona");
                genero_persona = mensajero.getString("Genero_persona");
                correo_persona = mensajero.getString("Correo_persona");
                estado_formacion = mensajero.getString("Estado_Formacion");
                Estado_Voto = mensajero.getString("Estado_voto");
                estado_candidato = mensajero.getString("Estado_candidato");
                id_usuario = mensajero.getString("ID_Usuario");
                id_jornada = mensajero.getString("ID_Jornada");

                JornadaVotacionVO personas = new JornadaVotacionVO();

                personas.setId_persona(id_persona);
                personas.setTipoid_persona(tipoid_persona);
                personas.setDocumento_persona(documento_persona);
                personas.setNombres_persona(nombres_persona);
                personas.setPrimerapellido_persona(primerapellido_persona);
                personas.setSegundoapellido_persona(segundoapellido_persona);
                personas.setGenero_persona(genero_persona);
                personas.setCorreo_persona(correo_persona);
                personas.setEstado_formacion(estado_formacion);
                personas.setEstado_Voto(Estado_Voto);
                personas.setEstado_candidato(estado_candidato);
                personas.setId_usuario(id_usuario);
                personas.setId_jornada(id_jornada);

                CallableStatement callStat2 = conexion2.obtenerConexion().prepareCall("call consultarultimajornada");
                mensajero2 = callStat2.executeQuery();
                while (mensajero2.next()) {

                    Fecha_Jornada = mensajero2.getString("Fecha_Jornada");
                    ID_JornadaVotacion = mensajero2.getString("ID_JornadaVotaciones");
                    Estado_JornadaVotacion = mensajero2.getString("Estado_JornadaVotacion");
                    Fecha_JornadaApertura = mensajero2.getString("Fecha_JornadaApertura");

                    JornadaVotacionVO ultimajornada = new JornadaVotacionVO();

                    ultimajornada.setFecha_Jornada(Fecha_Jornada);
                    ultimajornada.setID_JornadaVotacion(ID_JornadaVotacion);
                    ultimajornada.setEstado_JornadaVotacion(Estado_JornadaVotacion);
                    ultimajornada.setFecha_JornadaApertura(Fecha_JornadaApertura);

                }
                CallableStatement call = conexion.prepareCall("call insertardetalle (?,?,?,?);");

                call.setString(1, ID_Detallejornada);
                call.setString(2, ID_JornadaVotacion);
                call.setString(3, id_persona);
                call.setString(4, Estado_Voto);

                call.executeUpdate();
            }
            operaciones = true;
        } catch (SQLException e) {

            System.out.println("¡Error!: " + e.toString());

        }
        return operaciones;

    }

    public ArrayList<JornadaVotacionVO> consultarultimajornada() {
        ArrayList<JornadaVotacionVO> consultaultimajornada = new ArrayList<>();
        ConexionBD conexion2 = new ConexionBD();
        try {

            CallableStatement callStat = conexion2.obtenerConexion().prepareCall("call consultarultimajornada");
            mensajero = callStat.executeQuery();
            while (mensajero.next()) {

                Fecha_Jornada = mensajero.getString("Fecha_Jornada");
                ID_JornadaVotacion = mensajero.getString("ID_JornadaVotaciones");
                Estado_JornadaVotacion = mensajero.getString("Estado_JornadaVotacion");
                Fecha_JornadaApertura = mensajero.getString("Fecha_JornadaApertura");

                JornadaVotacionVO ultimoid = new JornadaVotacionVO();
                ultimoid.setFecha_Jornada(Fecha_Jornada);
                ultimoid.setID_JornadaVotacion(ID_JornadaVotacion);
                ultimoid.setEstado_JornadaVotacion(Estado_JornadaVotacion);
                ultimoid.setFecha_JornadaApertura(Fecha_JornadaApertura);

                consultaultimajornada.add(ultimoid);

            }
        } catch (SQLException e) {

            System.out.println("¡Error!: " + e.toString());

        }
        return consultaultimajornada;

    }

    public ArrayList<JornadaVotacionVO> Conteonovotosreportes(String fecha) {

        ConexionBD conexion2 = new ConexionBD();
        ArrayList<JornadaVotacionVO> listavotos = new ArrayList<>();

        try {

            CallableStatement callStat = conexion2.obtenerConexion().prepareCall("call conteonovotosreportedetalle(?)");

            callStat.setString(1, fecha);

            mensajero = callStat.executeQuery();

            while (mensajero.next()) {

                documento_persona = mensajero.getString("documento_persona");
                nombres_persona = mensajero.getString("Nombres_persona");
                primerapellido_persona = mensajero.getString("Apellidos");
                Estado_Voto = mensajero.getString("estado_voto");
                id_jornada = mensajero.getString("Jornada");
                Fecha_Jornada = mensajero.getString("Fecha_Jornada");
                
                JornadaVotacionVO jornadaVotacionVO = new JornadaVotacionVO();

                jornadaVotacionVO.setDocumento_persona(documento_persona);
                jornadaVotacionVO.setNombres_persona(nombres_persona);
                jornadaVotacionVO.setPrimerapellido_persona(primerapellido_persona);
                jornadaVotacionVO.setEstado_Voto(Estado_Voto);
                jornadaVotacionVO.setId_jornada(id_jornada);
                jornadaVotacionVO.setFecha_Jornada(Fecha_Jornada);

                listavotos.add(jornadaVotacionVO);

            }
        } catch (SQLException e) {

            System.out.println("¡Error!: " + e.toString());
        }
        return listavotos;
    }
}
