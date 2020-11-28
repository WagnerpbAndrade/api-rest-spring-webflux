package br.com.wagnerandrade.webflux;

import br.com.wagnerandrade.webflux.documents.PlayList;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import br.com.wagnerandrade.webflux.repositories.PlayListRepository;

import java.util.UUID;

@Component
public class DummyData implements CommandLineRunner {

    private final PlayListRepository playListRepository;

    DummyData(PlayListRepository repository) {
        this.playListRepository = repository;
    }

    @Override
    public void run(String... args) throws Exception {
        this.playListRepository.deleteAll()
                .thenMany(
                        Flux.just("API REST Spring Boot", "Deploy de uma aplicação java no IBM Cloud",
                                "Java 8", "Github", "Spring Security", "Web Service RESTFULL", "Bean no Spring Framework")
                                .map(nome -> new PlayList(UUID.randomUUID().toString(), nome))
                                .flatMap(this.playListRepository::save)
                )
                .subscribe(System.out::println);
    }
}
