/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloDAO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Base64;
import javax.servlet.http.HttpServletResponse;
import modeloVO.CandidatoVO;
import util.ConexionBD;
import util.InterfaceCRUD;

/**
 *
 * @author migol
 */
public class CandidatoDAO extends ConexionBD implements InterfaceCRUD {

    private Connection conexion = null;
    private Statement puente = null;
    private ResultSet mensajero = null;

    private String usuId = "";
    private String usuLogin = "";
    private String usuPassword = "";
    private String usuRol = "";

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

    private String id_propuesta = "";
    private String descripcion_propuesta = "";
    private String videourl = "";
    private String no_propuesta = "";

    private String jornada = "";
    private String rol = "";
    private String cargo = "";

    private InputStream foto;
    private Blob foto1;

    private String base64image = "";

    private boolean operaciones = false;

    public CandidatoDAO(CandidatoVO candidatoVO) {
        super();
        try {
            conexion = this.obtenerConexion();
            puente = conexion.createStatement();

            id_candidato = candidatoVO.getId_candidato();
            tipoid_candidato = candidatoVO.getTipoid_candidato();
            documento_candidato = candidatoVO.getDocumento_candidato();
            nombres_candidato = candidatoVO.getNombres_candidato();
            primerapellido_candidato = candidatoVO.getPrimerapellido_candidato();
            segundoapellido_candidato = candidatoVO.getSegundoapellido_candidato();
            genero_candidato = candidatoVO.getGenero_candidato();
            correo_candidato = candidatoVO.getCorreo_candidato();
            estado_formacion = candidatoVO.getEstado_formacion();
            estado_candidato = candidatoVO.getEstado_candidato();
            estado_voto = candidatoVO.getEstado_voto();

            id_usuario = candidatoVO.getId_usuario();
            id_jornada = candidatoVO.getId_jornada();

            jornada = candidatoVO.getJornada();
            rol = candidatoVO.getRol();
            cargo = candidatoVO.getCargo();

            no_propuesta = candidatoVO.getNo_propuesta();
            id_propuesta = candidatoVO.getId_propuesta();
            videourl = candidatoVO.getVideourl();
            descripcion_propuesta = candidatoVO.getDescripcion_propuesta();

            foto = candidatoVO.getFoto();

        } catch (Exception e) {
            System.out.println("¡Error!: " + e.toString());
        }
    }

    @Override
    public boolean actualizarRegistro() {
        try {
            CallableStatement call = conexion.prepareCall("call pa_actualizarcandidatos (?,?,?,?,?,?,?,?,?,?);");

            call.setString(1, id_candidato);
            call.setString(2, tipoid_candidato);
            call.setString(3, documento_candidato);
            call.setString(4, nombres_candidato);
            call.setString(5, primerapellido_candidato);
            call.setString(6, segundoapellido_candidato);
            call.setString(7, genero_candidato);
            call.setString(8, correo_candidato);
            call.setString(9, estado_candidato);
            call.setString(10, id_jornada);
            call.executeUpdate();

            operaciones = true;
            this.cerrarConexion();
        } catch (Exception e) {
            System.out.println("¡Error!: " + e.toString());
        }
        return operaciones;
    }

    @Override
    public boolean agregarRegistro() {
        try {
            CallableStatement call = conexion.prepareCall("call pa_insertarcandidatos (?,?,?,?,?,?,?,?,?,?);");

            call.setString(1, id_candidato);
            call.setString(2, nombres_candidato);
            call.setString(3, primerapellido_candidato);
            call.setString(4, segundoapellido_candidato);
            call.setString(5, tipoid_candidato);
            call.setString(6, documento_candidato);
            call.setString(7, genero_candidato);
            call.setString(8, estado_candidato);
            call.setString(9, correo_candidato);
            call.setString(10, id_jornada);
            call.executeUpdate();

            operaciones = true;
            this.cerrarConexion();
        } catch (Exception e) {
            System.out.println("¡Error!: " + e.toString());
        }
        return operaciones;
    }

    public boolean actualizarimagen() {
        try {
            CallableStatement call = conexion.prepareCall("call actualizarimagen (?,?);");

            call.setBlob(1, foto);
            call.setString(2, id_candidato);
            call.executeUpdate();

            operaciones = true;
            this.cerrarConexion();
        } catch (Exception e) {
            System.out.println("¡Error!: " + e.toString());
        }
        return operaciones;
    }

