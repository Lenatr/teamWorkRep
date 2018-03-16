package site.tests;

import org.testng.annotations.Test;

public class LoginTests extends TestBase {
    @Test(priority = 2)
    public  void loginTestNotvalid(){
        app.getSessionHelper().login("hjkjkjl", "khkhk");
    }

    @Test(enabled = false)
    public  void loginTest(){
        app.getSessionHelper().login("hjkjkjl", "khkhk");
    }


}
