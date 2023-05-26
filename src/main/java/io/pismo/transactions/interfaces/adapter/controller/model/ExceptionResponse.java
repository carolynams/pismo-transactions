package io.pismo.transactions.interfaces.adapter.controller.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ExceptionResponse {

    private Integer status;
    private String message;

}
