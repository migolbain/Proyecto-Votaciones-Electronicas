/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloDAO;

import java.nio.file.Paths;
import java.sql.CallableStatement;
import modeloVO.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modeloVO.PerfilVO;
import util.ConexionBD;
import util.InterfaceCRUD;

/**
 *
 * @author MigolBain
 */
public class PerfilDAO extends ConexionBD implements InterfaceCRUD {

    private Connection conexion = null;
    private Statement puente = null;
    private ResultSet mensajero = null;

    private String usuId = "";
    private String usuLogin = "";
    private String usuPassword = "";
    private String usuRol = "";

    private String id_persona = "";
    private String tipoid_persona = "";
    private String documento_persona = "";
    private String nombres_persona = "";
    private String primerapellido_persona = "";
    private String segundoapellido_persona = "";
    private String genero_persona = "";
    private String correo_persona = "";
    private String estado_formacion = "";
    private String estado_voto = "";
    private String estado_candidato = "";
    private String id_usuario = "";
    private String id_jornada = "";

    private String jornada = "";
    private String rol = "";
    private String cargo = "";

    private boolean operaciones = false;

    public PerfilDAO(PerfilVO perfilVO) {

        super();
        try {

            conexion = this.obtenerConexion();
            puente = conexion.createStatement();

            usuId = perfilVO.getUsuId();
            usuLogin = perfilVO.getUsuLogin();
            usuPassword = perfilVO.getUsuPassword();
            usuRol = perfilVO.getUsuRol();

            nombres_persona = perfilVO.getNombres_persona();
            primerapellido_persona = perfilVO.getPrimerapellido_persona();
            segundoapellido_persona = perfilVO.getSegundoapellido_persona();
            tipoid_persona = perfilVO.getTipoid_persona();
            documento_persona = perfilVO.getDocumento_persona();
            genero_persona = perfilVO.getGenero_persona();
            correo_persona = perfilVO.getCorreo_persona();
            estado_formacion = perfilVO.getEstado_formacion();
            estado_voto = perfilVO.getEstado_voto();
            estado_candidato = perfilVO.getEstado_candidato();
            id_jornada = perfilVO.getId_jornada();
            id_usuario = perfilVO.getId_usuario();
            id_persona = perfilVO.getId_persona();

            jornada = perfilVO.getJornada();
            rol = perfilVO.getRol();
            cargo = perfilVO.getCargo();

        } catch (Exception e) {
            System.out.println("¡Error!: " + e.toString());
        }

    }

    public boolean actualizarRegistro() {
        try {
            CallableStatement call = conexion.prepareCall("call pa_actualizarpersonas (?,?,?,?,?,?,?,?,?,?,?,?,?);");
            CallableStatement call2 = conexion.prepareCall("call pa_actualizarusuarios (?,?,?,?);");
            call.setString(1, id_persona);
            call.setString(2, tipoid_persona);
            call.setString(3, documento_persona);
            call.setString(4, nombres_persona);
            call.setString(5, primerapellido_persona);
            call.setString(6, segundoapellido_persona);
            call.setString(7, genero_persona);
            call.setString(8, correo_persona);
            call.setString(9, estado_formacion);
            call.setString(10, estado_voto);
            call.setString(11, estado_candidato);
            call.setString(12, id_usuario);
            call.setString(13, id_jornada);
            call.executeUpdate();

            call2.setString(1, id_usuario);
            call2.setString(2, usuLogin);
            call2.setString(3, usuPassword);
            call2.setString(4, usuRol);

            call2.executeUpdate();
        } catch (Exception e) {
            System.out.println("¡Error!: " + e.toString());
        }
        return operaciones;
    }

