package io.pismo.transactions.entity;

import lombok.*;

import javax.persistence.Entity;
import java.util.UUID;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Account {

    @EqualsAndHashCode.Include
    private UUID id;

    private Integer documentNumber;
}
