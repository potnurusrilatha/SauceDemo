package com.saucedemo.cucumber.steps;

import com.saucedemo.pages.HomePage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class LoginStep {
	
	 com.saucedemo.utility.TestContext testContext;
	 HomePage sauPage;

	    public LoginStep(com.saucedemo.utility.TestContext context) {
	        testContext = context;
	        sauPage = testContext.getPageObjectManager().getsaucePage();

	    }
	@Given("^I am on sauce demo page$")
    public void iAmOnSaucedemoPage() {
    }

	    @When("^I login with credential \"([^\"]*)\" and \"([^\"]*)\"$")
	    public void i_login_with_credential(String username, String password) throws Throwable {
	    	sauPage.enterUsernameAndPassword(username, password);
	    }

    @And("^I click on Login button$")
    public void iClickOnLoginButton() throws InterruptedException {
    	sauPage.clickOnLogin();
    }


    @And("^I filter the products by Price \"([^\"]*)\"$")
    public void iFilterTheProductsByPrice(String selection) {
//        new ProductPage().selectingFromDropDown(selection);

    }

    @And("^I select cheapest & costliest products and add to basket$")
    public void iSelectCheapestCostliestProductsAndAddToBasket() throws InterruptedException {
//        new ProductPage().addingToCart();

    }

    @And("^I open shopping cart$")
    public void iOpenShoppingCart() {
//        new ProductPage().clickOnCart();
    }

    @And("^I go to checkout$")
    public void iGoToCheckout() {
//        new CartPage().clickOnCheckOut();
    }

    @And("^I enter details firstname \"([^\"]*)\", lastName \"([^\"]*)\" and zipPostalCode \"([^\"]*)\"$")
    public void iEnterDetailsFirstnameLastNameAndZipPostalCode(String firstName, String lastName, String zipPostalCode) {
//        new CheckOutInformationPage().enteringTheDetails(firstName, lastName, zipPostalCode);
    }

    @And("^I click on continue button$")
    public void iClickOnContinueButton() {
//        new CheckOutInformationPage().clickOnContinue();
    }

    @And("^I click on finish button$")
    public void iClickOnFinishButton() {
//        new CheckOutOverViewPage().clickOnFinish();
    }

    @Then("^I should be able to see message 'Thank you for your order'$")
    public void iShouldBeAbleToSeeMessageThankYouForYourOrder() {
//        new CheckOutCompletePage().verifyingMessage();
    }

}
