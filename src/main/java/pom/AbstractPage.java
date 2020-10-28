package pom;

import com.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {

    public WebDriverWait wait;
    protected WebDriver chromeDriver;

    protected AbstractPage(WebDriver webDriver) {
        this.chromeDriver = webDriver;
        this.wait = new WebDriverWait(webDriver, 30);
    }

    public WebDriver getWebDriver() {
        return chromeDriver;
    }

    public abstract boolean isPageDisplayed();
}
