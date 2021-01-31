package dk.workkit.domain;

import java.time.LocalDateTime;
import java.util.Set;

public class Project implements Model {
    private final String id;
    private final String initials;
    private final String name;
    private final String key;
    private final Status status;
    private final Employee owner;
    private final Set<Employee> members;
    private final LocalDateTime created;
    private final LocalDateTime modified;
    private final User createdBy;

    public Project(
            String id,
            String initials,
            String name,
            String key,
            Status status,
            Employee owner,
            Set<Employee> members,
            LocalDateTime created,
            LocalDateTime modified,
            User createdBy) {
        this.id = id;
        this.initials = initials;
        this.name = name;
        this.key = key;
        this.status = status;
        this.owner = owner;
        this.members = members;
        this.created = created;
        this.modified = modified;
        this.createdBy = createdBy;
    }

    @Override
    public String getId() {
        return id;
    }

    public String getInitials() {
        return initials;
    }

    public String getName() {
        return name;
    }

    public String getKey() {
        return key;
    }

    public Status getStatus() {
        return status;
    }

    public Employee getOwner() {
        return owner;
    }

    public Set<Employee> getMembers() {
        return members;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public LocalDateTime getModified() {
        return modified;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public static class ProjectBuilder {
        private String id;
        private String initials;
        private String name;
        private String key;
        private Status status;
        private Employee owner;
        private Set<Employee> members;
        private LocalDateTime created;
        private LocalDateTime modified;
        private User createdBy;

        public ProjectBuilder setId(String id) {
            this.id = id;
            return this;
        }

        public ProjectBuilder setInitials(String initials) {
            this.initials = initials;
            return this;
        }

        public ProjectBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public ProjectBuilder setKey(String key) {
            this.key = key;
            return this;
        }

        public ProjectBuilder setStatus(Status status) {
            this.status = status;
            return this;
        }

        public ProjectBuilder setOwner(Employee owner) {
            this.owner = owner;
            return this;
        }

        public ProjectBuilder setMembers(Set<Employee> members) {
            this.members = members;
            return this;
        }

        public ProjectBuilder setCreated(LocalDateTime created) {
            this.created = created;
            return this;
        }

        public ProjectBuilder setModified(LocalDateTime modified) {
            this.modified = modified;
            return this;
        }

        public ProjectBuilder setCreatedBy(User createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        public Project build() {
            return new Project(
                    id,
                    initials,
                    name,
                    key,
                    status,
                    owner,
                    members,
                    created,
                    modified,
                    createdBy
            );
        }
    }
}
