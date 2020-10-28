package pom;

import com.PropertiesReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;

public class CalculatorPage extends AbstractPage {

    @FindBy(id = "input")
    @CacheLookup
    private WebElement input;

    @FindBy(id = "result")
    @CacheLookup
    private WebElement result;

    @FindBy(id = "BtnCalc")
    @CacheLookup
    private WebElement calculate;

    @FindBy(id = "BtnClear")
    @CacheLookup
    private WebElement clear;

    public CalculatorPage(WebDriver chromeDriver) {
        super(chromeDriver);
        PageFactory.initElements(chromeDriver, this);
    }

    public boolean openCalculator() {
        try {
            chromeDriver.get(PropertiesReader.getInstance().getProperty("calculator.url"));
            chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            //Wait for calculator buttons to be displayed
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btns")));

            //Accept cookies
            acceptCookies();

            //Init page factory to load elements after accepting cookies to avoid stale elements exceptions
            PageFactory.initElements(chromeDriver, this);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private void acceptCookies() {
        chromeDriver.findElement(By.id("input")).click();
        WebElement accept = chromeDriver.findElement(By.name("cookies"));
        accept.click();
    }

    public boolean setMathematicalFormula(String formula) {
        try {
            input.sendKeys(formula);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public String getMathematicalFormulaResult() {
        try {
            //This elements is dynamic and it adds a new element to the results list after each calculation
            return chromeDriver.findElements(By.cssSelector("#histframe p.r")).get(0).getAttribute("title");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public int getCalculatorHistory() {
        try {
            return chromeDriver.findElements(By.cssSelector("#histframe li")).size();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public boolean clickCalculate() {
        try {
            calculate.click();
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("loading")));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean clickClear() {
        try {
            clear.click();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean isPageDisplayed() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btns"))).isDisplayed();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
