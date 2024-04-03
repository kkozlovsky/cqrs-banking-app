package ru.kerporation.core.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.kerporation.common.domain.exception.ResourceAlreadyExistsException;
import ru.kerporation.common.domain.exception.ResourceNotFoundException;
import ru.kerporation.core.web.dto.MessageDto;

import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
@Slf4j
public class ControllerAdvice {

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public MessageDto resourceNotFound(final ResourceNotFoundException e) {
        log.error(e.getMessage(), e);
        return new MessageDto(e.getMessage() != null ? e.getMessage() : "Not found.");
    }

    @ExceptionHandler(ResourceAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public MessageDto resourceAlreadyExists(final ResourceAlreadyExistsException e) {
        log.error(e.getMessage(), e);
        return new MessageDto(e.getMessage() != null ? e.getMessage() : "Already exists.");
    }

    @ExceptionHandler({BadCredentialsException.class, InternalAuthenticationServiceException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public MessageDto badCredentials(final RuntimeException e) {
        log.error(e.getMessage(), e);
        return new MessageDto("Authentication failed.");
    }

    @ExceptionHandler(AccessDeniedException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public MessageDto accessDenied(final AccessDeniedException e) {
        log.error(e.getMessage(), e);
        return new MessageDto("Access denied.");
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public MessageDto validation(final MethodArgumentNotValidException e) {
        final Map<String, String> errors = e.getBindingResult().getFieldErrors()
                .stream()
                .collect(Collectors.toMap(FieldError::getField, DefaultMessageSourceResolvable::getDefaultMessage, (existingMessage, newMessage) -> existingMessage + " " + newMessage));
        return new MessageDto("Validation failed.", errors);
    }

    @ExceptionHandler(IllegalStateException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public MessageDto illegalState(final IllegalStateException e) {
        log.error(e.getMessage(), e);
        return new MessageDto(e.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public MessageDto exception(final Exception e) {
        log.error(e.getMessage(), e);
        return new MessageDto("Server error.");
    }

}