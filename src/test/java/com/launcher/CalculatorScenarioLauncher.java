package com.launcher;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/features/CalculatorScenario.feature", plugin = {"pretty",
        "html:target/cucumber/CalculatorScenario.html",
        "rerun:target/cucumber/CalculatorScenario.txt",
        "json:target/cucumber/CalculatorScenario.json",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        glue = {"com.definitions"})
public class CalculatorScenarioLauncher extends AbstractTestNGCucumberTests {
}
