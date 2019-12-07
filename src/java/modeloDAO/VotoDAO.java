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
import modeloVO.CandidatoVO;
import modeloVO.JornadaVotacionVO;
import modeloVO.PerfilVO;
import modeloVO.UsuarioVO;
import modeloVO.VotoVO;
import util.ConexionBD;
import util.InterfaceCRUD;

/**
 *
 * @author migol
 */
public class VotoDAO extends ConexionBD implements InterfaceCRUD {

    private Connection conexion = null;
    private Statement puente = null;
    private ResultSet mensajero = null;

    private String id_voto = "";
    private String no_voto = "";
    private String fecha_voto = "";
    private String id_persona = "";

    private String id_candidato = "";
    private String tipoid_candidato = "";
    private String documento_candidato = "";
    private String nombres_candidato = "";
    private String primerapellido_candidato = "";
    private String segundoapellido_candidato = "";
    private String genero_candidato = "";
    private String correo_candidato = "";
    private String estado_formacion = "";
    private String estado_voto = "";
    private String estado_candidato = "";
    private String id_usuario = "";
    private String id_jornada = "";

    private String no_propuesta = "";
    private String propuesta = "";
    private String jornada = "";
    private String rol = "";
    private String cargo = "";

    private String id_personavoto = "";
    
    private String Fecha_Jornada = "";
    private String ID_JornadaVotaciones = "";
    private String Estado_JornadaVotacion = "";

    private boolean operaciones = false;

    public VotoDAO(VotoVO votoVO) {
        super();
        try {
            conexion = this.obtenerConexion();
            puente = conexion.createStatement();

            id_voto = votoVO.getId_voto();
            no_voto = votoVO.getNo_voto();
            fecha_voto = votoVO.getFecha_voto();
            id_persona = votoVO.getId_persona();

            id_candidato = votoVO.getId_candidato();
            tipoid_candidato = votoVO.getTipoid_candidato();
            documento_candidato = votoVO.getDocumento_candidato();
            nombres_candidato = votoVO.getNombres_candidato();
            primerapellido_candidato = votoVO.getPrimerapellido_candidato();
            segundoapellido_candidato = votoVO.getSegundoapellido_candidato();
            genero_candidato = votoVO.getGenero_candidato();
            correo_candidato = votoVO.getCorreo_candidato();
            estado_formacion = votoVO.getEstado_formacion();
            estado_candidato = votoVO.getEstado_candidato();
            estado_voto = votoVO.getEstado_voto();

            id_usuario = votoVO.getId_usuario();
            id_jornada = votoVO.getId_jornada();

            jornada = votoVO.getJornada();
            rol = votoVO.getRol();
            cargo = votoVO.getCargo();

            id_personavoto = votoVO.getId_personavoto();
            
            Fecha_Jornada = votoVO.getFecha_Jornada();
            ID_JornadaVotaciones = votoVO.getID_JornadaVotaciones();
            Estado_JornadaVotacion = votoVO.getEstado_JornadaVotacion();
        } catch (Exception e) {
            System.out.println("¡Error!: " + e.toString());
        }
    }

    @Override
    public boolean agregarRegistro() {
        try {
            CallableStatement call = conexion.prepareCall("call pa_insertarvoto (?,?,?,?,?);");
            CallableStatement call2 = conexion.prepareCall("call pa_actualizarestadopersona (?,?);");
            call.setString(1, id_voto);
            call.setString(2, no_voto);
            call.setString(3, fecha_voto);
            call.setString(4, id_persona);
            call.setString(5, ID_JornadaVotaciones);

            call2.setString(1, estado_voto);
            call2.setString(2, id_personavoto);

            call.executeUpdate();
            call2.executeUpdate();
            operaciones = true;
            this.cerrarConexion();
        } catch (Exception e) {
            System.out.println("¡Error!: " + e.toString());

        }
        return operaciones;
    }

