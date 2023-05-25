package io.pismo.transactions.interfaces.adapter.controller.model.transaction;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@Builder
@RequiredArgsConstructor
public final class TransactionRequest {

    @NotBlank
    private final String accountId;
    @NotNull
    private final Integer operationTypeId;
    @NotNull
    private final BigDecimal amount;

}
