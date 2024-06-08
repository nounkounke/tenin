package gn.moria.nounkouke.tenin.validation;

import gn.moria.nounkouke.tenin.request.AddUserAccountRequest;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class AddUserAccountRequestValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(AddUserAccountRequest.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        AddUserAccountRequest request = (AddUserAccountRequest) target;
    }
}
