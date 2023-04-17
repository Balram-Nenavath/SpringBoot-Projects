package com.sample.postgress.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CustomValidator implements ConstraintValidator<CustomValidation, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
		return false;
        // Add your validation logic here
        // Return true if the input is valid, false otherwise
    }
}
