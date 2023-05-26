package io.pismo.transactions.usecases.provider;

import io.pismo.transactions.interfaces.adapter.gateway.database.AccountData;
import io.pismo.transactions.interfaces.adapter.gateway.database.repository.AccountRepository;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface AccountDatabaseProvider extends AccountRepository, R2dbcRepository<AccountData, String> {

    @Override
    default Mono<AccountData> insert(final AccountData accountData) {
        return this.save(accountData);
    }


    @Query("SELECT CASE WHEN EXISTS (SELECT 1 FROM account_data ac " +
            "WHERE ac.document_number = :documentNumber) THEN TRUE ELSE FALSE END")
    Mono<Boolean> findByDocumentNumber(final Integer documentNumber);

}
