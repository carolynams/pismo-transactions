package io.pismo.transactions.interfaces.adapter.gateway.database;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class AccountData {

    @Id
    @Column(name = "id")
    @EqualsAndHashCode.Include
    private String id;

    @Column(name = "document_number")
    private Integer documentNumber;

    @OneToMany(mappedBy = "account", fetch = FetchType.LAZY)
    private List<TransactionData> transactions;
}
