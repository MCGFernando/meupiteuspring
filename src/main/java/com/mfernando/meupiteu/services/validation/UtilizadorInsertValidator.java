package com.mfernando.meupiteu.services.validation;

import java.util.ArrayList;
import java.util.List;

import com.mfernando.meupiteu.domain.enums.TipoUtilizador;
import com.mfernando.meupiteu.dto.UtilizadorNovoDTO;
import com.mfernando.meupiteu.resources.exceptions.FieldsMessageErrors;
import com.mfernando.meupiteu.services.validation.utils.ValidaBI;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UtilizadorInsertValidator implements ConstraintValidator<UtilizadorInsert, UtilizadorNovoDTO> {
	@Override
	public void initialize(UtilizadorInsert ann) {
	}

	@Override
	public boolean isValid(UtilizadorNovoDTO objDto, ConstraintValidatorContext context) {
		List<FieldsMessageErrors> list = new ArrayList<>();

		// inclua os testes aqui, inserindo erros na lista
		
		if(
				(objDto.getTipoUtilizador().equals(TipoUtilizador.OWNER.getCodigo()) ||
				objDto.getTipoUtilizador().equals(TipoUtilizador.EMPLOYEE.getCodigo())) &&
				(!ValidaBI.isValidBI(objDto.getBi()))
				
		) list.add(new FieldsMessageErrors("bi","O BI infomado não é válido"));
		
		
		for (FieldsMessageErrors e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
			
			
		}
		return list.isEmpty();
	}

}
