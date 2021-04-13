package mantisbt.test;

import mantisbt.model.BugReport;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Instant;

public class BugReportTest extends TestBase {

    @Test
    public void testBugReport() {
        app.session().login("lukasz", "luk");
        File photo = new File("src/test/resources/ok.jpeg");
        BugReport bugReport = new BugReport().withTitle("Title " + Instant.now().getEpochSecond())
                .withDescription("Description " + Instant.now()).withFile(photo);
        app.navigation().openBugReportPage();
        app.project().createBugReport(bugReport);
    }

    @Test(enabled = false)
    public void testPath() {
        File cDir = new File(".");
        System.out.println(cDir.getAbsolutePath());
        File photo = new File("src/test/resources/ok.jpeg");
        System.out.println(photo.getAbsolutePath());
        System.out.println(photo.exists());
    }

}
