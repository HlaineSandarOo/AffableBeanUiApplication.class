package com.example.affablebeanbackend.exception;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestController
public class RestExceptionalHandler extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        return handleExceptionInternal(
                ex,
                message(status.value(), ex),
                headers,
                status, request);
    }
    private ApiError message(int status, Exception e) {
        String message = e == null ? "Unknown Error" : e.getMessage();
        String developerMessage = ExceptionUtils.getRootCauseMessage(e);
        return new ApiError(status, message, developerMessage);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        return handleExceptionInternal(
                ex,
                message(status.value(), ex),
                headers,
                status, request);
    }
}
