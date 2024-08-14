package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ElementHelper;

public class SignUpPage {

    WebDriver driver;
    ElementHelper elementHelper;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
        this.elementHelper = new ElementHelper(driver);
    }

    // Generic method to enter text in any field
    public void enterText(String field, String text) {
        By fieldLocator;

        switch (field.toLowerCase()) {
            case "first name":
                fieldLocator = By.id("firstname");
                break;
            case "last name":
                fieldLocator = By.id("lastname");
                break;
            case "email":
                fieldLocator = By.id("email_address");
                break;
            case "password":
                fieldLocator = By.id("password");
                break;
            case "confirm password":
                fieldLocator = By.id("password-confirmation");
                break;
            default:
                throw new IllegalArgumentException("Invalid field: " + field);
        }

        elementHelper.type(fieldLocator, text);
    }

    public void scrollToSubmitButton() {
        elementHelper.scrollIntoView(
                By.xpath("//button[@title='Create an Account']//span[contains(text(),'Create an Account')]"));
    }

    public void clickSubmitButton() {
        elementHelper
                .click(By.xpath("//button[@title='Create an Account']//span[contains(text(),'Create an Account')]"));
    }

    public String getErrorMessage(By locator) {
        return elementHelper.getText(locator);
    }

    public void navigateToCreateAccountPage() {
        driver.get("https://magento.softwaretestingboard.com/");
        elementHelper.click(By.xpath("//div[@class='panel header']//a[normalize-space()='Create an Account']"));
    }
}
