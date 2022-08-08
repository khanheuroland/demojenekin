package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    @FindBy(css = "input[type=\"email\"]")
    WebElement tbUsername;
    @FindBy(css = "input[type=\"password\"]")
    WebElement tbPassword;
    @FindBy(css = "div.credential button")
    WebElement btnLogin;

    By popupMessage = By.cssSelector("div#popover b");
    WebDriver driver;
    public LoginPage(WebDriver driver)
    {
        this.driver =driver;
    }

    public void Open()
    {
        this.driver.get("http://testmaster.vn/Account/Login?ReturnUrl=%2fadmin");
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        PageFactory.initElements(this.driver, this);
    }


    public void loginWithUsernameAndPwd(String username, String password)
    {
        this.tbUsername.sendKeys(username);
        this.tbPassword.sendKeys(password);
        btnLogin.click();
    }


    public String getPopupMessage()
    {
        WebDriverWait waitPopup= new WebDriverWait(this.driver, Duration.ofSeconds(15));
        WebElement lbMessage = waitPopup.until(ExpectedConditions.visibilityOfElementLocated(popupMessage));
        return lbMessage.getText();
    }
}
