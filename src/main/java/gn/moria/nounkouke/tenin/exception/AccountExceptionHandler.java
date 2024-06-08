package gn.moria.nounkouke.tenin.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AccountExceptionHandler {

    @ExceptionHandler(UnverifiedEmailAddressException.class)
    public ErrorResponse on(UnverifiedEmailAddressException e){
        var problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.UNAUTHORIZED,e.getMessage());
        var response = ErrorResponse.builder(e,problemDetail).build();
        return response;
    }

    @ExceptionHandler(UnverifiedPhoneNumberException.class)
    public ErrorResponse on(UnverifiedPhoneNumberException e){
        var problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.UNAUTHORIZED,e.getMessage());
        var response = ErrorResponse.builder(e,problemDetail).build();
        return response;
    }

    @ExceptionHandler(LockedException.class)
    public ErrorResponse on(LockedException e){
        var problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.UNAUTHORIZED,e.getMessage());
        var response = ErrorResponse.builder(e,problemDetail).build();
        return response;
    }

    @ExceptionHandler(DisabledException.class)
    public ErrorResponse on(DisabledException e){
        var problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.UNAUTHORIZED,e.getMessage());
        var response = ErrorResponse.builder(e,problemDetail).build();
        return response;
    }

    @ExceptionHandler(CredentialsExpiredException.class)
    public ErrorResponse on(CredentialsExpiredException e){
        var problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.UNAUTHORIZED,e.getMessage());
        var response = ErrorResponse.builder(e,problemDetail).build();
        return response;
    }
}
