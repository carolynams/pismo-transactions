package io.pismo.transactions.interfaces.adapter.gateway.database;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.ZonedDateTime;


@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "transactions")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class TransactionData {

    @Id
    @Column(name = "transaction_id")
    @EqualsAndHashCode.Include
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    private AccountData account;

    @Column(name = "operation_type_id")
    private Integer operationType;

    private BigDecimal amount;

    @Column(name = "event_date")
    private ZonedDateTime eventDate;
}
