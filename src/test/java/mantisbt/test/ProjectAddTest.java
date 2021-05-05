package mantisbt.test;

import mantisbt.model.Project;
import org.testng.annotations.Test;
import java.time.Instant;

public class ProjectAddTest extends TestBase {

    @Test
    public void testProjectAdd() {
        app.session().login(properties.getProperty("web.adminLogin"), properties.getProperty("web.adminPassword"));
        app.project().openProjectsBoard();
        app.project().create_project(new Project().withName("Project " + Instant.now().getEpochSecond())
                .withDescription("Description " + Instant.now()));
        logger.warn(String.valueOf(app.project().getProjectsList()));
    }
}
