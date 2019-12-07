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
public class LanzarseCandidatoVO {
    
    String ID_Usuario, ID_Persona, Estado_Candidato, ID_RolUsu;
     
     public LanzarseCandidatoVO() {

    }
      public LanzarseCandidatoVO(String ID_Usuario, String ID_Persona, String Estado_Candidato, String ID_RolUsu) {
          this.ID_Usuario = ID_Usuario;
        this.ID_Persona = ID_Persona;
        this.Estado_Candidato = Estado_Candidato;
        this.ID_RolUsu = ID_RolUsu;     
    }

    public String getID_Usuario() {
        return ID_Usuario;
    }

    public void setID_Usuario(String ID_Usuario) {
        this.ID_Usuario = ID_Usuario;
    }

 

    public String getID_Persona() {
        return ID_Persona;
    }

    public void setID_Persona(String ID_Persona) {
        this.ID_Persona = ID_Persona;
    }

    public String getEstado_Candidato() {
        return Estado_Candidato;
    }

    public void setEstado_Candidato(String Estado_Candidato) {
        this.Estado_Candidato = Estado_Candidato;
    }

    public String getID_RolUsu() {
        return ID_RolUsu;
    }

    public void setID_RolUsu(String ID_RolUsu) {
        this.ID_RolUsu = ID_RolUsu;
    }
}
