package mantisbt.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper {
    private WebDriver wd;

    public NavigationHelper(WebDriver wd) {
        this.wd = wd;
    }

    public void openHome() {
        wd.get("http://127.0.0.1/mantisbt-2.25.0/");
    }

    public void openBugReportPage() {
        wd.findElement(By.cssSelector(("div#sidebar a[href$='bug_report_page.php']"))).click();
    }
}
