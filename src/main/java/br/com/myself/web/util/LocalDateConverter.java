package br.com.myself.web.util;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("localDateConverter")
public class LocalDateConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		try {

			LocalDate data = (LocalDate) value;

			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

			return data.format(formatter);
		} catch (Exception e) {
			if (e instanceof ClassCastException)
				context.addMessage("data",
						new FacesMessage("Este converter é válido somente em atributos do tipo LocalDate"));
			if (e instanceof DateTimeException)
				context.addMessage("data", new FacesMessage("Erro ao converter data"));
		}
		return null;
	}

}
