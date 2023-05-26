package io.pismo.transactions.usecases.provider;

import io.pismo.transactions.interfaces.adapter.gateway.database.TransactionData;
import io.pismo.transactions.interfaces.adapter.gateway.database.repository.TransactionRepository;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface TransactionDatabaseProvider extends TransactionRepository, R2dbcRepository<TransactionData, String> {

    @Override
    default Mono<TransactionData> insert(final TransactionData transactionData) {
        return this.save(transactionData);
    }
}
