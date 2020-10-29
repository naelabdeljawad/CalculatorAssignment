package com.definitions;

import com.aventstack.extentreports.Status;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pom.CalculatorPage;

import static com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter.getCurrentStep;

public class CalculatorDefinitions extends TestBase {

    private CalculatorPage calculatorPage;

    @Given("I use the calculator")
    public void i_use_the_calculator() {
        calculatorPage = new CalculatorPage(chromeDriver);
        getCurrentStep().log(Status.INFO, "Opening calculator page...");
        Assert.assertTrue(calculatorPage.openCalculator(), "Calculator is not open!");
        getCurrentStep().log(Status.INFO, "Calculator page is open!");
    }

    @Then("the calculated result is {string}")
    public void the_calculated_result_is(String result) {
        String actualResult = calculatorPage.getMathematicalFormulaResult();
        getCurrentStep().log(Status.INFO, "Actual calculated result is ".concat(actualResult).concat(" and Expected result is ").concat(result));
        Assert.assertEquals(actualResult, result, "Results are not equal!");
        Assert.assertTrue(calculatorPage.clickClear());
    }

    @Given("I enter {string} into the calculator")
    public void i_enter_into_the_calculator(String formula) {
        getCurrentStep().log(Status.INFO, "Formula to enter is ".concat(formula));
        Assert.assertTrue(calculatorPage.setMathematicalFormula(formula), "Formula is not set!");
        getCurrentStep().log(Status.INFO, "Formula entered!");
    }

    @Given("I click on calculate button")
    public void i_click_on_calculate_button() {
        getCurrentStep().log(Status.INFO, "Clicking on calculate");
        Assert.assertTrue(calculatorPage.clickCalculate(), "Calculate button is not clicked!");
        getCurrentStep().log(Status.INFO, "Calculate clicked!");
    }

    @Then("There are {int} formulas in the calculator history")
    public void there_are_formulas_in_the_calculator_history(Integer historyCount) {
        int actualHistoryCount = calculatorPage.getCalculatorHistory();
        getCurrentStep().log(Status.INFO, "Actual history count is ".concat(String.valueOf(actualHistoryCount)).concat(" and Expected history is ").concat(String.valueOf(historyCount)));
        Assert.assertEquals(Integer.valueOf(actualHistoryCount), historyCount, "Calculator history is wrong!");
        getCurrentStep().log(Status.INFO, "Histories are equal!");
    }

    @Given("I close the calculator")
    public void i_close_the_calculator() {
        getCurrentStep().log(Status.INFO, "Closing chrome driver...");
        closeDriver();
        getCurrentStep().log(Status.INFO, "Chrome driver is closed!");
    }

    @When("I add {string}")
    public void i_add(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Given("I subtract {string}")
    public void i_subtract(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Given("I multiply by {string} factorial")
    public void i_multiply_by_factorial(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
