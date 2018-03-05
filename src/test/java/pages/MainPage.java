package pages;

import core.BaseFunctions;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

public class MainPage {

    public static final String URL = "http://qaguru.lv:8080/qa2/";
    private static final Logger LOGGER = Logger.getLogger(MainPage.class);
    private static By ADD_USER_PAGE = By.linkText("Add User");
    private BaseFunctions baseFunctions;

    public MainPage(BaseFunctions baseFunctions) {
        this.baseFunctions = baseFunctions;
    }

    public AddUserPage openAddUserPage(BaseFunctions baseFunctions) {
        baseFunctions.click(ADD_USER_PAGE);
        return new AddUserPage(baseFunctions);
    }
}
