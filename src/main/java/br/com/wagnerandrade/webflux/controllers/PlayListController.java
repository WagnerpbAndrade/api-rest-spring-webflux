package br.com.wagnerandrade.webflux.controllers;

import br.com.wagnerandrade.webflux.documents.PlayList;
import br.com.wagnerandrade.webflux.services.PlayListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

import java.awt.*;
import java.time.Duration;

@RestController
@RequestMapping(value = "/api/v1/playlist")
public class PlayListController {

    @Autowired
    private PlayListService service;

    @GetMapping
    public Flux<PlayList> getPlaylists() {
        return this.service.findAll();
    }

    @GetMapping(value = "/{id}")
    public Mono<PlayList> getPlaylistId(@PathVariable String id) {
        return this.service.findById(id);
    }

    @PostMapping
    public Mono<PlayList> save(@RequestBody PlayList playList) {
        return this.service.save(playList);
    }

    @GetMapping(value = "/events", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Tuple2<Long, PlayList>> getPlaylistByEvents() {
        Flux<Long> interval = Flux.interval(Duration.ofSeconds(10));
        Flux<PlayList> events = this.service.findAll();
        System.out.println("Passou aqui events");
        return Flux.zip(interval, events);
    }
}
