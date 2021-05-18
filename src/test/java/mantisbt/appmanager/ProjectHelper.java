package mantisbt.appmanager;

import mantisbt.model.BugReport;
import mantisbt.model.Project;
import org.openqa.selenium.*;

import java.util.ArrayList;
import java.util.List;

public class ProjectHelper {
    private WebDriver wd;

    public ProjectHelper(WebDriver wd) {
        this.wd = wd;
    }

    public void openProjectsBoard() {
        wd.findElement(By.cssSelector("div#sidebar a[href='/mantisbt-2.25.0/manage_overview_page.php']")).click();
        wd.findElement(By.cssSelector("div.page-content a[href='/mantisbt-2.25.0/manage_proj_page.php']")).click();
    }

    public void create_project(Project project) {

        wd.findElement(By.cssSelector("form[action='manage_proj_create_page.php']")).click();
        wd.findElement(By.cssSelector("form#manage-project-create-form input#project-name")).sendKeys(project.getName());
        //wd.findElement(By.cssSelector("form#manage-project-create-form textarea#project-description"))
        //        .sendKeys(project.getDescription());
        wd.findElement(By.cssSelector("form#manage-project-create-form input[type=submit]")).click();
    }

    public List<Project> getProjectsList() {
        openProjectsBoard();
        List<Project> projects = new ArrayList<>();
        List<WebElement> webElProjects = new ArrayList<>();
        webElProjects = wd.findElements(By.cssSelector("div.col-md-12.col-xs-12 div.widget-body tbody tr td a"));
        for (WebElement project : webElProjects) {
            projects.add(new Project(project.getText(), Integer.parseInt(slice_start(project.getAttribute("href")
                    ,70))));
        }
        return projects;
    }

    public void deleteProject(Project project) {
        wd.findElement(By.cssSelector("a[href='manage_proj_edit_page.php?project_id=" + project.getId() + "]")).click();
        wd.findElement(By.cssSelector("form#project-delete-form input[type=submit]")).click();
        wd.findElement(By.cssSelector("form.center input[type=submit]")).click();
    }

    public String slice_start(String s, int startIndex) {
        if (startIndex < 0) startIndex = s.length() + startIndex;
        if (System.getProperty("target").equals("remote")) {
            startIndex = startIndex +3;
        }
        return s.substring(startIndex);
    }

}
