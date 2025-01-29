package com.bardzinski.com.bardzinski.lsa.presenter;

import com.bardzinski.com.bardzinski.lsa.internals.NoteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.server.reactive.ReactorHttpHandlerAdapter;
import org.springframework.web.reactive.function.server.RouterFunctions;
import reactor.netty.http.server.HttpServer;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RequestPredicates.contentType;

public class LsaServer {
    private final Logger logger = LoggerFactory.getLogger(LsaServer.class);


    public void start() {
        final var noteHandler = new NoteHandler(new NoteRepository());


        final var route = RouterFunctions.route()
                .path(NoteHandler.PATH, builder -> builder
                        .GET("", accept(APPLICATION_JSON), noteHandler::all)
                        .GET("/{id}", accept(APPLICATION_JSON), noteHandler::get)
                        .POST("", contentType(APPLICATION_JSON), noteHandler::createNote)
                ).build();

        final var httpHandler = RouterFunctions.toHttpHandler(route);
        final var adapter = new ReactorHttpHandlerAdapter(httpHandler);
        final var server = HttpServer
                .create()
                .host("localhost")
                .port(8080)
                .handle(adapter)
                .bindNow();
        logger.info("server started localhost:8080");
        System.out.println("Press enter to stop");
        readLine();
        server.disposeNow();
    }

    private static void readLine() {
        try {
            //noinspection ResultOfMethodCallIgnored
            System.in.read();
        } catch (Exception e) {
        }
    }
}
