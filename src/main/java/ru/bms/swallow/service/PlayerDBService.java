package ru.bms.swallow.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.bms.swallow.data.Player;
import ru.bms.swallow.data.PlayerRepository;

@Service
@Transactional
public class PlayerDBService implements PlayerService {
    @Autowired
    private PlayerRepository playerRepository;

    @Override
    public Mono<Player> get(Integer id) {
        return playerRepository.findById(id);
    }

    @Override
    public Flux<Player> getAll() {
        return playerRepository.findAll();
    }

    @Override
    public Mono<Player> save(Player player) {
        return playerRepository.save(player);
    }
}
