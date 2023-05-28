package io.pismo.transactions.fixtures;

import io.pismo.transactions.entity.Account;

public class AccountFixture {

    public static Account createAccount() {
        return Account.builder()
                .documentNumber("12345678910")
                .build();
    }
}
