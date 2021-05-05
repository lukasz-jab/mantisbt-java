package mantisbt.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class NavigationHelper {
    private WebDriver wd;
    private Properties properties;

    public NavigationHelper(WebDriver wd, Properties properties) {
        this.wd = wd;
        this.properties = properties;
    }

    public void openHome() {
        wd.get(properties.getProperty("web.baseUrl"));
    }

    public void openBugReportPage() {
        wd.findElement(By.cssSelector(("div#sidebar a[href$='bug_report_page.php']"))).click();
    }
}
