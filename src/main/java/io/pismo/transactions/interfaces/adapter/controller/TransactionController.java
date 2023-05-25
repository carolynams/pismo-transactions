package io.pismo.transactions.interfaces.adapter.controller;

import io.pismo.transactions.interfaces.adapter.controller.model.transaction.TransactionRequest;
import io.pismo.transactions.interfaces.adapter.controller.model.transaction.TransactionResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseStatus;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@Validated
public interface TransactionController {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create transaction.", description = "This endpoint provides a way to create a transaction.",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Created transaction.",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = TransactionResponse.class))),
                    @ApiResponse(responseCode = "400", description = "Bad request.",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Exception.class))),
                    @ApiResponse(responseCode = "404", description = "Not found.",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Exception.class))),
                    @ApiResponse(responseCode = "422", description = "Unprocessable Entity.",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Exception.class))),
                    @ApiResponse(responseCode = "500", description = "Internal Server Error.",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Exception.class)))
            })
    Mono<TransactionResponse> createTransaction(@RequestHeader("X-Request-ID") final String requestId,
                                                @RequestBody @Valid final TransactionRequest transactionRequest);

}
