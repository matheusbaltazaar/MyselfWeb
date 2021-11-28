package br.com.myself.web.util.converter;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("maskDateToLongConverter")
public class DateConverter implements Converter {
	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		try {
			return sdf.parse(value).getTime();
		} catch (Exception e) {;
			context.addMessage("data", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Data inválida", null));
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		try {
			return sdf.format(new Date((Long) value));
		} catch (Exception e) {
			String msg1 = "Erro ao converter data";
			String msg2 = "DateConverter:getAsString";
			context.addMessage("data", new FacesMessage(FacesMessage.SEVERITY_ERROR, msg1, msg2));
		}
		return null;
	}

}
