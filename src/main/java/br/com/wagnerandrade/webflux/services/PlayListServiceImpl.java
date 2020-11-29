package br.com.wagnerandrade.webflux.services;

import br.com.wagnerandrade.webflux.documents.PlayList;
import br.com.wagnerandrade.webflux.repositories.PlayListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PlayListServiceImpl implements PlayListService{

    @Autowired
    private PlayListRepository repository;

    @Override
    public Flux<PlayList> findAll() {
        return this.repository.findAll();
    }

    @Override
    public Mono<PlayList> findById(String id) {
        return this.repository.findById(id);
    }

    @Override
    public Mono<PlayList> save(PlayList playList) {
        return this.repository.save(playList);
    }
}
