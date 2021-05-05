package mantisbt.test;

import mantisbt.appmanager.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Properties;

public class TestBase {
    protected final ApplicationManager app = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));

    Logger logger = LoggerFactory.getLogger(BugReportTest.class);
    Properties properties = new Properties();


    @BeforeSuite
    public void setUp() throws IOException {
        app.init();
        String target = System.getProperty("target", "local");
        properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        app.stop();
    }


    @BeforeMethod
    public void logTestStart(Method m, Object[] p) {
        logger.warn("Start test " + m.getName() + " with parameters " + Arrays.asList(p));
    }

    @AfterMethod(alwaysRun = true)
    public void logTestStop(Method m) {
        logger.warn("Stop test " + m.getName());

    }
}
