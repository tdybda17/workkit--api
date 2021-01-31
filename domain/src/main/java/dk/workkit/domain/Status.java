package dk.workkit.domain;

import java.time.LocalDateTime;

public class Status implements Model {
    private final String id;
    private final String key;
    private final String name;
    private final LocalDateTime created;
    private final User createdBy;

    public Status(
            String id,
            String key,
            String name,
            LocalDateTime created,
            User createdBy) {
        this.id = id;
        this.key = key;
        this.name = name;
        this.created = created;
        this.createdBy = createdBy;
    }

    public String getKey() {
        return key;
    }

    public String getName() {
        return name;
    }

    @Override
    public String getId() {
        return id;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public static class StatusBuilder {
        private String id;
        private String key;
        private String name;
        private LocalDateTime created;
        private User createdBy;

        public StatusBuilder setId(String id) {
            this.id = id;
            return this;
        }

        public StatusBuilder setKey(String key) {
            this.key = key;
            return this;
        }

        public StatusBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public StatusBuilder setCreated(LocalDateTime created) {
            this.created = created;
            return this;
        }

        public StatusBuilder setCreatedBy(User createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        public Status build() {
            return new Status(
                    id,
                    key,
                    name,
                    created,
                    createdBy
            );
        }
    }
}
