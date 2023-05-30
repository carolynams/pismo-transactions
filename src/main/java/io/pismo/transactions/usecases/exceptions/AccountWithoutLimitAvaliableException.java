package io.pismo.transactions.usecases.exceptions;

import org.springframework.http.HttpStatus;

public class AccountWithoutLimitAvaliableException extends DomainException {

    public AccountWithoutLimitAvaliableException() {
        super(HttpStatus.UNPROCESSABLE_ENTITY.value(), "Account doesn't have limit avaliable.");
    }
}
