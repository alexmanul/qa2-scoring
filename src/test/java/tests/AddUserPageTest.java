package tests;

import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;
import pages.AddUserPage;
import core.BaseFunctions;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class AddUserPageTest {

    private static final Logger LOGGER = Logger.getLogger(AddUserPageTest.class);
    private BaseFunctions baseFunctions = new BaseFunctions();

    @Test
    public void correctFormFieldsSubmitValidaitonTest() throws MessagingException, IOException {
        LOGGER.info("correctFormFieldsSubmitValidaitonTest > start");
        baseFunctions.goToUrl(AddUserPage.URL);
        AddUserPage addUserPage = new AddUserPage(baseFunctions);

        //TODO: some logic goes here

//        baseFunctions.stopDriver();
    }

    @Test
    public void emptyFormFieldsSubmitValidationMessageTest() throws MessagingException, IOException {
        LOGGER.info("emptyFormFieldsSubmitValidationTest > ");
        baseFunctions.goToUrl(AddUserPage.URL);
        AddUserPage addUserPage = new AddUserPage(baseFunctions);

        WebElement formElem = addUserPage.getForm();
        //addUserPage.fillForm(formElem);
        addUserPage.submitForm(formElem);

        String validationMessageText = "";
        if (addUserPage.isPresentValidationMessage()) {
            validationMessageText = addUserPage.getValidationMessage().trim();
        }

        Assert.assertEquals(AddUserPage.VALIDATION_MESSAGE_TEXT, validationMessageText);

//        baseFunctions.stopDriver();
    }
}
