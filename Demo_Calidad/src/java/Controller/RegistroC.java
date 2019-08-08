package Controller;

import Dao.RegistroD;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import modelo.RegistroM;

@Named(value = "registroC")
@SessionScoped
public class RegistroC implements Serializable {

    private RegistroM registro = new RegistroM();
    private List<RegistroM> lstRegistro;

    @PostConstruct
    public void iniciar() {
        try {
            listar();
        } catch (Exception e) {
        }
    }

    public void guardar() throws Exception {
        RegistroD dao;
        try {
            dao = new RegistroD();
            dao.Registrar(registro);
            listar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("AGREGADO"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("ERROR"));
            throw e;
        }
    }

    public void listar() throws Exception {
        RegistroD dao;
        try {
            dao = new RegistroD();
            dao.listar();
        } catch (Exception e) {
            throw e;
        }
    }

    public RegistroM getRegistro() {
        return registro;
    }

    public void setRegistro(RegistroM registro) {
        this.registro = registro;
    }

    public List<RegistroM> getLstRegistro() {
        return lstRegistro;
    }

    public void setLstRegistro(List<RegistroM> lstRegistro) {
        this.lstRegistro = lstRegistro;
    }

}
