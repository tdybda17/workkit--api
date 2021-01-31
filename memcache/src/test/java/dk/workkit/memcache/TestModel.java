package dk.workkit.memcache;

import dk.workkit.domain.Model;

import java.util.Objects;

public class TestModel implements Model {
    String id;

    public TestModel(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestModel testModel = (TestModel) o;
        return Objects.equals(id, testModel.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
