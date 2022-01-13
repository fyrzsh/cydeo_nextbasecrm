package com.nextbasecrm.pages;

import com.nextbasecrm.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MeetingsAndBriefingsPage extends BasePage{


    public MeetingsAndBriefingsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy (className = "webform-small-button-text")
    public WebElement newMeetingButton;

    @FindBy (xpath = "//table[@class='meeting-list-table']//th")
    public List<WebElement> myMeetingsTableHead;

    @FindBy (className = "meeting-title-link")
    public List <WebElement> myMeetingTopics;

    @FindBy (className = "menu-popup-item-text")
    public List <WebElement> topicPopUpList;

    @FindBy (xpath = "//span[contains(.,'Briefings')]")
    public WebElement meetingAndBriefingsButton;


    public WebElement myMeetingTableElem (String tableHeadName) {
        for (WebElement webElement : myMeetingsTableHead) {
            if (webElement.getText().equalsIgnoreCase(tableHeadName)) {
                return webElement;
            }
        }
        return null;
    }
}