    public ArrayList<CandidatoVO> listarCandidatos() {
        ArrayList<CandidatoVO> listaCandidatos = new ArrayList<>();
        ConexionBD conexion2 = new ConexionBD();
        try {

            CallableStatement callStat = conexion2.obtenerConexion().prepareCall("call listacandidatos");
            mensajero = callStat.executeQuery();
            while (mensajero.next()) {

                usuRol = mensajero.getString("ID_Rolusu");
                usuId = mensajero.getString("id_usuario");

                id_candidato = mensajero.getString("id_persona");
                tipoid_candidato = mensajero.getString("TipoIdentificacion_persona");
                documento_candidato = mensajero.getString("documento_persona");
                nombres_candidato = mensajero.getString("Nombres_persona");
                primerapellido_candidato = mensajero.getString("PrimerApellido_Persona");
                segundoapellido_candidato = mensajero.getString("SegundoApellido_Persona");
                genero_candidato = mensajero.getString("Genero_persona");
                correo_candidato = mensajero.getString("Correo_persona");
                estado_formacion = mensajero.getString("Estado_Formacion");
                estado_voto = mensajero.getString("Estado_voto");
                estado_candidato = mensajero.getString("Estado_candidato");
                id_usuario = mensajero.getString("ID_Usuario");
                id_jornada = mensajero.getString("ID_Jornada");
                jornada = mensajero.getString("Jornada");
                rol = mensajero.getString("Rol");
                cargo = mensajero.getString("rolusu");

                CandidatoVO CandidatoVO2 = new CandidatoVO();
                CandidatoVO2.setUsuRol(usuRol);
                CandidatoVO2.setUsuId(usuId);

                CandidatoVO2.setId_candidato(id_candidato);
                CandidatoVO2.setTipoid_candidato(tipoid_candidato);
                CandidatoVO2.setDocumento_candidato(documento_candidato);
                CandidatoVO2.setNombres_candidato(nombres_candidato);
                CandidatoVO2.setPrimerapellido_candidato(primerapellido_candidato);
                CandidatoVO2.setSegundoapellido_candidato(segundoapellido_candidato);
                CandidatoVO2.setGenero_candidato(genero_candidato);
                CandidatoVO2.setCorreo_candidato(correo_candidato);
                CandidatoVO2.setEstado_formacion(estado_formacion);
                CandidatoVO2.setEstado_voto(estado_voto);
                CandidatoVO2.setEstado_candidato(estado_candidato);
                CandidatoVO2.setId_usuario(id_usuario);
                CandidatoVO2.setId_jornada(id_jornada);
                CandidatoVO2.setJornada(jornada);
                CandidatoVO2.setRol(rol);
                CandidatoVO2.setCargo(cargo);

                CandidatoVO2.setJornada(jornada);

                listaCandidatos.add(CandidatoVO2);
            }
        } catch (SQLException e) {

            System.out.println("¡Error!: " + e.toString());
        }
        return listaCandidatos;
    }

    public ArrayList<CandidatoVO> listarCandidatosActualizar(int id_candidato) {

        ConexionBD conexion2 = new ConexionBD();
        ArrayList<CandidatoVO> listaDatosCandidato = new ArrayList<>();

        try {

            CallableStatement callStat = conexion2.obtenerConexion().prepareCall("call listacandidatosactualizar(?)");

            callStat.setInt(1, id_candidato);

            mensajero = callStat.executeQuery();

            while (mensajero.next()) {

                usuRol = mensajero.getString("ID_Rolusu");
                usuId = mensajero.getString("id_usuario");

                tipoid_candidato = mensajero.getString("TipoIdentificacion_persona");
                documento_candidato = mensajero.getString("documento_persona");
                nombres_candidato = mensajero.getString("Nombres_persona");
                primerapellido_candidato = mensajero.getString("PrimerApellido_Persona");
                segundoapellido_candidato = mensajero.getString("SegundoApellido_Persona");
                genero_candidato = mensajero.getString("Genero_persona");
                correo_candidato = mensajero.getString("Correo_persona");
                estado_formacion = mensajero.getString("Estado_Formacion");
                estado_voto = mensajero.getString("Estado_voto");
                estado_candidato = mensajero.getString("Estado_candidato");
                id_usuario = mensajero.getString("ID_Usuario");
                id_jornada = mensajero.getString("ID_Jornada");
                jornada = mensajero.getString("Jornada");
                rol = mensajero.getString("Rol");
                cargo = mensajero.getString("rolusu");

                CandidatoVO CandidatoVO2 = new CandidatoVO();
                CandidatoVO2.setUsuRol(usuRol);
                CandidatoVO2.setUsuId(usuId);

                CandidatoVO2.setTipoid_candidato(tipoid_candidato);
                CandidatoVO2.setDocumento_candidato(documento_candidato);
                CandidatoVO2.setNombres_candidato(nombres_candidato);
                CandidatoVO2.setPrimerapellido_candidato(primerapellido_candidato);
                CandidatoVO2.setSegundoapellido_candidato(segundoapellido_candidato);
                CandidatoVO2.setGenero_candidato(genero_candidato);
                CandidatoVO2.setCorreo_candidato(correo_candidato);
                CandidatoVO2.setEstado_formacion(estado_formacion);
                CandidatoVO2.setEstado_voto(estado_voto);
                CandidatoVO2.setEstado_candidato(estado_candidato);
                CandidatoVO2.setId_usuario(id_usuario);
                CandidatoVO2.setId_jornada(id_jornada);
                CandidatoVO2.setJornada(jornada);
                CandidatoVO2.setRol(rol);
                CandidatoVO2.setCargo(cargo);

                CandidatoVO2.setJornada(jornada);

                listaDatosCandidato.add(CandidatoVO2);

            }
        } catch (SQLException e) {

            System.out.println("¡Error!: " + e.toString());
        }
        return listaDatosCandidato;
    }

