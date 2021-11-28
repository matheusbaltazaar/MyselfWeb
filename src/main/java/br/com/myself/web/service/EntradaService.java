package br.com.myself.web.service;

import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;

import br.com.myself.web.entity.Entrada;
import br.com.myself.web.service.util.ServiceException;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

public class EntradaService extends Service {

	
	
	public List<Entrada> obterTodasEntradas() throws ServiceException {
		
		Response response = getClientTarget("entradas")
				.request(MediaType.APPLICATION_JSON)
				.get();
		
		String jsonResponseString = response.readEntity(String.class);
			
		
		try {	
			return mapper.convertValue(mapper.readTree(jsonResponseString), new TypeReference<List<Entrada>>(){});
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("ServiceException: Erro ao mapear dados");
		}
				
	}
	

	public Entrada salvar(Entrada entrada) throws ServiceException {

		Response response = getClientTarget("entrada")
			.request(MediaType.APPLICATION_JSON)
			.post(Entity.entity(entrada, MediaType.APPLICATION_JSON));
		
		
		if (response.getStatusInfo().getStatusCode() != Status.OK.getStatusCode()) {
			throw new ServiceException("ServiceException: Erro ao salvar entrada");
		}

		return response.readEntity(Entrada.class);
	}
	
	public void excluir(Entrada entrada) throws ServiceException {
		
		Response response = getClientTarget("entrada", String.valueOf(entrada.getId()))
				.request()
				.delete();

		if (response.getStatusInfo().getStatusCode() != Status.OK.getStatusCode()) {
			throw new ServiceException("ServiceException: Erro ao excluir entrada");
		}
	}
	
}
