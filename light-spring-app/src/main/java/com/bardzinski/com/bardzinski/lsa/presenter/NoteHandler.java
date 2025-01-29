package com.bardzinski.com.bardzinski.lsa.presenter;

import com.bardzinski.com.bardzinski.lsa.domain.Note;
import com.bardzinski.com.bardzinski.lsa.internals.NoteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;

public class NoteHandler {
    private final Logger logger = LoggerFactory.getLogger(NoteHandler.class);

    public final static String PATH = "/notes";
    private final NoteRepository noteRepository;

    public NoteHandler(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public Mono<ServerResponse> all(ServerRequest request) {
        Flux<Note> data = this.noteRepository.findAll();
        return ResponseMapper.collection(data, Note.class);
    }

    public Mono<ServerResponse> get(ServerRequest request) {
        Mono<Note> note = Mono.empty();
        String stringId = request.pathVariable("id");
        try {
            Long id = Long.valueOf(stringId);
            note = noteRepository.findById(id);
        } catch (NumberFormatException nex) {
            logger.error("Invalid note ID = ", stringId);
        }

        return ResponseMapper.bodyOrNotFound(note);
    }

    public Mono<ServerResponse> createNote(ServerRequest request) {
        Mono<Note> note = request.bodyToMono(Note.class);
        Mono<Note> savedNote = note.flatMap(this.noteRepository::createNote);

        return savedNote.flatMap(saved -> ServerResponse.created(URI.create(PATH + "/" + saved.id())).build());
    }
}
