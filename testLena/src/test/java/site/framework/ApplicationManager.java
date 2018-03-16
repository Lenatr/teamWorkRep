package site.framework;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    private SessionHelper sessionHelper;
    private WebDriver wd;
    private String browser;

    public ApplicationManager(String browser) {

        this.browser = browser;

    }




    public void init() throws IOException {
//        String target =
//                System.getProperty("target", "local-addressbook");
//        Properties properties = new Properties();
//        properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));
//        // String browser = BrowserType.FIREFOX;

        if (browser.equals(BrowserType.FIREFOX)) {
            wd = new FirefoxDriver(new FirefoxOptions().setLegacy(true));
        } else if (browser.equals(BrowserType.CHROME)) {
            wd = new ChromeDriver();

        } else if (browser.equals(BrowserType.IE)) {
            wd = new InternetExplorerDriver();
        }

        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        openSite("http://mfc.voxme.com/Account/Login?ReturnUrl=%2F");
        wd.manage().window().fullscreen();
        sessionHelper = new SessionHelper(wd);
      //  sessionHelper.login("user", "secret");

    }

    public void stop() {
        wd.quit();
    }

    public void goToGroupsPage() {
        wd.findElement(By.linkText("groups")).click();
    }



    public void openSite(String url) {
        wd.get(url);
    }


    public SessionHelper getSessionHelper() {
        return sessionHelper;
    }
}
