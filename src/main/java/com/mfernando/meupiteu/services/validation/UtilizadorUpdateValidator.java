package com.mfernando.meupiteu.services.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import com.mfernando.meupiteu.domain.Utilizador;
import com.mfernando.meupiteu.domain.enums.TipoUtilizador;
import com.mfernando.meupiteu.dto.UtilizadorDTO;
import com.mfernando.meupiteu.dto.UtilizadorNovoDTO;
import com.mfernando.meupiteu.repositories.UtilizadorRepository;
import com.mfernando.meupiteu.resources.exceptions.FieldsMessageErrors;
import com.mfernando.meupiteu.services.validation.utils.ValidaBI;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UtilizadorUpdateValidator implements ConstraintValidator<UtilizadorUpdate, UtilizadorDTO> {
	@Autowired
	private HttpServletRequest request;
	@Autowired
	private UtilizadorRepository repo;
	@Override
	public void initialize(UtilizadorUpdate ann) {
	}

	@Override
	public boolean isValid(UtilizadorDTO objDto, ConstraintValidatorContext context) {
		List<FieldsMessageErrors> list = new ArrayList<>();
		Map<String, String> map = (Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
		Integer uriId = Integer.parseInt(map.get("id"));
		
		Utilizador utilizador = repo.findByEmail(objDto.getEmail());
		
		if(utilizador != null && !utilizador.getId().equals(uriId)) {
			list.add(new FieldsMessageErrors("email","Email já consta na base de dados"));
		}
		
		
		for (FieldsMessageErrors e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
			
			
		}
		return list.isEmpty();
	}

}
