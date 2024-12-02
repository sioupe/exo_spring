package fr.diginamic.hello.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class VilleAdvice {
    @ExceptionHandler({VilleException.class})
    protected ResponseEntity<String> handleVilleException(VilleException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}
