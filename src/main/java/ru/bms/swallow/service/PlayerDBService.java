package ru.bms.swallow.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import ru.bms.swallow.data.Player;
import ru.bms.swallow.data.PlayerRepository;

@Service
public class PlayerDBService implements PlayerService {
    @Autowired
    private PlayerRepository playerRepository;

    @Override
    public Mono<Player> get(Integer id) {
        return playerRepository.findById(id);
    }
}
