package mantisbt.test;

import mantisbt.model.Project;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.util.Properties;

public class ProjectAddTest extends TestBase {

    @Test
    public void testProjectAdd() throws IOException {
        Properties properties = new Properties();
        String target = System.getProperty("target", "local");
        properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));

        app.session().login(properties.getProperty("web.adminLogin"), properties.getProperty("web.adminPassword"));
        app.project().openProjectsBoard();
        app.project().create_project(new Project().withName("Project " + Instant.now().getEpochSecond())
                .withDescription("Description " + Instant.now()));
        System.out.println(app.project().getProjectsList());
    }
}
