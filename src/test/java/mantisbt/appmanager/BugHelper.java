package mantisbt.appmanager;

import mantisbt.model.BugReport;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BugHelper {
    private WebDriver wd;

    public BugHelper(WebDriver wd) {
        this.wd = wd;
    }
    public void createBugReport(BugReport bug) {
        if (wd.findElements(By.cssSelector("div#select-project-div form#select-project-form input[type=submit]")).size() > 0) {
            wd.findElement(By.cssSelector("div#select-project-div form#select-project-form input[type=submit]")).click();
        }
        wd.findElement(By.cssSelector("div.page-content input#summary")).sendKeys(bug.getTitle());
        wd.findElement(By.cssSelector("div.page-content textarea#description")).sendKeys(bug.getDescription());

        //WebElement box = wd.findElement(By.cssSelector("div.page-content input[name=max_file_size]"));

        WebElement box = wd.findElement(By.cssSelector("div.page-content input[name=max_file_size]"));
        ((JavascriptExecutor) wd).executeScript("arguments[0].style='none';", box);
        ((JavascriptExecutor) wd).executeScript("arguments[0].setAttribute('type', 'file;');", box);
        //((JavascriptExecutor) wd).executeScript("arguments[0].value='"+bug.getFile().getAbsolutePath()+"';", box);
        box.sendKeys(bug.getFile().getAbsolutePath());
        //((JavascriptExecutor) wd).executeScript("arguments[0].setAttribute('value','"+bug.getFile().getAbsolutePath()+"')", box);
        //((JavascriptExecutor) wd).executeScript("arguments[0].setAttribute('type', 'text');", box);
        //box.sendKeys(bug.getFile().getAbsolutePath());
        //wd.findElement(By.cssSelector("div.page-content div.dropzone.center.dz-clickable")).sendKeys(bug.getFile().getAbsolutePath());
//        WebElement box = wd.findElement(By.xpath("//div[@class='page-content']//tr[11]//td//input"));
//        ((JavascriptExecutor) wd).executeScript("arguments[0].setAttribute('type', 'file');", box);
//        box.clear();
//        box.sendKeys(bug.getFile().getAbsolutePath());
        wd.findElement(By.cssSelector("div.page-content input[type=submit]")).click();
    }

}