    @Override
    public boolean agregarRegistro() {
        try {
            CallableStatement call = conexion.prepareCall("call pa_insertarpersonas (?,?,?,?,?,?,?,?,?,?,?,?,?,?);");
            CallableStatement call2 = conexion.prepareCall("call pa_insertarusuarios (?,?,?,?);");

            call2.setString(1, id_usuario);
            call2.setString(2, usuLogin);
            call2.setString(3, usuPassword);
            call2.setString(4, usuRol);

            call.setString(1, id_persona);
            call.setString(2, tipoid_persona);
            call.setString(3, documento_persona);
            call.setString(4, nombres_persona);
            call.setString(5, primerapellido_persona);
            call.setString(6, segundoapellido_persona);
            call.setString(7, genero_persona);
            call.setString(8, correo_persona);
            call.setString(9, estado_formacion);
            call.setString(10, estado_voto);
            call.setString(11, estado_candidato);
            call.setString(12, null);
            call.setString(13, id_usuario);
            call.setString(14, id_jornada);
            call2.executeUpdate();
            call.executeUpdate();
            operaciones = true;
            this.cerrarConexion();
        } catch (Exception e) {
            System.out.println("¡Error!: " + e.toString());
        }
        return operaciones;
    }

    public ArrayList<PerfilVO> listarUsuarios() {
        ArrayList<PerfilVO> listaUsuarios = new ArrayList<>();
        ConexionBD conexion2 = new ConexionBD();
        try {

            CallableStatement callStat = conexion2.obtenerConexion().prepareCall("call listapersonas");
            mensajero = callStat.executeQuery();
            while (mensajero.next()) {

                usuRol = mensajero.getString("ID_Rolusu");
                usuId = mensajero.getString("id_usuario");
                usuLogin = mensajero.getString("usuario");
                usuPassword = mensajero.getString("clave");

                id_persona = mensajero.getString("id_persona");
                tipoid_persona = mensajero.getString("TipoIdentificacion_persona");
                documento_persona = mensajero.getString("documento_persona");
                nombres_persona = mensajero.getString("Nombres_persona");
                primerapellido_persona = mensajero.getString("PrimerApellido_Persona");
                segundoapellido_persona = mensajero.getString("SegundoApellido_Persona");
                genero_persona = mensajero.getString("Genero_persona");
                correo_persona = mensajero.getString("Correo_persona");
                estado_formacion = mensajero.getString("Estado_Formacion");
                estado_voto = mensajero.getString("Estado_voto");
                estado_candidato = mensajero.getString("Estado_candidato");
                id_usuario = mensajero.getString("ID_Usuario");
                id_jornada = mensajero.getString("ID_Jornada");
                jornada = mensajero.getString("Jornada");
                rol = mensajero.getString("Rol");
                cargo = mensajero.getString("rolusu");

                PerfilVO PerfilVO2 = new PerfilVO();
                PerfilVO2.setUsuRol(usuRol);
                PerfilVO2.setUsuId(usuId);
                PerfilVO2.setUsuLogin(usuLogin);
                PerfilVO2.setUsuPassword(usuPassword);

                PerfilVO2.setId_persona(id_persona);
                PerfilVO2.setTipoid_persona(tipoid_persona);
                PerfilVO2.setDocumento_persona(documento_persona);
                PerfilVO2.setNombres_persona(nombres_persona);
                PerfilVO2.setPrimerapellido_persona(primerapellido_persona);
                PerfilVO2.setSegundoapellido_persona(segundoapellido_persona);
                PerfilVO2.setGenero_persona(genero_persona);
                PerfilVO2.setCorreo_persona(correo_persona);
                PerfilVO2.setEstado_formacion(estado_formacion);
                PerfilVO2.setEstado_voto(estado_voto);
                PerfilVO2.setEstado_candidato(estado_candidato);
                PerfilVO2.setId_usuario(id_usuario);
                PerfilVO2.setId_jornada(id_jornada);
                PerfilVO2.setJornada(jornada);
                PerfilVO2.setRol(rol);
                PerfilVO2.setCargo(cargo);

                listaUsuarios.add(PerfilVO2);
            }
        } catch (SQLException e) {

            System.out.println("¡Error!: " + e.toString());
        }
        return listaUsuarios;

    }

