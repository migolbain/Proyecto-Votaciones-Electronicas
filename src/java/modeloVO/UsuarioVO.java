package modeloVO;

import java.io.InputStream;

/**
 *
 * @author APRENDIZ
 */
public class UsuarioVO {

    String usuId, usuLogin, usuPassword, usuRol, id_persona, tipoid_persona, documento_persona, nombres_persona, primerapellido_persona, segundoapellido_persona, genero_persona, correo_persona, estado_formacion, estado_voto, estado_candidato, id_usuario, id_jornada, jornada, rol, cargo;
    InputStream archivoimg;
    private byte[] archivoimg2;

    public UsuarioVO() {
    }

    public UsuarioVO(String usuId, String usuLogin, String usuPassword, String usuRol, String id_persona, String tipoid_persona, String documento_persona, String nombres_persona, String primerapellido_persona, String segundoapellido_persona, String genero_persona, String correo_persona, String estado_formacion, String estado_voto, String estado_candidato, String id_usuario, String id_jornada, String jornada, String rol, String cargo, byte[] archivoimg2) {
        this.usuId = usuId;
        this.usuLogin = usuLogin;
        this.usuPassword = usuPassword;
        this.usuRol = usuRol;

        this.id_persona = id_persona;
        this.tipoid_persona = tipoid_persona;
        this.documento_persona = documento_persona;
        this.nombres_persona = nombres_persona;
        this.primerapellido_persona = primerapellido_persona;
        this.segundoapellido_persona = segundoapellido_persona;
        this.genero_persona = genero_persona;
        this.correo_persona = correo_persona;
        this.estado_formacion = estado_formacion;
        this.estado_voto = estado_voto;
        this.estado_candidato = estado_candidato;
        this.id_usuario = id_usuario;
        this.id_jornada = id_jornada;

        this.jornada = jornada;
        this.rol = rol;
        this.cargo = cargo;

        this.archivoimg2 = archivoimg2;

    }

    public UsuarioVO(String usuId, String usuLogin, String usuClave) {
        this.usuId = usuId;
        this.usuLogin = usuLogin;
        this.usuPassword = usuClave;
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

    public InputStream getArchivoimg() {
        return archivoimg;
    }

    public void setArchivoimg(InputStream archivoimg) {
        this.archivoimg = archivoimg;
    }

    public byte[] getArchivoimg2() {
        return archivoimg2;
    }

    /**
     * @param archivopdf2 the archivopdf2 to set
     */
    public void setArchivoimg2(byte[] archivoimg2) {
        this.archivoimg2 = archivoimg2;
    }

}