    @Override
    public boolean actualizarRegistro() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ArrayList<VotoVO> listarCandidatosvoto(int id_jornada) {

        ConexionBD conexion2 = new ConexionBD();
        ArrayList<VotoVO> listaCandidatosvoto = new ArrayList<>();

        try {

            CallableStatement callStat = conexion2.obtenerConexion().prepareCall("call listacandidatosvoto(?)");

            callStat.setInt(1, id_jornada);

            mensajero = callStat.executeQuery();

            while (mensajero.next()) {

                id_candidato = mensajero.getString("id_persona");
                nombres_candidato = mensajero.getString("Nombres_persona");
                primerapellido_candidato = mensajero.getString("PrimerApellido_Persona");
                segundoapellido_candidato = mensajero.getString("SegundoApellido_Persona");

                estado_candidato = mensajero.getString("Estado_candidato");

                jornada = mensajero.getString("Jornada");

                VotoVO VotoVO2 = new VotoVO();

                VotoVO2.setId_persona(id_candidato);
                VotoVO2.setNombres_candidato(nombres_candidato);
                VotoVO2.setPrimerapellido_candidato(primerapellido_candidato);
                VotoVO2.setSegundoapellido_candidato(segundoapellido_candidato);

                VotoVO2.setEstado_candidato(estado_candidato);

                VotoVO2.setJornada(jornada);

                listaCandidatosvoto.add(VotoVO2);

            }
        } catch (SQLException e) {

            System.out.println("¡Error!: " + e.toString());
        }
        return listaCandidatosvoto;
    }

    public ArrayList<VotoVO> consultarultimovoto() {
        ArrayList<VotoVO> consultaultimovoto = new ArrayList<>();
        ConexionBD conexion2 = new ConexionBD();
        try {

            CallableStatement callStat = conexion2.obtenerConexion().prepareCall("call pa_consultarultimovoto");
            mensajero = callStat.executeQuery();
            while (mensajero.next()) {

                id_voto = mensajero.getString("id_voto");
                no_voto = mensajero.getString("no_voto");

                VotoVO ultimoid = new VotoVO();
                ultimoid.setId_voto(id_voto);
                ultimoid.setNo_voto(no_voto);

                consultaultimovoto.add(ultimoid);

            }
        } catch (SQLException e) {

            System.out.println("¡Error!: " + e.toString());

        }
        return consultaultimovoto;

    }

    public ArrayList<VotoVO> Conteovotos(String fecha) {

        ConexionBD conexion2 = new ConexionBD();
        ArrayList<VotoVO> listaCandidatosvoto = new ArrayList<>();

        try {

            CallableStatement callStat = conexion2.obtenerConexion().prepareCall("call conteovotos(?)");

            callStat.setString(1, fecha);

            mensajero = callStat.executeQuery();

            while (mensajero.next()) {

                id_candidato = mensajero.getString("id_persona");
                nombres_candidato = mensajero.getString("Nombres_persona");
                primerapellido_candidato = mensajero.getString("PrimerApellido_Persona");

                no_voto = mensajero.getString("Votos");

                id_jornada = mensajero.getString("ID_Jornada");
                VotoVO VotoVO2 = new VotoVO();

                VotoVO2.setId_persona(id_candidato);
                VotoVO2.setNombres_candidato(nombres_candidato);
                VotoVO2.setPrimerapellido_candidato(primerapellido_candidato);

                VotoVO2.setNo_voto(no_voto);

                VotoVO2.setId_jornada(id_jornada);

                listaCandidatosvoto.add(VotoVO2);

            }
        } catch (SQLException e) {

            System.out.println("¡Error!: " + e.toString());
        }
        return listaCandidatosvoto;
    }

    public ArrayList<VotoVO> Conteovotosreportes(String fecha) {

        ConexionBD conexion2 = new ConexionBD();
        ArrayList<VotoVO> listavotos = new ArrayList<>();

        try {

            CallableStatement callStat = conexion2.obtenerConexion().prepareCall("call conteovotosreporte(?)");

            callStat.setString(1, fecha);

            mensajero = callStat.executeQuery();

            while (mensajero.next()) {

                id_candidato = mensajero.getString("id_persona");
                documento_candidato = mensajero.getString("documento_persona");
                nombres_candidato = mensajero.getString("Nombres_persona");
                primerapellido_candidato = mensajero.getString("Apellidos");

                no_voto = mensajero.getString("Votos");

                jornada = mensajero.getString("Jornada");
                VotoVO VotoVO2 = new VotoVO();

                VotoVO2.setId_persona(id_candidato);
                VotoVO2.setDocumento_candidato(documento_candidato);
                VotoVO2.setNombres_candidato(nombres_candidato);
                VotoVO2.setPrimerapellido_candidato(primerapellido_candidato);

                VotoVO2.setNo_voto(no_voto);

                VotoVO2.setJornada(jornada);

                listavotos.add(VotoVO2);

            }
        } catch (SQLException e) {

            System.out.println("¡Error!: " + e.toString());
        }
        return listavotos;
    }

