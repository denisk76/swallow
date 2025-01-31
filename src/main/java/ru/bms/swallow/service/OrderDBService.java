package ru.bms.swallow.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.reactive.TransactionalOperator;
import reactor.core.publisher.Mono;
import ru.bms.swallow.data.Player;
import ru.bms.swallow.dto.SimpleResponse;

@Service
@Transactional(transactionManager = "reactiveTransactionManager", rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
public class OrderDBService implements OrderService {
    @Autowired
    private PlayerService playerService;
    @Autowired
    private TransactionalOperator transactionalOperator;

    @Override
    public Mono<SimpleResponse> createOrder() {
        Player one = Player.builder()
                .name("One")
                .build();
        Player two = Player.builder()
                .name("Two")
                .build();
        Player three = Player.builder()
                .name("Three")
                .build();
        return playerService.save(one)
                .flatMap(p -> playerService.save(two))
                .flatMap(p -> {
                    playerService.save(three);
                    throw new NullPointerException("Booms");
//                    return playerService.save(three);
                })
                .map(s -> SimpleResponse.builder()
                        .message("Success")
                        .build())
                .onErrorReturn(SimpleResponse.builder()
                        .message("Error")
                        .build())
                .as(transactionalOperator::transactional)
                ;
    }

}
