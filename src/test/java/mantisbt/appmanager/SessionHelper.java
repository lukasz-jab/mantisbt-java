package mantisbt.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper {
    private WebDriver wd;

    public SessionHelper(WebDriver wd) {
        this.wd = wd;
    }

    public void login(String username, String password) {
        wd.get("http://127.0.0.1/mantisbt-2.25.0/");
        wd.findElement(By.cssSelector("input[name='username']")).sendKeys(username);
        wd.findElement(By.cssSelector("input[type='submit']")).click();
        wd.findElement(By.cssSelector("input[name='password']")).sendKeys(password);
        wd.findElement(By.cssSelector("input[type='submit']")).click();
    }
}
