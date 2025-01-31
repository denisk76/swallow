package ru.bms.swallow.service;

import reactor.core.publisher.Mono;
import ru.bms.swallow.data.Player;

public interface PlayerService {
    Mono<Player> get(Integer id);
}
