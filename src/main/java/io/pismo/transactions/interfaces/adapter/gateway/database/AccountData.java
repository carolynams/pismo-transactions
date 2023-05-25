package io.pismo.transactions.interfaces.adapter.gateway.database;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "accounts")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class AccountData {

    @Id
    @Column(name = "account_id")
    @EqualsAndHashCode.Include
    private String id;

    @Column(name = "document_number")
    private Integer documentNumber;

    @OneToMany(mappedBy = "account", fetch = FetchType.LAZY)
    private List<TransactionData> transactions;
}
