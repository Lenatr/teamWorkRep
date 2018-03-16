package site.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper extends HelperBase {

    public SessionHelper(WebDriver wd) {
        super(wd);
    }

    public void login(String user, String password) {
        type(By.cssSelector("input#username"), user);
        type(By.cssSelector("input#password"), password);
        click(By.cssSelector("button#loginSubmit"));

    }
}
