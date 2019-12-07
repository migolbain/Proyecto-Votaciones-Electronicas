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
import modeloVO.PerfilVO;
import modeloVO.UsuarioVO;
import util.ConexionBD;
import util.InterfaceCRUD;

/**
 *
 * @author APRENDIZ
 */
public class UsuarioDAO extends ConexionBD implements InterfaceCRUD {

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

    private byte[] archivoimg;

    private boolean operaciones = false;

    public UsuarioDAO(UsuarioVO usuVO) {

        super();
        try {

            conexion = this.obtenerConexion();
            puente = conexion.createStatement();

            usuId = usuVO.getUsuId();
            usuLogin = usuVO.getUsuLogin();
            usuPassword = usuVO.getUsuPassword();
            usuRol = usuVO.getUsuRol();
            nombres_persona = usuVO.getNombres_persona();
            primerapellido_persona = usuVO.getPrimerapellido_persona();
            segundoapellido_persona = usuVO.getSegundoapellido_persona();
            tipoid_persona = usuVO.getTipoid_persona();
            documento_persona = usuVO.getDocumento_persona();
            genero_persona = usuVO.getGenero_persona();
            correo_persona = usuVO.getCorreo_persona();
            estado_formacion = usuVO.getEstado_formacion();
            estado_voto = usuVO.getEstado_voto();
            estado_candidato = usuVO.getEstado_candidato();
            id_jornada = usuVO.getId_jornada();
            id_usuario = usuVO.getId_usuario();
            id_persona = usuVO.getId_persona();
            jornada = usuVO.getJornada();
            rol = usuVO.getRol();
            cargo = usuVO.getCargo();

            archivoimg = usuVO.getArchivoimg2();

        } catch (Exception e) {
            System.out.println("¡Error!: " + e.toString());
        }

    }

    @Override
    public boolean agregarRegistro() {
        try {
            CallableStatement call = conexion.prepareCall("call pa_insertarpersonas2 (?,?,?,?,?,?,?,?,?,?,?,?,?,?);");
            CallableStatement call2 = conexion.prepareCall("call pa_insertarusuario2 (?,?,?,?);");

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

    @Override
    public boolean actualizarRegistro() {
        try {
            CallableStatement call = conexion.prepareCall("call pa_actualizarpersonas2 (?,?,?,?,?,?,?,?,?,?,?,?,?);");
            CallableStatement call2 = conexion.prepareCall("call pa_actualizarusuarios2 (?,?,?);");
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
            call2.setString(3, usuRol);

            call2.executeUpdate();
            operaciones = true;
            this.cerrarConexion();
        } catch (Exception e) {
            System.out.println("¡Error!: " + e.toString());
        }
        return operaciones;
    }

    public boolean validarLogin(String usuario, String password) {
        ConexionBD conBD = new ConexionBD();
        try {
            CallableStatement callStat = conBD.obtenerConexion().prepareCall("call validarlogin(?,md5(?))");
            callStat.setString(1, usuario);
            callStat.setString(2, password);                                                                                    //
                                                                                                                                // NO INGRESA USUARIOS QUE NO ESTEN ENCRIPTADOS
            mensajero = callStat.executeQuery();                                                                                // 
            if (mensajero.next()) {
                operaciones = true;
            }
            this.cerrarConexion();

        } catch (Exception e) {
            System.out.println("¡Error!: " + e.toString());
        }
        return operaciones;
    }

    public ArrayList<UsuarioVO> IniciarSesion(String usuario, String clave) {
        ConexionBD conBD = new ConexionBD();
        ArrayList<UsuarioVO> lista = new ArrayList<>();
        try {
            CallableStatement callStat = conBD.obtenerConexion().prepareCall("call sp_login(?,md5(?))");
            callStat.setString(1, usuario);
            callStat.setString(2, clave);

            mensajero = callStat.executeQuery();

            while (mensajero.next()) {
                                                                                                                                    //
                                                                                                                                    // NO INGRESA USUARIOS QUE NO ESTEN ENCRIPTADOS
                                                                                          // 
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

                UsuarioVO usuVO = new UsuarioVO(usuId, usuLogin, usuPassword, usuRol, id_persona, tipoid_persona, documento_persona, nombres_persona, primerapellido_persona, segundoapellido_persona, genero_persona, correo_persona, estado_formacion, estado_voto, estado_candidato, id_usuario, id_jornada, jornada, rol, cargo, archivoimg);
                lista.add(usuVO);
                this.cerrarConexion();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());

        }
        return lista;
    }

    public ArrayList<UsuarioVO> listarPerfil(int id_persona) {

        ConexionBD conexion2 = new ConexionBD();
        ArrayList<UsuarioVO> listaDatosUsu = new ArrayList<>();

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

                UsuarioVO UsuarioVO2 = new UsuarioVO();

                listaDatosUsu.add(UsuarioVO2);

            }
        } catch (SQLException e) {

            System.out.println("¡Error!: " + e.toString());
        }
        return listaDatosUsu;
    }

    public ArrayList<UsuarioVO> listarestado(int id_persona) {

        ConexionBD conexion2 = new ConexionBD();
        ArrayList<UsuarioVO> listaMenu = new ArrayList<>();

        try {

            CallableStatement callStat = conexion2.obtenerConexion().prepareCall("call consultarmenu(?)");

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

                UsuarioVO UsuarioVO2 = new UsuarioVO();

                listaMenu.add(UsuarioVO2);

            }
        } catch (SQLException e) {

            System.out.println("¡Error!: " + e.toString());
        }
        return listaMenu;
    }

    public UsuarioDAO() {

    }

}
