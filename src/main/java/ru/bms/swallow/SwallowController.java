package ru.bms.swallow;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import ru.bms.swallow.data.Player;
import ru.bms.swallow.data.PlayerRepository;

@RestController
public class SwallowController {
    @Autowired
    private PlayerRepository playerRepository;

    @GetMapping("hello")
    public Mono<HelloResponse> hello() {
        HelloResponse message = HelloResponse.builder()
                .message("Hello World")
                .build();
        return Mono.just(message);
    }

    @GetMapping("ping")
    public Mono<SimpleResponse> ping() {
        Player player = new Player();
        player.setName("Maru");
        return playerRepository.save(player)
                .map(p ->  SimpleResponse.builder()
                        .message("Ping")
                        .build());
    }
}
