package io.pismo.transactions.usecases.exceptions;

public class RepeatedAccountException extends DomainException {

    public RepeatedAccountException() {
        super(422, "Account already exists for this document number.");
    }
}
