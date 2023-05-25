package io.pismo.transactions.entity;

import lombok.*;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.UUID;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Transaction {

    @EqualsAndHashCode.Include
    private UUID id;

    private UUID accountId;
    private Integer operationType;
    private BigDecimal amount;
    private ZonedDateTime eventDate;
}
