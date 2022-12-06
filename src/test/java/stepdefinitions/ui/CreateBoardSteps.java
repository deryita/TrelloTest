package stepdefinitions.ui;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.LoginPage;
import pages.WorkspacePage;

public class CreateBoardSteps {
    LoginPage loginPage = new LoginPage();
    WorkspacePage workspacePage;

    @Given("user opens Trello page")
    public void user_opens_trello_page() {

        loginPage.openMainPage();
    }

    @When("user login with user and password")
    public void user_login_with_user_and_password() {
        workspacePage = loginPage.login();
    }

    @Then("user clicks create board and enters board name as (.*)$")
    public void user_clicks_create_board(String boardName) {
        Assert.assertTrue("Board created", workspacePage.createBoard(boardName));
    }

    @Then("user deletes the board")
    public void user_deletes_the_board() {
        Assert.assertEquals("Board is deleted", 0, workspacePage.deleteBoard());
        workspacePage.closeDriver();

    }
}
