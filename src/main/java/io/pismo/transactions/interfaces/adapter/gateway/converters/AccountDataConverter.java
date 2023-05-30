package io.pismo.transactions.interfaces.adapter.gateway.converters;

import io.pismo.transactions.entity.Account;
import io.pismo.transactions.interfaces.adapter.gateway.database.AccountData;

public class AccountDataConverter {

    public static AccountData toDomain(final Account account) {
        return AccountData.builder()
                .documentNumber(account.getDocumentNumber())
                .availableCreditLimit(account.getAvailableCreditLimit())
                .build();
    }
}
