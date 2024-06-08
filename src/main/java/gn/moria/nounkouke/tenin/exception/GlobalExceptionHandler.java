package gn.moria.nounkouke.tenin.exception;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({DuplicateKeyException.class})
    public ResponseEntity<ErrorResponse> on(DuplicateKeyException e){

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }
}
