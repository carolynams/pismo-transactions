package io.pismo.transactions.interfaces.adapter.controller;

import io.pismo.transactions.interfaces.adapter.controller.model.account.createaccount.CreateAccountRequest;
import io.pismo.transactions.interfaces.adapter.controller.model.account.createaccount.CreateAccountResponse;
import io.pismo.transactions.interfaces.adapter.controller.model.account.findaccount.FindAccountResponse;
import io.pismo.transactions.interfaces.adapter.controller.model.transaction.TransactionResponse;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@Validated
@Api(value = "AccountController", tags = "AccountController")
public interface AccountController {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create account.", description = "This endpoint provides a way to create a account.",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Created account.",
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
    Mono<CreateAccountResponse> createAccount(@RequestHeader("X-Request-ID") final String requestId,
                                              @RequestBody @Valid final CreateAccountRequest createAccountRequest);

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get account.", description = "This endpoint provides a way to get a account.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Created account.",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = TransactionResponse.class))),
                    @ApiResponse(responseCode = "400", description = "Bad request.",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Exception.class))),
                    @ApiResponse(responseCode = "404", description = "Not found.",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Exception.class))),
                    @ApiResponse(responseCode = "500", description = "Internal Server Error.",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Exception.class)))
            })
    Mono<FindAccountResponse> getAccounts(@RequestHeader("X-Request-ID") final String requestId,
                                          @RequestParam final String accountId);

}
