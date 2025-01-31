package ru.bms.swallow.service;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import ru.bms.swallow.dto.SimpleResponse;

@Service
public interface OrderService {
    Mono<SimpleResponse> createOrder();
}
