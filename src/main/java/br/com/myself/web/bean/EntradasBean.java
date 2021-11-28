package br.com.myself.web.bean;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.com.myself.web.entity.Entrada;
import br.com.myself.web.service.EntradaService;
import br.com.myself.web.service.util.ServiceException;

@ManagedBean
@SessionScoped
public class EntradasBean {
	

	private Entrada novaEntrada = new Entrada();
	private Entrada entradaSelecionada;
	private List<Entrada> entradas;
	Logger logger = Logger.getLogger("MyLogger");

	EntradaService service = new EntradaService();
	
	public List<Entrada> getEntradas() {
		try {
			setEntradas(service.obterTodasEntradas());
		} catch (ServiceException e) {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null));
		}
		return entradas;
	}

	public void setEntradas(List<Entrada> entradas) {
		this.entradas = entradas;
	}
	
	public void salvarEntrada() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {

			service.salvar(this.novaEntrada);

			logger.log(Level.INFO, "Entrada salva >>>> " + novaEntrada);

			context.addMessage(null, new FacesMessage("A entrada foi salva"));
			this.novaEntrada = new Entrada();
		
		} catch (ServiceException e) {
			e.printStackTrace();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null));
		}
	}

	public void excluirEntrada() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {

			service.excluir(this.entradaSelecionada);
			
			context.addMessage(null, new FacesMessage("Entrada excluído"));
			
			logger.log(Level.INFO, "Entrada excluída >>>> " + entradaSelecionada);
			
		} catch (ServiceException e) {
			e.printStackTrace();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null));
		}
	}
	
	public void editarEntrada() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {

			service.salvar(this.entradaSelecionada);
			
			context.addMessage(null, new FacesMessage("Entrada alterada"));
			
			logger.log(Level.INFO, "Entrada alterada >>>> " + entradaSelecionada);
			
		} catch (ServiceException e) {
			e.printStackTrace();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null));
		}
	}

	public Entrada getNovaEntrada() {
		return novaEntrada;
	}

	public void setNovaEntrada(Entrada novaEntrada) {
		this.novaEntrada = novaEntrada;
	}

	public Entrada getEntradaSelecionada() {
		return entradaSelecionada;
	}

	public void setEntradaSelecionada(Entrada entradaSelecionada) {
		this.entradaSelecionada = entradaSelecionada;
	}

}
