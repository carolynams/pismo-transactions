package io.pismo.transactions.interfaces.adapter.exception;

import io.pismo.transactions.interfaces.adapter.controller.model.ExceptionResponse;
import io.pismo.transactions.usecases.exceptions.DomainException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import reactor.core.publisher.Mono;

import java.util.Locale;
import java.util.Objects;

@Slf4j
@RestControllerAdvice
@RequiredArgsConstructor
public class CustomExceptionHandler {

    private final MessageSource messageSource;

    @ExceptionHandler({DomainException.class})
    public Mono<ResponseEntity<ExceptionResponse>> handleDomainException(final DomainException exception,
                                                                         final ServerHttpRequest request) {
        log.error("Handling exception.", exception);
        return this.handlerException(exception.getStatusCode(), exception.getMessage());
    }

    private Mono<ResponseEntity<ExceptionResponse>> handlerException(final int statusCode,
                                                                     final String messageKey) {
        final var httpStatus = HttpStatus.resolve(statusCode);

        if (httpStatus == HttpStatus.NO_CONTENT) {
            return Mono.just(ResponseEntity.noContent().build());
        } else {
            final var response = this.getExceptionResponse(Objects.requireNonNull(httpStatus),
                    this.messageSource.getMessage(messageKey, null, messageKey, Locale.getDefault()));

            return Mono.just(response);
        }
    }

    private ResponseEntity<ExceptionResponse> getExceptionResponse(final HttpStatus status, final String message) {
        final var response = ExceptionResponse.builder()
                .status(status.value())
                .message(message)
                .build();
        return new ResponseEntity<>(response, status);
    }
}
