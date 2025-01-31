package ru.bms.swallow.data;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(transactionManager = "reactiveTransactionManager", rollbackFor = Exception.class)
public interface PlayerRepository extends R2dbcRepository/*ReactiveCrudRepository*/<Player, Integer> {
}
