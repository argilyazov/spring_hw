package com.example.demo.anotation.validator;

import com.example.demo.anotation.PhoneNumberConstraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PhoneNumberValidator implements ConstraintValidator<PhoneNumberConstraint,String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        return value.length() == 12 && value.charAt(0) == '+' || value.length() == 11 && value.charAt(0) == '8';
    }
}
