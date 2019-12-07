/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloVO;

/**
 *
 * @author APRENDIZ
 */
public class PropuestaVO {

    
     String ID_Propuesta,VideoURL_Propuesta,Descripcion_Propuesta,No_Propuesta, ID_Persona, Nombres_persona, PrimerApellido_Persona, Documento_Persona;
     
     public PropuestaVO() {

    }
    
    public PropuestaVO(String ID_Propuesta, String VideoURL_Propuesta, String Descripcion_Propuesta, String No_Propuesta, String ID_Persona, String Nombres_persona, String PrimerApellido_Persona, String Documento_Persona) {
        this.ID_Propuesta = ID_Propuesta;
        this.VideoURL_Propuesta = VideoURL_Propuesta;
        this.Descripcion_Propuesta = Descripcion_Propuesta;
        this.No_Propuesta = No_Propuesta;
        this.ID_Persona = ID_Persona;
        this.Nombres_persona = Nombres_persona;
        this.PrimerApellido_Persona = PrimerApellido_Persona;
        this.Documento_Persona = Documento_Persona;
    }

    public String getNombres_persona() {
        return Nombres_persona;
    }

    public void setNombres_persona(String Nombres_persona) {
        this.Nombres_persona = Nombres_persona;
    }

    public String getPrimerApellido_Persona() {
        return PrimerApellido_Persona;
    }

    public void setPrimerApellido_Persona(String PrimerApellido_Persona) {
        this.PrimerApellido_Persona = PrimerApellido_Persona;
    }

    public String getDocumento_Persona() {
        return Documento_Persona;
    }

    public void setDocumento_Persona(String Documento_Persona) {
        this.Documento_Persona = Documento_Persona;
    }

    public String getID_Persona() {
        return ID_Persona;
    }

    public void setID_Persona(String ID_Persona) {
        this.ID_Persona = ID_Persona;
    }

    public String getID_Propuesta() {
        return ID_Propuesta;
    }

    public void setID_Propuesta(String ID_Propuesta) {
        this.ID_Propuesta = ID_Propuesta;
    }

    public String getVideoURL_Propuesta() {
        return VideoURL_Propuesta;
    }

    public void setVideoURL_Propuesta(String VideoURL_Propuesta) {
        this.VideoURL_Propuesta = VideoURL_Propuesta;
    }

    public String getDescripcion_Propuesta() {
        return Descripcion_Propuesta;
    }

    public void setDescripcion_Propuesta(String Descripcion_Propuesta) {
        this.Descripcion_Propuesta = Descripcion_Propuesta;
    }

    public String getNo_Propuesta() {
        return No_Propuesta;
    }

    public void setNo_Propuesta(String No_Propuesta) {
        this.No_Propuesta = No_Propuesta;
    }

   


}
