package com.bardzinski.com.bardzinski.lsa.presenter;

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_JSON;

public class ResponseMapper {

    static <T> Mono<ServerResponse>  bodyOrNotFound(Mono<T> optionalBodyResponse) {
        return optionalBodyResponse.flatMap( body -> ServerResponse.ok()
                .contentType(APPLICATION_JSON)
                .bodyValue(body))
                .switchIfEmpty(ServerResponse.notFound().build());
    }

    static <T> Mono<ServerResponse> collection(Flux<T> collection, Class<T> elementClass) {
        return ServerResponse.ok().contentType(APPLICATION_JSON).body(collection, elementClass);
    }
}
