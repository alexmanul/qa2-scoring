package pages;

import core.BaseFunctions;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AddUserPage {

    public static final String URL = "http://qaguru.lv:8080/qa2/addUser";
    public static final String VALIDATION_MESSAGE_TEXT = "Some fields are empty";
    private static final Logger LOGGER = Logger.getLogger(AddUserPage.class);
    private static final By VALIDATION_MESSAGE = By.cssSelector("div[style='color: red']");
    private static final By FORM = By.cssSelector("html body div.form");
    public static final By NAME = By.cssSelector("input[name='name']"); // By.xpath("//input[@name='name']"); //
    public static final By SURNAME = By.cssSelector("input[name='surname']");
    public static final By PHONE = By.cssSelector("input[name='phone']");
    public static final By EMAIL = By.cssSelector("input[name='email']");
    public static final By GENDER = By.cssSelector("input[name='gender']");
    public static final By PERSON_ID = By.cssSelector("input[name='personId']");
    public static final By FORM_SUBMIT_BTN = By.xpath("//input[@type='submit']");
    private BaseFunctions baseFunctions;

    public AddUserPage(BaseFunctions baseFunctions) {
        this.baseFunctions = baseFunctions;
    }

    public WebElement getForm() {
        LOGGER.info("getForm > start");
        WebElement formElem = baseFunctions.driver.findElement(FORM);
        LOGGER.info("getForm > found formElem: " + formElem.toString());
        return formElem;
    }

    //TODO doesn't work yet
    public void fillForm(WebElement formElem) {
        WebElement inputName = baseFunctions.driver.findElement(NAME);
        baseFunctions.waitForElement(NAME, 500);
        LOGGER.info("fillForm > isPresentElement NAME " + baseFunctions.isPresentElement(NAME));
        LOGGER.info("fillForm > found inputName: " + inputName.toString());
        inputName.sendKeys("test");
    }

    public void submitForm(WebElement formElem) {
        WebElement formSubmitBtn = baseFunctions.driver.findElement(FORM_SUBMIT_BTN);
        LOGGER.info("submitForm > found formSubmitBtn: " + formSubmitBtn.toString());
        formSubmitBtn.click();
    }

    public boolean isPresentValidationMessage() {
        baseFunctions.waitForElement(VALIDATION_MESSAGE, 500);
        return baseFunctions.isPresentElement(VALIDATION_MESSAGE);
    }

    public String getValidationMessage() {
        WebElement validationMsg = baseFunctions.driver.findElement(VALIDATION_MESSAGE);
        LOGGER.info("submitForm > validationMsg text: " + validationMsg.getText());
        return validationMsg.getText();
    }

}