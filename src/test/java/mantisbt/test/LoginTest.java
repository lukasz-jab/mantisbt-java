package mantisbt.test;

import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @Test(enabled = true)
    public void testLogin() {
        app.session().login("lukasz", "luk");
    }
}
