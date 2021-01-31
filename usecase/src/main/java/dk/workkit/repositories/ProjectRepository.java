package dk.workkit.repositories;

import dk.workkit.domain.Project;

import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;

public interface ProjectRepository {
    Project save(Project project);
    Project delete(Project project);
    Project delete(long id);
    Project get(long id);
    Project update(long id, Map<String, String> fields);
    Set<Project> filter(Predicate<Project> query);
}
