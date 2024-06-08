package gn.moria.nounkouke.tenin.validation;

import gn.moria.nounkouke.tenin.request.UserAccountEnrollmentRequest;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.Validator;

public class UserAccountEnrollmentRequestValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(UserAccountEnrollmentRequest.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserAccountEnrollmentRequest request = (UserAccountEnrollmentRequest) target;
        if (!StringUtils.hasText(request.getGovIdentifier().getSsn())){
            errors.getFieldErrors().add(new FieldError("govIdentifier","govIdentifier.ssn","user ssn is required for bank enrollment"));
        }
    }
}
