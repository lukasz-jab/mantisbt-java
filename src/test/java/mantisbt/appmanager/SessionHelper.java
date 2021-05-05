package mantisbt.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class SessionHelper {
    private WebDriver wd;
    private Properties properties;

    public SessionHelper(WebDriver wd, Properties properties) {
        this.wd = wd;
        this.properties = properties;
    }

    public void login(String username, String password) {
        wd.get(properties.getProperty("web.baseUrl"));
        wd.findElement(By.cssSelector("input[name='username']")).sendKeys(username);
        wd.findElement(By.cssSelector("input[type='submit']")).click();
        wd.findElement(By.cssSelector("input[name='password']")).sendKeys(password);
        wd.findElement(By.cssSelector("input[type='submit']")).click();
    }
}
