package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.SignUpPage;
import utils.WebDriverManager;

public class SignUpSteps {

    WebDriver driver = WebDriverManager.getDriver();
    SignUpPage signUpPage = new SignUpPage(driver);

    @Given("the user is on the Create Account page")
    public void the_user_is_on_the_create_account_page() {
        signUpPage.navigateToCreateAccountPage();
    }

    @When("the user enters {string} in the first name field")
    public void the_user_enters_in_the_first_name_field(String firstName) {
        signUpPage.enterText("first name", firstName);
    }

    @When("the user enters {string} in the last name field")
    public void the_user_enters_in_the_last_name_field(String lastName) {
        signUpPage.enterText("last name", lastName);
    }

    @When("the user enters {string} in the email field")
    public void the_user_enters_in_the_email_field(String email) {
        signUpPage.enterText("email", email);
    }

    @When("the user enters {string} in the password field")
    public void the_user_enters_in_the_password_field(String password) {
        signUpPage.enterText("password", password);
    }

    @When("the user enters {string} in the confirm password field")
    public void the_user_enters_in_the_confirm_password_field(String confirmPassword) {
        signUpPage.enterText("confirm password", confirmPassword);
    }

    @When("the user scrolls to the Create an Account button")
    public void the_user_scrolls_to_the_create_an_account_button() {
        signUpPage.scrollToSubmitButton();
    }

    @When("the user clicks the Create an Account button")
    public void the_user_clicks_the_create_an_account_button() {
        signUpPage.clickSubmitButton();
    }

    @Then("the user account should be created successfully")
    public void the_user_account_should_be_created_successfully() {
    }

    @Then("the user should see an error message for the already registered email")
    public void the_user_should_see_an_error_message_for_the_already_registered_email() {
        By errorMessageLocator = By.cssSelector(".error-message-class");
        String errorMessage = signUpPage.getErrorMessage(errorMessageLocator);
    }

    @Then("the user should see an error message for mismatched passwords")
    public void the_user_should_see_an_error_message_for_mismatched_passwords() {
        By errorMessageLocator = By.cssSelector(".mismatch-password-error");
        String errorMessage = signUpPage.getErrorMessage(errorMessageLocator);

    }

    @Then("the user should see error messages for the missing mandatory fields")
    public void the_user_should_see_error_messages_for_the_missing_mandatory_fields() {
        By errorMessageLocator = By.cssSelector(".missing-field-error");
        String errorMessage = signUpPage.getErrorMessage(errorMessageLocator);
       
    }

    @When("the user enters {string} in the {string} field")
    public void the_user_enters_in_the_field(String value, String field) {
        signUpPage.enterText(field, value);
    }

    @When("the user leaves the {string} field empty")
    public void the_user_leaves_the_field_empty(String field) {
        signUpPage.enterText(field, "");
    }
}
