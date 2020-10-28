package com.definitions;

import com.TestBase;
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
        getCurrentStep().log(Status.INFO, "");
        calculatorPage = new CalculatorPage(chromeDriver);
        Assert.assertTrue(calculatorPage.openCalculator(), "Calculator is not open!");
    }

    @Then("the calculated result is {string}")
    public void the_calculated_result_is(String result) {
        Assert.assertEquals(calculatorPage.getMathematicalFormulaResult(), result, "Results are not equal!");
        Assert.assertTrue(calculatorPage.clickClear());
    }

    @Given("I enter {string} into the calculator")
    public void i_enter_into_the_calculator(String formula) {
        Assert.assertTrue(calculatorPage.setMathematicalFormula(formula), "Formula is not set!");
    }

    @Given("I click on calculate button")
    public void i_click_on_calculate_button() {
        Assert.assertTrue(calculatorPage.clickCalculate(), "Calculate button is not clicked!");
    }

    @Then("There are {int} formulas in the calculator history")
    public void there_are_formulas_in_the_calculator_history(Integer historyCount) {
        Assert.assertEquals(Integer.valueOf(calculatorPage.getCalculatorHistory()), historyCount, "Calculator history is wrong!");
    }

    @Given("I close the calculator")
    public void i_close_the_calculator() {
        closeDriver();
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
