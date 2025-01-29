package com.bardzinski.com.bardzinski.lsa.domain;


//trying to avoid Lombok annotations
public record Note(Long id, String title, String content){

    public static NoteBuilder builder() {
        return new NoteBuilder();
    }

    public NoteBuilder toBuilder(){
        return new NoteBuilder().id(id).title(title).content(content);
    }

    public static class NoteBuilder {
        private Long id;
        private String title;
        private String content;

        public NoteBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public NoteBuilder title(String title) {
            this.title = title;
            return this;
        }

        public NoteBuilder content(String content) {
            this.content = content;
            return this;
        }
        public Note build(){
            return new Note(id, title, content);
        }
    }
}
