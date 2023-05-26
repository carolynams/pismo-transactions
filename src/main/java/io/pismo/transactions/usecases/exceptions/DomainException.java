package io.pismo.transactions.usecases.exceptions;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class DomainException extends RuntimeException {

    private final int statusCode;
    private final String message;
}
