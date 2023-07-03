package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    @FindBy(xpath = "//*[@data-id='Account']")
    private WebElement accountsBar;

    @FindBy(css = "div[title='New']")
    private WebElement newButton;

    public HomePage clickAccountsBar() {
        accountsBar.click();
        return this;
    }

    public NewAccountPage clickNewButton() {
        newButton.click();
        return new NewAccountPage(driver);
    }

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
}
