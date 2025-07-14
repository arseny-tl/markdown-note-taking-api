package org.tl.roadmap.markdownnotetakingapi.api;

import jakarta.validation.ValidationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.tl.roadmap.markdownnotetakingapi.service.exception.GrammarCheckException;

@Slf4j
@ControllerAdvice
public class CommonExceptionHandler {

    static ErrorDTO singleError(String message) {
        return new ErrorDTO(message);
    }

    @ExceptionHandler(GrammarCheckException.class)
    public ResponseEntity<ErrorDTO> handle(GrammarCheckException e) {
        log.error("Unable to check grammar", e);
        return ResponseEntity.internalServerError().body(singleError("Internal server error"));
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<ErrorDTO> handle(ValidationException e) {
        log.error("Validation exception", e);
        return ResponseEntity.badRequest().body(singleError(e.getMessage()));
    }

    @ExceptionHandler
    public ResponseEntity<ErrorDTO> handle(Throwable e) {
        log.warn("Unexpected exception", e);
        return ResponseEntity.internalServerError().body(singleError("Internal server error"));
    }
}