    public ArrayList<VotoVO> Conteonovotosreportes(String jornada) {

        ConexionBD conexion2 = new ConexionBD();
        ArrayList<VotoVO> listavotos = new ArrayList<>();

        try {

            CallableStatement callStat = conexion2.obtenerConexion().prepareCall("call conteonovotosreporte(?)");

            callStat.setString(1, jornada);

            mensajero = callStat.executeQuery();

            while (mensajero.next()) {

                documento_candidato = mensajero.getString("documento_persona");
                nombres_candidato = mensajero.getString("Nombres_persona");
                primerapellido_candidato = mensajero.getString("Apellidos");

               

                id_jornada = mensajero.getString("Jornada");
                estado_voto = mensajero.getString("estado_voto");
                VotoVO VotoVO2 = new VotoVO();


                VotoVO2.setDocumento_candidato(documento_candidato);
                VotoVO2.setNombres_candidato(nombres_candidato);
                VotoVO2.setPrimerapellido_candidato(primerapellido_candidato);

                VotoVO2.setEstado_voto(estado_voto);

                VotoVO2.setId_jornada(id_jornada);

                listavotos.add(VotoVO2);

            }
        } catch (SQLException e) {

            System.out.println("¡Error!: " + e.toString());
        }
        return listavotos;
    }
    
     public ArrayList<VotoVO> consultarultimajornada() {
        ArrayList<VotoVO> consultaultimajornada = new ArrayList<>();
        ConexionBD conexion2 = new ConexionBD();
        try {

            CallableStatement callStat = conexion2.obtenerConexion().prepareCall("call consultarultimajornada");
            mensajero = callStat.executeQuery();
            while (mensajero.next()) {

                Fecha_Jornada = mensajero.getString("Fecha_Jornada");
                ID_JornadaVotaciones = mensajero.getString("ID_JornadaVotaciones");
                Estado_JornadaVotacion = mensajero.getString("Estado_JornadaVotacion");

                VotoVO ultimoid = new VotoVO();
                ultimoid.setFecha_Jornada(Fecha_Jornada);
                ultimoid.setID_JornadaVotaciones(ID_JornadaVotaciones);
                ultimoid.setEstado_JornadaVotacion(Estado_JornadaVotacion);

                consultaultimajornada.add(ultimoid);

            }
        } catch (SQLException e) {

            System.out.println("¡Error!: " + e.toString());

        }
        return consultaultimajornada;
    }
     
     public ArrayList<VotoVO> reportejornadaelectoral(String fecha) {

        ConexionBD conexion2 = new ConexionBD();
        ArrayList<VotoVO> listavotos = new ArrayList<>();

        try {

            CallableStatement callStat = conexion2.obtenerConexion().prepareCall("call conteovotosreporteelectoral(?)");

            callStat.setString(1, fecha);

            mensajero = callStat.executeQuery();

            while (mensajero.next()) {

                no_voto = mensajero.getString("Votos");
                documento_candidato = mensajero.getString("Documento_Persona");
                primerapellido_candidato = mensajero.getString("Apellidos");
                nombres_candidato = mensajero.getString("Nombres_Persona");
                id_jornada = mensajero.getString("Jornada");
                Fecha_Jornada = mensajero.getString("Fecha_Jornada");
                VotoVO VotoVO2 = new VotoVO();

                VotoVO2.setNo_voto(no_voto);
                VotoVO2.setDocumento_candidato(documento_candidato);
                VotoVO2.setNombres_candidato(nombres_candidato);
                VotoVO2.setPrimerapellido_candidato(primerapellido_candidato);       
                VotoVO2.setId_jornada(id_jornada);
                VotoVO2.setFecha_Jornada(Fecha_Jornada);

                listavotos.add(VotoVO2);

            }
        } catch (SQLException e) {

            System.out.println("¡Error!: " + e.toString());
        }
        return listavotos;
    }

    public VotoDAO() {

    }
}

