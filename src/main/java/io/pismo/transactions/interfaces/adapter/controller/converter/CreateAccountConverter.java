package io.pismo.transactions.interfaces.adapter.controller.converter;

import io.pismo.transactions.entity.Account;
import io.pismo.transactions.interfaces.adapter.controller.model.account.createaccount.CreateAccountRequest;

public class CreateAccountConverter {

    public static Account toModel(final CreateAccountRequest account) {
        return Account.builder()
                .documentNumber(account.getDocumentNumber())
                .build();
    }
}
