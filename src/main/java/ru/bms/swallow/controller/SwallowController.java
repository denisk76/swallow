package ru.bms.swallow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.bms.swallow.dto.HelloResponse;
import ru.bms.swallow.dto.SimpleResponse;
import ru.bms.swallow.data.Player;
import ru.bms.swallow.data.PlayerRepository;
import ru.bms.swallow.service.OrderService;
import ru.bms.swallow.service.PlayerService;

@RestController
public class SwallowController {
    @Autowired
    private PlayerService playerService;
    @Autowired
    private OrderService orderService;

    @GetMapping("hello")
    public Mono<HelloResponse> hello() {
        HelloResponse message = HelloResponse.builder()
                .message("Hello World")
                .build();
        return Mono.just(message);
    }

    @GetMapping("all")
    public Flux<Player> getPlayers() {
        return playerService.getAll();
    }

    @GetMapping("order")
    public Mono<SimpleResponse> order() {
        return orderService.createOrder();
    }

    @GetMapping("ping")
    public Mono<SimpleResponse> ping() {
        Player player = new Player();
        player.setName("Maru");
        return playerService.save(player)
                .map(p ->  SimpleResponse.builder()
                        .message("Ping")
                        .build());
    }


}
