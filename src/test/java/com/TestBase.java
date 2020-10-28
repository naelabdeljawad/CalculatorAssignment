package com;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class TestBase {
    public FluentWait<WebDriver> wait;
    public WebDriver chromeDriver;

    protected TestBase() {
        createDriver();
    }

    public WebDriver createDriver() {
        try {
            this.chromeDriver = WebDriverFactory.createChromeDriver();
            this.wait = new FluentWait<>(chromeDriver).withTimeout(Duration.ofSeconds(5))
                    .ignoring(StaleElementReferenceException.class).pollingEvery(Duration.ofSeconds(2));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void closeDriver() {
        try {
            WebDriverFactory.closeDriver();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
