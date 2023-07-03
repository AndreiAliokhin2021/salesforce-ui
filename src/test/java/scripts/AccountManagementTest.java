package scripts;

import org.testng.annotations.Test;
import pages.AccountPage;
import pages.HomePage;

public class AccountManagementTest extends BaseTest {

    private static final String ACCOUNT_NAME = "Test Account";
    private static final String EDITED_ACCOUNT_NAME = "Edited Account";

    @Test
    public void createAccount() {
        HomePage homePage = new HomePage(driver);
        homePage.clickAccountsBar()
                .clickNewButton()
                .enterAccountName(ACCOUNT_NAME)
                .clickSaveButton()
                .checkAccountTitle(ACCOUNT_NAME);

    }

    @Test(dependsOnMethods = "createAccount")
    public void editAccount() {
        AccountPage accountPage = new AccountPage(driver);
        accountPage.
                clickEditButton()
                .clearAccountNameField()
                .enterAccountName(EDITED_ACCOUNT_NAME)
                .clickSaveButton()
                .checkAccountTitle(EDITED_ACCOUNT_NAME);

    }
}
