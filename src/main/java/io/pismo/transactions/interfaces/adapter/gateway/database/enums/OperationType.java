package io.pismo.transactions.interfaces.adapter.gateway.database.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum OperationType {

    COMPRA_A_VISTA(1L),
    COMPRA_PARCELADA(2L),
    SAQUE(3L),
    PAGAMENTO(4L);

    private final Long id;

}
