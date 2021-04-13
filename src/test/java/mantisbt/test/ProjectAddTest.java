package mantisbt.test;

import mantisbt.model.Project;
import org.testng.annotations.Test;

import java.time.Instant;

public class ProjectAddTest extends TestBase {

    @Test
    public void testProjectAdd() {
        app.session().login("administrator", "root");
        app.project().openProjectsBoard();
        app.project().create_project(new Project().withName("Project " + Instant.now().getEpochSecond())
                .withDescription("Description " + Instant.now()));
        System.out.println(app.project().getProjectsList());
    }
}
