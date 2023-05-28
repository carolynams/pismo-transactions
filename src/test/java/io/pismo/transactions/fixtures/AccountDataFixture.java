package io.pismo.transactions.fixtures;

import io.pismo.transactions.interfaces.adapter.gateway.database.AccountData;

public class AccountDataFixture {

    public static AccountData createAccountData() {
        return AccountData.builder()
                .documentNumber("12345678910")
                .build();
    }
}
