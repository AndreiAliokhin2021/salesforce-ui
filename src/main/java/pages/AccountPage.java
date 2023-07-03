package pages;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class AccountPage extends BasePage {
    @FindBy(xpath = "//*[contains(@class, 'custom-truncate')]")
    public WebElement accountTitle;
    @FindBy(xpath = "//button[@name='Edit']")
    private WebElement editButton;

    public EditAccountPage clickEditButton() {
        editButton.click();
        return new EditAccountPage(driver);
    }

    public AccountPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void checkAccountTitle(String expectedValue) {
        webDriverWait.until(ExpectedConditions.textToBePresentInElement(accountTitle, expectedValue));
        Assertions.assertThat(accountTitle.getText()).isEqualTo(expectedValue);
    }
}
