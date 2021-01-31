package dk.workkit.database.databases;

import dk.workkit.domain.Project;
import dk.workkit.repositories.ProjectRepository;

import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;

public class ProjectDatabase implements ProjectRepository {

    @Override
    public Project save(Project project) {
        return null;
    }

    @Override
    public Project delete(Project project) {
        return null;
    }

    @Override
    public Project delete(long id) {
        return null;
    }

    @Override
    public Project get(long id) {
        return null;
    }

    @Override
    public Project update(long id, Map<String, String> fields) {
        return null;
    }

    @Override
    public Set<Project> filter(Predicate<Project> query) {
        return null;
    }
}
