package dk.workkit.tools;

import dk.workkit.domain.Project;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KeyGeneratorTest {

    @Test
    void testGeyKen() {
        Project project = new Project.ProjectBuilder()
                .setInitials("ABC")
                .setName("AB")
                .build();
        String key = KeyGenerator.genKey(Project.class, project);
        assertTrue(key.contains("PRJ"));
    }
}