    public ArrayList<PerfilVO> listarDatosUsuario(int id_persona) {

        ConexionBD conexion2 = new ConexionBD();
        ArrayList<PerfilVO> listaDatosUsu = new ArrayList<>();

        try {

            CallableStatement callStat = conexion2.obtenerConexion().prepareCall("call listapersonasactualizar(?)");

            callStat.setInt(1, id_persona);

            mensajero = callStat.executeQuery();

            while (mensajero.next()) {

                usuRol = mensajero.getString("ID_Rolusu");
                usuId = mensajero.getString("id_usuario");
                usuLogin = mensajero.getString("usuario");
                usuPassword = mensajero.getString("clave");
                tipoid_persona = mensajero.getString("TipoIdentificacion_persona");
                documento_persona = mensajero.getString("documento_persona");
                nombres_persona = mensajero.getString("Nombres_persona");
                primerapellido_persona = mensajero.getString("PrimerApellido_Persona");
                segundoapellido_persona = mensajero.getString("SegundoApellido_Persona");
                genero_persona = mensajero.getString("Genero_persona");
                correo_persona = mensajero.getString("Correo_persona");
                estado_formacion = mensajero.getString("Estado_Formacion");
                estado_voto = mensajero.getString("Estado_voto");
                estado_candidato = mensajero.getString("Estado_candidato");
                id_usuario = mensajero.getString("ID_Usuario");
                id_jornada = mensajero.getString("ID_Jornada");

                jornada = mensajero.getString("Jornada");
                rol = mensajero.getString("Rol");
                cargo = mensajero.getString("rolusu");
                
                PerfilVO PerfilVO2 = new PerfilVO();

                PerfilVO2.setUsuRol(usuRol);
                PerfilVO2.setUsuId(usuId);
                PerfilVO2.setUsuLogin(usuLogin);
                PerfilVO2.setUsuPassword(usuPassword);

                PerfilVO2.setTipoid_persona(tipoid_persona);
                PerfilVO2.setDocumento_persona(documento_persona);
                PerfilVO2.setNombres_persona(nombres_persona);
                PerfilVO2.setPrimerapellido_persona(primerapellido_persona);
                PerfilVO2.setSegundoapellido_persona(segundoapellido_persona);
                PerfilVO2.setGenero_persona(genero_persona);
                PerfilVO2.setCorreo_persona(correo_persona);
                PerfilVO2.setEstado_formacion(estado_formacion);
                PerfilVO2.setEstado_voto(estado_voto);
                PerfilVO2.setEstado_candidato(estado_candidato);
                PerfilVO2.setId_usuario(id_usuario);
                PerfilVO2.setId_jornada(id_jornada);
                PerfilVO2.setJornada(jornada);
                PerfilVO2.setRol(rol);
                PerfilVO2.setCargo(cargo);

                listaDatosUsu.add(PerfilVO2);

            }
        } catch (SQLException e) {

            System.out.println("¡Error!: " + e.toString());
        }
        return listaDatosUsu;
    }

    public ArrayList<PerfilVO> consultarultimaid() {
        ArrayList<PerfilVO> consultaultimaID = new ArrayList<>();
        ConexionBD conexion2 = new ConexionBD();
        try {

            CallableStatement callStat = conexion2.obtenerConexion().prepareCall("call pa_consultarultimaid");
            mensajero = callStat.executeQuery();
            while (mensajero.next()) {

                id_persona = mensajero.getString("id_persona");
                id_usuario = mensajero.getString("ID_Usuario");

                PerfilVO ultimoid = new PerfilVO();
                ultimoid.setId_persona(id_persona);
                ultimoid.setId_usuario(id_usuario);

                consultaultimaID.add(ultimoid);

            }
        } catch (SQLException e) {

            System.out.println("¡Error!: " + e.toString());

        }
        return consultaultimaID;

    }

    public PerfilDAO() {

    }
}
