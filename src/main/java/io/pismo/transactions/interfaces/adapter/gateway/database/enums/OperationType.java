package io.pismo.transactions.interfaces.adapter.gateway.database.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum OperationType {

    COMPRA_A_VISTA(1),
    COMPRA_PARCEADA(2),
    SAQUE(3),
    PAGAMENTO(4);

    private final Integer id;

    public static OperationType getOperationType(final Integer type) {
        return Arrays.stream(values())
                .filter(value -> value.getId().equals(type))
                .findFirst()
                .orElse(null);
    }
}
