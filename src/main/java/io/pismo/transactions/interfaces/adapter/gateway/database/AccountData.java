package io.pismo.transactions.interfaces.adapter.gateway.database;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TypeAlias("accounts")
@Document(collection = "accounts")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class AccountData {

    @Id
    @EqualsAndHashCode.Include
    private ObjectId id;

    private String documentNumber;

}