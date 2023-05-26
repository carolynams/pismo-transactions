package io.pismo.transactions.usecases.exceptions;

import org.springframework.http.HttpStatus;

public class RepeatedAccountException extends DomainException {

    public RepeatedAccountException() {
        super(HttpStatus.UNPROCESSABLE_ENTITY.value(), "Account already exists for this document number.");
    }
}
