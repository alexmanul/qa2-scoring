package steps;

import core.BaseFunctions;
import cucumber.api.DataTable;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import pages.AddUserPage;
import pages.MainPage;

import java.util.List;

import static pages.AddUserPage.*;

public class StepDefinitions {

    private BaseFunctions baseFunctions = new BaseFunctions();
    private MainPage mainPage;
    private AddUserPage addUserPage;
    private Scenario scenario;

    @Before
    public void before(Scenario scenario) {
        this.scenario = scenario;
    }

    @Given("User is on the '(.+)' page")
    public void open_main_page(final String url) {
        baseFunctions.goToUrl(url);
        mainPage = new MainPage(baseFunctions);
    }

    @When("User opens 'Add user' registration form")
    public void open_add_user_registration_form_link() {
        scenario.write("Trying to open 'Add user' registration form");
        addUserPage = mainPage.openAddUserPage(baseFunctions);
    }

    @When("User switches tabs")
    public void switch_tabs() {
        baseFunctions.switchingTabs();
    }

    //
//    @When("User opens QA course")
//    public void open_qa_course_link() {
//        scenario.write("Trying to open QA course page");
//        qaPage = mainPage.openQaPage();
//    }
//
//    @When("User opens QA registration form")
//    public void open_qa_registration_form_link() {
//        scenario.write("Trying to open QA course registration form");
//        qaRegistrationForm = qaPage.openRegistrationForm();
//    }
//
    @When("User fills registration form with data")
    public void fill_qa_registration_form(DataTable dataTable) {
        List<List<String>> data = dataTable.raw();
        baseFunctions.findElement(NAME).sendKeys(data.get(0).get(1));
        baseFunctions.findElement(SURNAME).sendKeys(data.get(1).get(1));
        baseFunctions.findElement(PHONE).sendKeys(data.get(2).get(1));
        baseFunctions.findElement(EMAIL).sendKeys(data.get(3).get(1));
        baseFunctions.findElement(GENDER).click();
//        baseFunctions.findElement(GENDER).click();sendKeys(data.get(4).get(1));
        baseFunctions.findElement(PERSON_ID).sendKeys(data.get(5).get(1));
        baseFunctions.findElement(FORM_SUBMIT_BTN).click();
//        baseFunctions.closePages();
    }

}