package validation;

import io.lytrax.afm.ValidateAFM;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class AfmValidator implements ConstraintValidator<AfmConstraint, String> {

    @Override
    public void initialize(AfmConstraint afm) {
        ConstraintValidator.super.initialize(afm);
    }

    @Override
    public boolean isValid(String afm, ConstraintValidatorContext cxt) {
        return ValidateAFM.Validate(afm);
    }

}
