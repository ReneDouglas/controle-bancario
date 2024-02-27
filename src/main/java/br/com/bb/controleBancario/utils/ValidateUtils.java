package br.com.bb.controleBancario.utils;

import br.com.caelum.stella.validation.CNPJValidator;
import br.com.caelum.stella.validation.CPFValidator;

public class ValidateUtils {

    private ValidateUtils() {
    }

    public static String numberOnly(String string) {
	if (string == null) {
	    return "";
	}
	return string.replaceAll("[^0-9]", "");
    }

    public static boolean isValidCPF(String cpf) {
	if (cpf == null) {
	    return false;
	}

	try {
	    CPFValidator cpfValidator = new CPFValidator(false);
	    cpfValidator.assertValid(cpf.replaceAll("[^\\d+]", ""));
	} catch (Exception e) {
	    return false;
	}
	return true;
    }

    public static boolean isValidCNPJ(String cnpj) {
	if (cnpj == null) {
	    return false;
	}

	try {
	    CNPJValidator cnpjValidator = new CNPJValidator(false);
	    cnpjValidator.assertValid(cnpj.replaceAll("[^\\d+]", ""));
	} catch (Exception e) {
	    return false;
	}
	return true;
    }

}
