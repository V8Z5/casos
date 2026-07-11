package com.atlassian.platform.u202322849.shared.interfaces.rest.exception;

import com.atlassian.platform.u202322849.requests.domain.model.exceptions.BusinessRuleException;
import com.atlassian.platform.u202322849.requests.domain.model.exceptions.DuplicatePendingAccessRequestException;
import com.atlassian.platform.u202322849.shared.interfaces.rest.resources.ErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.time.LocalDateTime;
import java.util.stream.Collectors;

/** Centralized REST exception handler.
 * @author Marlon Packard Viza Quispe
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(DuplicatePendingAccessRequestException.class)
    public ResponseEntity<ErrorResponse> handleConflict(DuplicatePendingAccessRequestException exception,
                                                         HttpServletRequest request) {
        return build(HttpStatus.CONFLICT, exception.getMessage(), request.getRequestURI());
    }

    @ExceptionHandler({BusinessRuleException.class, IllegalArgumentException.class,
            ConstraintViolationException.class, HttpMessageNotReadableException.class})
    public ResponseEntity<ErrorResponse> handleBadRequest(Exception exception, HttpServletRequest request) {
        return build(HttpStatus.BAD_REQUEST, exception.getMessage(), request.getRequestURI());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidation(MethodArgumentNotValidException exception,
                                                           HttpServletRequest request) {
        String message = exception.getBindingResult().getFieldErrors().stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .collect(Collectors.joining("; "));
        return build(HttpStatus.BAD_REQUEST, message, request.getRequestURI());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleUnexpected(Exception exception, HttpServletRequest request) {
        return build(HttpStatus.INTERNAL_SERVER_ERROR, "An unexpected error occurred.", request.getRequestURI());
    }

    private ResponseEntity<ErrorResponse> build(HttpStatus status, String message, String path) {
        return ResponseEntity.status(status).body(new ErrorResponse(
                status.value(), status.getReasonPhrase(), message, path, LocalDateTime.now()));
    }
}
