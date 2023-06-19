package com.example.demo.anotation;

import com.example.demo.anotation.validator.PhoneNumberValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = PhoneNumberValidator.class)
public @interface PhoneNumberConstraint {
    String message() default "is not Valid";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
