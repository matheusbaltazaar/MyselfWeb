package br.com.myself.web.util.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator
public class ValorValidator implements Validator {

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {

		double valor = (double) value;

		if (valor <= 0) {
			throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Valor deve ser maior que 0", null));
		}

	}

}
