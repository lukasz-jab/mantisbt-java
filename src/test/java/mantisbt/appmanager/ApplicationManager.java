package mantisbt.appmanager;

import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    WebDriver wd;
    String browser;
    SessionHelper session;
    NavigationHelper navigation;
    ProjectHelper project;
    BugHelper bugReport;
    Properties properties;
    WebDriverWait wait;

    public ApplicationManager(String browser) {
        this.browser = browser;
        properties = new Properties();
    }

    public void init() throws IOException {
        String target = System.getProperty("target", "local");
        properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));
        if ("".equals(properties.getProperty("selenium.server"))) {
            if (browser.equals("firefox")) {
                wd = new FirefoxDriver();
                System.out.println(((HasCapabilities) wd).getCapabilities());
            } else if (browser.equals("chrome")) {
                wd = new ChromeDriver();
                System.out.println(((HasCapabilities) wd).getCapabilities());
            } else {
                System.out.println("Unrecognized browser");
            }
        } else {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setBrowserName(browser);
            wd = new RemoteWebDriver(new URL(properties.getProperty("selenium.server")), capabilities);
        }
        wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        wait = new WebDriverWait(wd, 3);
        wd.manage().timeouts();
        wd.manage().window().maximize();
        session = new SessionHelper(wd, wait);
        navigation = new NavigationHelper(wd, properties);
        project = new ProjectHelper(wd);
        bugReport = new BugHelper(wd);
        wd.get(properties.getProperty("web.baseUrl"));
        //session.login("administrator", "root");
    }

    public void stop() {
        wd.quit();
        wd = null;
    }

    public SessionHelper session() {
        return session;
    }

    public NavigationHelper navigation() { return navigation; }

    public ProjectHelper project() {
        return project;
    }

    public BugHelper bugReport() { return bugReport; }

}




