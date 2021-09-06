package br.com.myself.web.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.myself.web.entity.Registro;

@ManagedBean
@ViewScoped
public class RegistrosBean {
		
	private Registro novoRegistro = new Registro();
	private List<Registro> registros = new ArrayList<Registro>();
	
	public void salvarRegistro() {
		
		registros.add(novoRegistro);
		
		novoRegistro = new Registro();

		
		Logger logger = Logger.getLogger("MyLogger");
		logger.log(Level.INFO, "O registro foi salvo -- " + novoRegistro);
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage("buttonSalvar", new FacesMessage("O registro foi salvo!"));
		
	}

	public Registro getNovoRegistro() {
		return novoRegistro;
	}

	public void setNovoRegistro(Registro novoRegistro) {
		this.novoRegistro = novoRegistro;
	}

	public List<Registro> getRegistros() {
		return registros;
	}

	
}
