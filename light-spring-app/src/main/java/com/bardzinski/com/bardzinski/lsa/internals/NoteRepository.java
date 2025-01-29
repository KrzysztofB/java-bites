package com.bardzinski.com.bardzinski.lsa.internals;

import com.bardzinski.com.bardzinski.lsa.domain.Note;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

//@Component
public class NoteRepository {

        private static final Map<Long, Note> DATA = new HashMap<>();
        private static long ID_COUNTER = 1L;

        static {
            Stream.of("First Post", "Second Post")
                    .forEach((java.lang.String title) -> {
                                long id = ID_COUNTER++;
                                DATA.put(id, Note.builder().id(id).title(title).content("content of " + title).build());
                            }
                    );
        }

        public Flux<Note> findAll() {
            return Flux.fromIterable(DATA.values());
        }

        public Mono<Note> findById(Long id) {
            return Mono.justOrEmpty(DATA.get(id));
        }

        public Mono<Note> createNote(Note post) {
            long id = ID_COUNTER++;
            var toSave = post.toBuilder().id(id).build();
            DATA.put(id, toSave);
            return Mono.just(toSave);
        }
    }
