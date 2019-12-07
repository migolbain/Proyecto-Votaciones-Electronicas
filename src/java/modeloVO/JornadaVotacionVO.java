/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloVO;

/**
 *
 * @author migol
 */
public class JornadaVotacionVO {

    String ID_JornadaVotacion, Fecha_JornadaApertura, Fecha_JornadaCierre, Estado_JornadaVotacion, Fecha_Jornada, Estado_Voto, id_persona, tipoid_persona, documento_persona, nombres_persona, primerapellido_persona, segundoapellido_persona, genero_persona, correo_persona, estado_formacion,  estado_candidato, id_usuario, id_jornada, ID_Detallejornada;
    public JornadaVotacionVO() {

    }
    public JornadaVotacionVO(String ID_JornadaVotacion, String Fecha_JornadaApertura, String Fecha_JornadaCierre, String Estado_JornadaVotacion, String Fecha_Jornada, String Estado_Voto,String id_persona, String tipoid_persona, String documento_persona, String nombres_persona, String primerapellido_persona, String segundoapellido_persona, String genero_persona, String correo_persona, String estado_formacion,  String estado_candidato, String id_usuario, String id_jornada, String ID_Detallejornada){
        this.ID_JornadaVotacion = ID_JornadaVotacion;
        this.Fecha_JornadaApertura = Fecha_JornadaApertura;
        this.Fecha_JornadaCierre = Fecha_JornadaCierre;
        this.Estado_JornadaVotacion = Estado_JornadaVotacion;
        this.Fecha_Jornada = Fecha_Jornada;
        
        this.Estado_Voto = Estado_Voto;
        
        this.id_persona = id_persona;
        this.tipoid_persona = tipoid_persona;
        this.documento_persona = documento_persona;
        this.nombres_persona = nombres_persona;
        this.primerapellido_persona = primerapellido_persona;
        this.segundoapellido_persona = segundoapellido_persona;
        this.genero_persona = genero_persona;
        this.correo_persona = correo_persona;
        this.estado_formacion = estado_formacion;
        this.estado_candidato = estado_candidato;
        this.id_usuario = id_usuario;
        this.id_jornada = id_jornada;
        
        this.ID_Detallejornada = ID_Detallejornada;
    }

    public String getID_Detallejornada() {
        return ID_Detallejornada;
    }

    public void setID_Detallejornada(String ID_Detallejornada) {
        this.ID_Detallejornada = ID_Detallejornada;
    }

    public String getId_persona() {
        return id_persona;
    }

    public void setId_persona(String id_persona) {
        this.id_persona = id_persona;
    }

    public String getTipoid_persona() {
        return tipoid_persona;
    }

    public void setTipoid_persona(String tipoid_persona) {
        this.tipoid_persona = tipoid_persona;
    }

    public String getDocumento_persona() {
        return documento_persona;
    }

    public void setDocumento_persona(String documento_persona) {
        this.documento_persona = documento_persona;
    }

    public String getNombres_persona() {
        return nombres_persona;
    }

    public void setNombres_persona(String nombres_persona) {
        this.nombres_persona = nombres_persona;
    }

    public String getPrimerapellido_persona() {
        return primerapellido_persona;
    }

    public void setPrimerapellido_persona(String primerapellido_persona) {
        this.primerapellido_persona = primerapellido_persona;
    }

    public String getSegundoapellido_persona() {
        return segundoapellido_persona;
    }

    public void setSegundoapellido_persona(String segundoapellido_persona) {
        this.segundoapellido_persona = segundoapellido_persona;
    }

    public String getGenero_persona() {
        return genero_persona;
    }

    public void setGenero_persona(String genero_persona) {
        this.genero_persona = genero_persona;
    }

    public String getCorreo_persona() {
        return correo_persona;
    }

    public void setCorreo_persona(String correo_persona) {
        this.correo_persona = correo_persona;
    }

    public String getEstado_formacion() {
        return estado_formacion;
    }

    public void setEstado_formacion(String estado_formacion) {
        this.estado_formacion = estado_formacion;
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

    public String getEstado_Voto() {
        return Estado_Voto;
    }

    public void setEstado_Voto(String Estado_Voto) {
        this.Estado_Voto = Estado_Voto;
    }

    public String getFecha_Jornada() {
        return Fecha_Jornada;
    }

    public void setFecha_Jornada(String Fecha_Jornada) {
        this.Fecha_Jornada = Fecha_Jornada;
    }

    public String getID_JornadaVotacion() {
        return ID_JornadaVotacion;
    }

    public void setID_JornadaVotacion(String ID_JornadaVotacion) {
        this.ID_JornadaVotacion = ID_JornadaVotacion;
    }

    public String getFecha_JornadaApertura() {
        return Fecha_JornadaApertura;
    }

    public void setFecha_JornadaApertura(String Fecha_JornadaApertura) {
        this.Fecha_JornadaApertura = Fecha_JornadaApertura;
    }

    public String getFecha_JornadaCierre() {
        return Fecha_JornadaCierre;
    }

    public void setFecha_JornadaCierre(String Fecha_JornadaCierre) {
        this.Fecha_JornadaCierre = Fecha_JornadaCierre;
    }

    public String getEstado_JornadaVotacion() {
        return Estado_JornadaVotacion;
    }

    public void setEstado_JornadaVotacion(String Estado_JornadaVotacion) {
        this.Estado_JornadaVotacion = Estado_JornadaVotacion;
    }
}
