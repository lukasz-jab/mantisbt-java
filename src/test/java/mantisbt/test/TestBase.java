package mantisbt.test;

import mantisbt.appmanager.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;

public class TestBase {
    protected final ApplicationManager app = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));

    @BeforeMethod
    public void setUp() throws IOException {
        app.init();
    }

    @AfterMethod
    public void tearDown() {
        app.stop();
    }
}
