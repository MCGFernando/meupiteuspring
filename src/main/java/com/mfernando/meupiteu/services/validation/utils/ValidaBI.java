package com.mfernando.meupiteu.services.validation.utils;

import ch.qos.logback.core.boolex.Matcher;
import jakarta.validation.constraints.Pattern;

public class ValidaBI {
	public static boolean isValidBI(String bi) {
		String regex = "\\d{9}\\w{2}\\d{3}";
		if(bi.length()!=14) return false;
		return bi.matches(regex);
	}
}
