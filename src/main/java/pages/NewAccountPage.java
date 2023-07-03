package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewAccountPage extends BasePage {
    @FindBy(xpath = "//button[@title='Save']")
    private WebElement saveButton;

    @FindBy(xpath = "//div[contains(@data-target-selection-name, 'Account.Name')]//input[@type='text']")
    private WebElement accountNameTextField;

    public NewAccountPage enterAccountName(String name) {
        accountNameTextField.sendKeys(name);
        return this;
    }

    public AccountPage clickSaveButton() {
        saveButton.click();
        return new AccountPage(driver);
    }

    public NewAccountPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
}
