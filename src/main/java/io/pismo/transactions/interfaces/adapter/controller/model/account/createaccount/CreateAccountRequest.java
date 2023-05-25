package io.pismo.transactions.interfaces.adapter.controller.model.account.createaccount;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@Builder
@RequiredArgsConstructor
public final class CreateAccountRequest {

    @NotBlank
    private final Integer documentNumber;

}