    public ArrayList<CandidatoVO> listarPropuestas(int id_candidato) {

        ConexionBD conexion2 = new ConexionBD();
        ArrayList<CandidatoVO> listaPropuestas = new ArrayList<>();

        try {

            CallableStatement callStat = conexion2.obtenerConexion().prepareCall("call listacandidatospropuestas(?)");

            callStat.setInt(1, id_candidato);

            mensajero = callStat.executeQuery();

            while (mensajero.next()) {

                nombres_candidato = mensajero.getString("Nombres_persona");
                primerapellido_candidato = mensajero.getString("PrimerApellido_persona");
                no_propuesta = mensajero.getString("No_propuesta");
                descripcion_propuesta = mensajero.getString("Descripcion_Propuesta");

                CandidatoVO CandidatoVO2 = new CandidatoVO();

                CandidatoVO2.setNombres_candidato(nombres_candidato);
                CandidatoVO2.setPrimerapellido_candidato(primerapellido_candidato);
                CandidatoVO2.setNo_propuesta(no_propuesta);
                CandidatoVO2.setDescripcion_propuesta(descripcion_propuesta);

                listaPropuestas.add(CandidatoVO2);

            }
        } catch (SQLException e) {

            System.out.println("¡Error!: " + e.toString());
        }
        return listaPropuestas;
    }

    public ArrayList<CandidatoVO> listarCandidatosElectos() {
        ArrayList<CandidatoVO> listaCandidatoselectos = new ArrayList<>();
        ConexionBD conexion2 = new ConexionBD();

        try {

            CallableStatement callStat = conexion2.obtenerConexion().prepareCall("call listacandidatoselectos");
            mensajero = callStat.executeQuery();
            while (mensajero.next()) {

                usuRol = mensajero.getString("ID_Rolusu");
                usuId = mensajero.getString("id_usuario");

                id_candidato = mensajero.getString("id_persona");
                tipoid_candidato = mensajero.getString("TipoIdentificacion_persona");
                documento_candidato = mensajero.getString("documento_persona");
                nombres_candidato = mensajero.getString("Nombres_persona");
                primerapellido_candidato = mensajero.getString("PrimerApellido_Persona");
                segundoapellido_candidato = mensajero.getString("SegundoApellido_Persona");
                genero_candidato = mensajero.getString("Genero_persona");
                correo_candidato = mensajero.getString("Correo_persona");
                estado_formacion = mensajero.getString("Estado_Formacion");
                estado_voto = mensajero.getString("Estado_voto");
                estado_candidato = mensajero.getString("Estado_candidato");
                id_usuario = mensajero.getString("ID_Usuario");
                id_jornada = mensajero.getString("ID_Jornada");
                jornada = mensajero.getString("Jornada");
                rol = mensajero.getString("Rol");
                cargo = mensajero.getString("rolusu");

                foto = mensajero.getBinaryStream("Foto");

                CandidatoVO CandidatoVO2 = new CandidatoVO();

                CandidatoVO2.setUsuRol(usuRol);
                CandidatoVO2.setUsuId(usuId);

                CandidatoVO2.setId_candidato(id_candidato);
                CandidatoVO2.setTipoid_candidato(tipoid_candidato);
                CandidatoVO2.setDocumento_candidato(documento_candidato);
                CandidatoVO2.setNombres_candidato(nombres_candidato);
                CandidatoVO2.setPrimerapellido_candidato(primerapellido_candidato);
                CandidatoVO2.setSegundoapellido_candidato(segundoapellido_candidato);
                CandidatoVO2.setGenero_candidato(genero_candidato);
                CandidatoVO2.setCorreo_candidato(correo_candidato);
                CandidatoVO2.setEstado_formacion(estado_formacion);
                CandidatoVO2.setEstado_voto(estado_voto);
                CandidatoVO2.setEstado_candidato(estado_candidato);
                CandidatoVO2.setId_usuario(id_usuario);
                CandidatoVO2.setId_jornada(id_jornada);
                CandidatoVO2.setJornada(jornada);
                CandidatoVO2.setRol(rol);
                CandidatoVO2.setCargo(cargo);

                CandidatoVO2.setJornada(jornada);

                CandidatoVO2.setFoto(foto);

                listaCandidatoselectos.add(CandidatoVO2);
            }
        } catch (SQLException e) {

            System.out.println("¡Error!: " + e.toString());
        }
        return listaCandidatoselectos;
    }

