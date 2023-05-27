package io.pismo.transactions.interfaces.adapter.gateway.database;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TypeAlias("transactions")
@Document(collection = "transactions")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class TransactionData {

    @Id
    @EqualsAndHashCode.Include
    private ObjectId id;
    private String accountId;
    private Integer operationType;
    private BigDecimal amount;
    private LocalDateTime eventDate;
}