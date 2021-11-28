package br.com.myself.web.bean;

import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.com.myself.web.entity.Registro;
import br.com.myself.web.service.RegistroService;
import br.com.myself.web.service.util.ServiceException;

@ManagedBean
@SessionScoped
public class RegistrosBean {
	

	private Registro novoRegistro = new Registro();
	private Registro registroSelecionado;
	private List<Registro> registros;
	private List<Registro> registrosFiltrados;
	

	Logger logger = Logger.getLogger("MyLogger");

	RegistroService service = new RegistroService();
	
	public List<Registro> getRegistros() {
		try {
			setRegistros(service.obterTodosRegistros());
		} catch (ServiceException e) {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null));
		}
		return registros;
	}

	public void setRegistros(List<Registro> registros) {
		this.registros = registros;
	}
	
	public void salvarRegistro() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {

			this.service.salvar(this.novoRegistro);

			logger.info("Registro salvo >>>> " + novoRegistro);

			context.addMessage(null, new FacesMessage("O registro foi salvo"));
			this.novoRegistro = new Registro();
		
		} catch (ServiceException e) {
			e.printStackTrace();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null));
		}
	}

	public void excluirRegistro() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {

			service.excluir(this.registroSelecionado);
			
			context.addMessage(null, new FacesMessage("Registro excluído"));
			
			logger.info("Registro excluído >>>> " + registroSelecionado);
			
		} catch (ServiceException e) {
			e.printStackTrace();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null));
		}
	}
	
	public void atualizarRegistro() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {

			service.salvar(this.registroSelecionado);

			logger.log(Level.INFO, "Registro atualizado >>>> " + this.registroSelecionado);

			context.addMessage(null, new FacesMessage("O registro foi atualizado"));
		
		} catch (ServiceException e) {
			e.printStackTrace();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null));
		}
	}
	
	public boolean globalFilterFunction(Object entity, Object filter, Locale locale) {
		if (filter == null)
			return true;
		
		String filterText = filter.toString().trim().toLowerCase();
		if (filterText.length() == 0) {
			return true;
		}

		Registro registro = (Registro) entity;

		return registro.getDescricao().toLowerCase().contains(filterText);
	}
	
	public Registro getNovoRegistro() {
		return novoRegistro;
	}

	public void setNovoRegistro(Registro novoRegistro) {
		this.novoRegistro = novoRegistro;
	}

	public Registro getRegistroSelecionado() {
		return registroSelecionado;
	}

	public void setRegistroSelecionado(Registro registroSelecionado) {
		this.registroSelecionado = registroSelecionado;
	}

	public List<Registro> getRegistrosFiltrados() {
		return registrosFiltrados;
	}

	public void setRegistrosFiltrados(List<Registro> registrosFiltrados) {
		this.registrosFiltrados = registrosFiltrados;
	}

}
