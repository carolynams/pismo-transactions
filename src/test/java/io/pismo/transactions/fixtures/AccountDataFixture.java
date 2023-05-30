package io.pismo.transactions.fixtures;

import io.pismo.transactions.interfaces.adapter.gateway.database.AccountData;

import java.math.BigDecimal;

public class AccountDataFixture {

    public static AccountData createAccountData() {
        return AccountData.builder()
                .documentNumber("12345678910")
                .availableCreditLimit(new BigDecimal("500.00"))
                .build();
    }
}
