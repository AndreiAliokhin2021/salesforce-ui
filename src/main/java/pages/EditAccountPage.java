package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditAccountPage extends BasePage {
    @FindBy(xpath = "//div[contains(@data-target-selection-name, 'Account.Name')]//input[@type='text']")
    private WebElement accountNameTextField;

    @FindBy(xpath = "//button[@name='SaveEdit']")
    private WebElement saveButton;

    public EditAccountPage clearAccountNameField() {
        accountNameTextField.clear();
        return this;
    }

    public EditAccountPage enterAccountName(String name) {
        accountNameTextField.sendKeys(name);
        return this;
    }

    public AccountPage clickSaveButton() {
        saveButton.click();
        return new AccountPage(driver);
    }

    public EditAccountPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
}
