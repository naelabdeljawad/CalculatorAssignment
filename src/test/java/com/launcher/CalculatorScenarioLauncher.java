package com.launcher;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/features/CalculatorScenario2.feature", plugin = {"pretty",
        "html:target/cucumber/CalculatorScenario2.html",
        "rerun:target/cucumber/CalculatorScenario2.txt",
        "json:target/cucumber/CalculatorScenario2.json",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        glue = {"com.definitions"})
public class CalculatorScenarioLauncher extends AbstractTestNGCucumberTests {
}
