package com.ahmadi.onlineshop.service.customValidation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;

public class PhoneNumberFormatValidator implements
        ConstraintValidator<PhoneNumberFormatConstraint, String> {
    private static final String IRANIAN_MOBILE_REGEX = "^(\\+98|0)?9\\d{9}$";

    @Override
    public boolean isValid(String mobile, ConstraintValidatorContext constraintValidatorContext) {
        if (mobile == null || mobile.isEmpty()) {
            return false;
        }
        return mobile.matches(IRANIAN_MOBILE_REGEX);

    }
}