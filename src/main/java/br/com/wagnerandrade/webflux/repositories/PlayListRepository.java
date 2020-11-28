package br.com.wagnerandrade.webflux.repositories;

import br.com.wagnerandrade.webflux.documents.PlayList;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayListRepository extends ReactiveMongoRepository<PlayList, String> {
}