    public ArrayList<CandidatoVO> listarCandidatosElectosPropuestas(int id_candidato) {

        ConexionBD conexion2 = new ConexionBD();
        ArrayList<CandidatoVO> listaCandidatosElectosPropuestas = new ArrayList<>();

        try {

            CallableStatement callStat = conexion2.obtenerConexion().prepareCall("call listacandidatoselectospropuestas(?)");

            callStat.setInt(1, id_candidato);

            mensajero = callStat.executeQuery();

            while (mensajero.next()) {

                no_propuesta = mensajero.getString("No_propuesta");
                descripcion_propuesta = mensajero.getString("Descripcion_Propuesta");
                videourl = mensajero.getString("VideoURL_Propuesta");
                id_propuesta = mensajero.getString("ID_Propuesta");

                CandidatoVO CandidatoVO2 = new CandidatoVO();

                CandidatoVO2.setNo_propuesta(no_propuesta);
                CandidatoVO2.setDescripcion_propuesta(descripcion_propuesta);
                CandidatoVO2.setVideourl(videourl);
                CandidatoVO2.setId_propuesta(id_propuesta);

                listaCandidatosElectosPropuestas.add(CandidatoVO2);

            }
        } catch (SQLException e) {

            System.out.println("¡Error!: " + e.toString());
        }
        return listaCandidatosElectosPropuestas;
    }

    public ArrayList<CandidatoVO> listarcandidatoelectovideo(int id_candidato) {

        ConexionBD conexion2 = new ConexionBD();
        ArrayList<CandidatoVO> listaCandidatosElectosPropuestas = new ArrayList<>();

        try {

            CallableStatement callStat = conexion2.obtenerConexion().prepareCall("call listacandidatoselectosvideo(?)");

            callStat.setInt(1, id_candidato);

            mensajero = callStat.executeQuery();

            while (mensajero.next()) {

                videourl = mensajero.getString("videourl_propuesta");

                CandidatoVO CandidatoVO2 = new CandidatoVO();

                CandidatoVO2.setVideourl(videourl);

                listaCandidatosElectosPropuestas.add(CandidatoVO2);

            }
        } catch (SQLException e) {

            System.out.println("¡Error!: " + e.toString());
        }
        return listaCandidatosElectosPropuestas;
    }

    public void listarImagen(String id_candidato, HttpServletResponse response) {

        ConexionBD conexion2 = new ConexionBD();
        InputStream inputStream = null;
        OutputStream outputStream = null;
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        response.setContentType("image/*");
        try {

            CallableStatement callStat = conexion2.obtenerConexion().prepareCall("call consultarimagen(?)");
            callStat.setString(1, id_candidato);

            outputStream = response.getOutputStream();
            mensajero = callStat.executeQuery();

            if (mensajero.next()) {
                inputStream = mensajero.getBinaryStream("Foto");
            }
            bufferedInputStream = new BufferedInputStream(inputStream);
            bufferedOutputStream = new BufferedOutputStream(outputStream);
            int i = 0;
            while ((i = bufferedInputStream.read()) != -1) {
                bufferedOutputStream.write(i);
            }
        } catch (Exception e) {

            System.out.println("¡Error!: " + e.toString());
        }

    }

    public CandidatoDAO() {

    }
}
