/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloVO;

import java.io.InputStream;
import java.sql.Blob;

/**
 *
 * @author migol
 */
public class CandidatoVO {

    String usuId, usuLogin, usuPassword, usuRol, id_candidato, tipoid_candidato, documento_candidato, nombres_candidato, primerapellido_candidato, segundoapellido_candidato, genero_candidato, correo_candidato, estado_formacion, estado_voto, estado_candidato, id_usuario, id_jornada, jornada, rol, cargo, no_propuesta, descripcion_propuesta, id_propuesta, videourl;
    InputStream foto;

    public CandidatoVO() {

    }

    public CandidatoVO(String usuId, String usuLogin, String usuPassword, String usuRol, String id_candidato, String tipoid_candidato, String documento_candidato, String nombres_candidato, String primerapellido_candidato, String segundoapellido_candidato, String genero_candidato, String correo_candidato, String estado_formacion, String estado_voto, String estado_candidato, String id_usuario, String id_jornada, String jornada, String rol, String cargo, String no_propuesta, String descripcion_propuesta, String id_propuesta, String videourl, InputStream foto) {
        this.usuId = usuId;
        this.usuLogin = usuLogin;
        this.usuPassword = usuPassword;
        this.usuRol = usuRol;

        this.id_candidato = id_candidato;
        this.tipoid_candidato = tipoid_candidato;
        this.documento_candidato = documento_candidato;
        this.nombres_candidato = nombres_candidato;
        this.primerapellido_candidato = primerapellido_candidato;
        this.segundoapellido_candidato = segundoapellido_candidato;
        this.genero_candidato = genero_candidato;
        this.correo_candidato = correo_candidato;
        this.estado_formacion = estado_formacion;
        this.estado_voto = estado_voto;
        this.estado_candidato = estado_candidato;
        this.id_usuario = id_usuario;
        this.id_jornada = id_jornada;

        this.jornada = jornada;
        this.rol = rol;
        this.cargo = cargo;

        this.id_propuesta = id_propuesta;
        this.descripcion_propuesta = descripcion_propuesta;
        this.videourl = videourl;
        this.no_propuesta = no_propuesta;
        
        this.foto = foto;
        
      
    }

    

   

    public InputStream getFoto() {
        return foto;
    }

    public void setFoto(InputStream foto) {
        this.foto = foto;
    }

    

    public String getNo_propuesta() {
        return no_propuesta;
    }

    public void setNo_propuesta(String no_propuesta) {
        this.no_propuesta = no_propuesta;
    }

    public String getDescripcion_propuesta() {
        return descripcion_propuesta;
    }

    public void setDescripcion_propuesta(String descripcion_propuesta) {
        this.descripcion_propuesta = descripcion_propuesta;
    }

    public String getId_propuesta() {
        return id_propuesta;
    }

    public void setId_propuesta(String id_propuesta) {
        this.id_propuesta = id_propuesta;
    }

    public String getVideourl() {
        return videourl;
    }

    public void setVideourl(String videourl) {
        this.videourl = videourl;
    }

    public String getUsuId() {
        return usuId;
    }

    public void setUsuId(String usuId) {
        this.usuId = usuId;
    }

    public String getUsuLogin() {
        return usuLogin;
    }

    public void setUsuLogin(String usuLogin) {
        this.usuLogin = usuLogin;
    }

    public String getUsuPassword() {
        return usuPassword;
    }

    public void setUsuPassword(String usuPassword) {
        this.usuPassword = usuPassword;
    }

    public String getUsuRol() {
        return usuRol;
    }

    public void setUsuRol(String usuRol) {
        this.usuRol = usuRol;
    }

    public String getId_candidato() {
        return id_candidato;
    }

    public void setId_candidato(String id_candidato) {
        this.id_candidato = id_candidato;
    }

    public String getTipoid_candidato() {
        return tipoid_candidato;
    }

    public void setTipoid_candidato(String tipoid_candidato) {
        this.tipoid_candidato = tipoid_candidato;
    }

    public String getDocumento_candidato() {
        return documento_candidato;
    }

    public void setDocumento_candidato(String documento_candidato) {
        this.documento_candidato = documento_candidato;
    }

    public String getNombres_candidato() {
        return nombres_candidato;
    }

    public void setNombres_candidato(String nombres_candidato) {
        this.nombres_candidato = nombres_candidato;
    }

    public String getPrimerapellido_candidato() {
        return primerapellido_candidato;
    }

    public void setPrimerapellido_candidato(String primerapellido_candidato) {
        this.primerapellido_candidato = primerapellido_candidato;
    }

    public String getSegundoapellido_candidato() {
        return segundoapellido_candidato;
    }

    public void setSegundoapellido_candidato(String segundoapellido_candidato) {
        this.segundoapellido_candidato = segundoapellido_candidato;
    }

    public String getGenero_candidato() {
        return genero_candidato;
    }

    public void setGenero_candidato(String genero_candidato) {
        this.genero_candidato = genero_candidato;
    }

    public String getCorreo_candidato() {
        return correo_candidato;
    }

    public void setCorreo_candidato(String correo_candidato) {
        this.correo_candidato = correo_candidato;
    }

    public String getEstado_formacion() {
        return estado_formacion;
    }

    public void setEstado_formacion(String estado_formacion) {
        this.estado_formacion = estado_formacion;
    }

    public String getEstado_voto() {
        return estado_voto;
    }

    public void setEstado_voto(String estado_voto) {
        this.estado_voto = estado_voto;
    }

    public String getEstado_candidato() {
        return estado_candidato;
    }

    public void setEstado_candidato(String estado_candidato) {
        this.estado_candidato = estado_candidato;
    }

    public String getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getId_jornada() {
        return id_jornada;
    }

    public void setId_jornada(String id_jornada) {
        this.id_jornada = id_jornada;
    }

    public String getJornada() {
        return jornada;
    }

    public void setJornada(String jornada) {
        this.jornada = jornada;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

 

    

  

}
