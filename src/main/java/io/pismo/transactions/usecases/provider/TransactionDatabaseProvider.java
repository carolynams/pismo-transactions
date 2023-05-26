package io.pismo.transactions.usecases.provider;

import io.pismo.transactions.interfaces.adapter.gateway.database.TransactionData;
import io.pismo.transactions.interfaces.adapter.gateway.database.repository.TransactionRepository;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionDatabaseProvider extends TransactionRepository, ReactiveMongoRepository<TransactionData, String> {
}
