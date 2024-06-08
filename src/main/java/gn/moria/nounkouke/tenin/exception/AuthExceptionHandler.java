package gn.moria.nounkouke.tenin.exception;

import gn.moria.nounkouke.tenin.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AuthExceptionHandler {

    @ExceptionHandler(InvalidCredentialException.class)
    public ErrorResponse on(InvalidCredentialException e){
        var problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.UNAUTHORIZED,e.getMessage());
        var response = ErrorResponse.builder(e,problemDetail).build();
        return response;
    }
}
