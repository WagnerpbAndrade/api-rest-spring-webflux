package br.com.wagnerandrade.webflux;

import br.com.wagnerandrade.webflux.documents.PlayList;
import br.com.wagnerandrade.webflux.services.PlayListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

//@Component
public class PlayListHandler {

    @Autowired
    @Qualifier("playListServiceImpl")
    private PlayListService playListService;

    public Mono<ServerResponse> findAll(ServerRequest request) {
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(this.playListService.findAll(), PlayList.class);
    }

    public Mono<ServerResponse> findById(ServerRequest request) {
        String id = request.pathVariable("id");
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(this.playListService.findById(id), PlayList.class);
    }

    public Mono<ServerResponse> save(ServerRequest request) {
        var playlist = request.bodyToMono(PlayList.class);
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(playlist.flatMap(this.playListService::save), PlayList.class);
    }
}
