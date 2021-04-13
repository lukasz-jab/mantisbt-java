package mantisbt.appmanager;

import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Hashtable;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    WebDriver wd;
    String browser;
    SessionHelper session;
    NavigationHelper navigation;
    ProjectHelper project;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public void init() {
        if (browser.equals("firefox")) {
            wd = new FirefoxDriver();
            System.out.println(((HasCapabilities) wd).getCapabilities());
        } else if (browser.equals("chrome")) {
            wd = new ChromeDriver();
            System.out.println(((HasCapabilities) wd).getCapabilities());
        } else {
            System.out.println("Unrecognized browser");
        }
        wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        wd.manage().window().maximize();
        session = new SessionHelper(wd);
        navigation = new NavigationHelper(wd);
        project = new ProjectHelper(wd);
//        session.login("administrator", "root");
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
}



