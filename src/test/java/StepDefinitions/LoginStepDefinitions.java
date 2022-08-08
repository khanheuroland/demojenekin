package StepDefinitions;

import io.cucumber.java.en.*;

import org.junit.jupiter.api.Assertions.*;
import pageobjects.LoginPage;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class LoginStepDefinitions {
    LoginPage loginPage;

    public LoginStepDefinitions()
    {
        this.loginPage = new LoginPage(Hook.driver);
    }

    @Given("^The login page is showed$")
    public void the_login_page_is_showed() {
        this.loginPage.Open();
    }

    @When("^The user attempt to login with username \"([^\"]*)\" and wrong password \"([^\"]*)\"$")
    public void the_user_attempt_to_login_with_username_and_wrong_password(String username, String password) {
        this.loginPage.loginWithUsernameAndPwd(username, password);
    }

    @Then("^The popup message with content \"([^\"]*)\" will be showed$")
    public void the_popup_message_with_content_something_will_be_showed(String popupMsg) {
        assertThat(this.loginPage.getPopupMessage(), equalTo(popupMsg));
    }

}
