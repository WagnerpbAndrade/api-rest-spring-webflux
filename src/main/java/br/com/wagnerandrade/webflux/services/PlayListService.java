package br.com.wagnerandrade.webflux.services;

import br.com.wagnerandrade.webflux.documents.PlayList;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PlayListService {

    Flux<PlayList> findAll();
    Mono<PlayList> findById(String id);
    Mono<PlayList> save(PlayList playList);
}
