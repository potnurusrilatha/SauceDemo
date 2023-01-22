package com.saucedemo.cucumber.steps;

import com.saucedemo.pages.CartPage;
import com.saucedemo.pages.CheckOutCompletePage;
import com.saucedemo.pages.CheckOutInformationPage;
import com.saucedemo.pages.CheckOutOverViewPage;
import com.saucedemo.pages.HomePage;
import com.saucedemo.pages.ProductPage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginStep {
	@Given("^I am on saucedemo page$")
    public void iAmOnSaucedemoPage() {
    }

    @When("^I login with credential username \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void iLoginWithCredentialUsernameAndPassword(String username, String password) {
        new HomePage().enterUsernameAndPassword(username, password);
    }

    @And("^I click on Login button$")
    public void iClickOnLoginButton() throws InterruptedException {
        new HomePage().clickOnLogin();
    }


    @And("^I filter the products by Price \"([^\"]*)\"$")
    public void iFilterTheProductsByPrice(String selection) {
        new ProductPage().selectingFromDropDown(selection);

    }

    @And("^I select cheapest & costliest products and add to basket$")
    public void iSelectCheapestCostliestProductsAndAddToBasket() throws InterruptedException {
        new ProductPage().addingToCart();

    }

    @And("^I open shopping cart$")
    public void iOpenShoppingCart() {
        new ProductPage().clickOnCart();
    }

    @And("^I go to checkout$")
    public void iGoToCheckout() {
        new CartPage().clickOnCheckOut();
    }

    @And("^I enter details firstname \"([^\"]*)\", lastName \"([^\"]*)\" and zipPostalCode \"([^\"]*)\"$")
    public void iEnterDetailsFirstnameLastNameAndZipPostalCode(String firstName, String lastName, String zipPostalCode) {
        new CheckOutInformationPage().enteringTheDetails(firstName, lastName, zipPostalCode);
    }

    @And("^I click on continue button$")
    public void iClickOnContinueButton() {
        new CheckOutInformationPage().clickOnContinue();
    }

    @And("^I click on finish button$")
    public void iClickOnFinishButton() {
        new CheckOutOverViewPage().clickOnFinish();
    }

    @Then("^I should be able to see message 'Thank you for your order'$")
    public void iShouldBeAbleToSeeMessageThankYouForYourOrder() {
        new CheckOutCompletePage().verifyingMessage();
    }

}
