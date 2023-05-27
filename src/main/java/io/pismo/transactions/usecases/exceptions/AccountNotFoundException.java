package io.pismo.transactions.usecases.exceptions;

import org.springframework.http.HttpStatus;

public class AccountNotFoundException extends DomainException {

    public AccountNotFoundException() {
        super(HttpStatus.NOT_FOUND.value(), "Account not found.");
    }
}
