package pages;

import org.openqa.selenium.By;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LoginPage extends BasePage {

    By btn_login = By.xpath("//*[contains(text(),'Log in')]");
    By txt_userName = By.id("user");
    By btn_cue = By.id("login");
    By txt_pwd = By.id("password");
    By btn_loginSubmit = By.id("login-submit");

    public void openMainPage() {
        getdriver();
        goToURL(getConfigFileReader().getApplicationUrl(), btn_login);

    }

    public WorkspacePage login(HashMap<String, String>... credentials) {
        String username = "";
        String password = "";
        HashMap<String, String>[] inputCredentials = credentials;
        goToURL(getConfigFileReader().getApplicationUrl(), btn_login);
        if (inputCredentials.length == 0) {
            username = getConfigFileReader().getUserName();
            password = getConfigFileReader().getPassword();
        } else {

            for (Map.Entry<String, String> entry : Arrays.stream(inputCredentials).iterator().next().entrySet()) {
                username = entry.getKey();
                password = entry.getValue();
            }
        }
        enterText(username, txt_userName);
        click(btn_cue);
        isElementDisplayed(btn_loginSubmit);
        enterText(password, txt_pwd);
        click(btn_loginSubmit);
        return new WorkspacePage();
    }


}
