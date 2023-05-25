package io.pismo.transactions.interfaces.adapter.controller.converter;

import io.pismo.transactions.entity.Account;

import java.util.UUID;

public class FindAccountConverter {

    public static Account toModel(final String accountId) {
        return Account.builder()
                .id(UUID.fromString(accountId))
                .build();
    }
}
