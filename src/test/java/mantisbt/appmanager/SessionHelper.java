package mantisbt.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Properties;

public class SessionHelper {
    private WebDriver wd;
    private WebDriverWait wait;

    public SessionHelper(WebDriver wd, WebDriverWait wait) {
        this.wd = wd;
        this.wait = wait;
    }

    public void login(String username, String password) {
        wd.findElement(By.cssSelector("input[name='username']")).sendKeys(username);
        wd.findElement(By.cssSelector("input[type='submit']")).click();
        wd.findElement(By.cssSelector("input[name='password']")).sendKeys(password);
        wd.findElement(By.cssSelector("input[type='submit']")).click();
    }

    public void logout() {
        wd.findElement(By.cssSelector("a.dropdown-toggle span.user-info")).click();
        wd.findElement(By.cssSelector("a[href='/mantisbt-2.25.0/logout_page.php']")).click();
        wait.until(ExpectedConditions.urlContains("/login_page.php"));
    }
}
