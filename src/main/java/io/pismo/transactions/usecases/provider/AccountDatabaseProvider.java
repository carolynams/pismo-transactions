package io.pismo.transactions.usecases.provider;

import io.pismo.transactions.interfaces.adapter.gateway.database.AccountData;
import io.pismo.transactions.interfaces.adapter.gateway.database.repository.AccountRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface AccountDatabaseProvider extends AccountRepository, ReactiveMongoRepository<AccountData, String> {

    @Override
    default Mono<Boolean> existsAccountByDocumentNumber(final Integer documentNumber) {
        final var example = Example.of(AccountData.builder().documentNumber(documentNumber).build());
        return this.exists(example);
    }

}
