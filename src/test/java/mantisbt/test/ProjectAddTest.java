package mantisbt.test;

import org.testng.annotations.Test;

public class ProjectAddTest extends TestBase {

    @Test
    public void testProjectAdd() {
        app.project().openProjectsBoard();
        //app.project().create_project(new Project("Java Projekt"));
        System.out.println(app.project().getProjectsList());
    }
}
