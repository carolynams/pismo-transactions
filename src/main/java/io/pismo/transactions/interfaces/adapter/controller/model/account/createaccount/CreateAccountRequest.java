package io.pismo.transactions.interfaces.adapter.controller.model.account.createaccount;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public final class CreateAccountRequest {

    @NotBlank
    private String documentNumber;

    @NotNull
    private BigDecimal availableCreditLimit;

}
