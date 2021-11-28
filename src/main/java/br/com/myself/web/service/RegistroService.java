package br.com.myself.web.service;

import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;

import br.com.myself.web.entity.Registro;
import br.com.myself.web.service.util.ServiceException;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

public class RegistroService extends Service {

	
	
	public List<Registro> obterTodosRegistros() throws ServiceException {
		
		Response response = getClientTarget("registros")
				.request(MediaType.APPLICATION_JSON)
				.get();
		
		String jsonResponseString = response.readEntity(String.class);
		
		
		try {
			return mapper.convertValue(mapper.readTree(jsonResponseString), new TypeReference<List<Registro>>(){});
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("ServiceException: Erro ao mapear dados");
		}
				
	}
	

	public Registro salvar(Registro registro) throws ServiceException {

		Response response = getClientTarget("registro")
			.request(MediaType.APPLICATION_JSON)
			.post(Entity.entity(registro, MediaType.APPLICATION_JSON));
		
		
		if (response.getStatusInfo().getStatusCode() != Status.OK.getStatusCode()) {
			throw new ServiceException("ServiceException: Erro ao salvar registro");
		}

		return response.readEntity(Registro.class);
	}
	
	public void excluir(Registro registro) throws ServiceException {
		
		Response response = getClientTarget("registro", String.valueOf(registro.getId()))
				.request()
				.delete();

		if (response.getStatusInfo().getStatusCode() != Status.OK.getStatusCode()) {
			throw new ServiceException("ServiceException: Erro ao excluir registro");
		}
	}
	
}
