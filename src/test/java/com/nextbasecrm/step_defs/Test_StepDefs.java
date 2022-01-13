package com.nextbasecrm.step_defs;

import com.nextbasecrm.pages.LoginPage;
import com.nextbasecrm.pages.TimeAndReportsPage;
import com.nextbasecrm.utils.BrowserUtils;
import com.nextbasecrm.utils.ConfigurationReader;
import com.nextbasecrm.utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

//import java.text.BreakIterator;

public class Test_StepDefs {
    LoginPage loginPage = new LoginPage();
    TimeAndReportsPage reportsPage = new TimeAndReportsPage();

    @Given("User is on the Nextbase CRM login page")
    public void user_is_on_the_nextbase_crm_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("nextbasecrm.url"));
    }

    @When("User enters {string} and {string} and login")
    public void user_enters_and_and_login(String u, String p) {
        loginPage.login(u, p);
    }

    @Then("User should see {string} displayed")
    public void user_should_see_displayed(String expTitle) {
        Assert.assertTrue(loginPage.homePageButton.getText().contains(expTitle));

    }

    @When("User clicks on {string}")
    public void user_clicks_on(String timeAndReports) {
        loginPage.clickOnModuleOf(timeAndReports);
    }

    @When("User navigates on {string}")
    public void user_navigates_on(String meetingAndBriefings) {
        try {
            reportsPage.clickOnFeatureOf(meetingAndBriefings);
        } catch (Exception e) {
            reportsPage.moreTab.click();
            reportsPage.meetingAndBriefingsHead.click();
        }

    }

    @Then("User should see {string}")
    public void user_should_see(String expPageTitle) {
//        BrowserUtils.waitForVisibilityOf(reportsPage.featurePageTitle, 10);
//        BrowserUtils.scrollDown(reportsPage.meetingAndBriefingsHead);
//        System.out.println("expPageTitle = " + expPageTitle);
//        System.out.println("ectPageTitle = " + reportsPage.featurePageTitle.getText());


        Assert.assertEquals(expPageTitle, reportsPage.featurePageTitle.getText());




    }
}
