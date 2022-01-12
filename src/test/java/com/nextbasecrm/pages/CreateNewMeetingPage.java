package com.nextbasecrm.pages;

import com.nextbasecrm.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

//import java.util.LinkedList;
import java.util.List;

public class CreateNewMeetingPage extends BasePage {


    @FindBy (linkText = "View meetings")
    public WebElement viewMeetingsButton;

    @FindBy (className = "meeting-new-title-wrap")
    public WebElement topicNewTitleField;

    @FindBy (xpath = "//span[@class='meeting-new-create-date']//label")
    public List<WebElement> dateTimeDuration;

    @FindBy(className = "meeting-new-create-d-date")
    public WebElement dateField;

    @FindBy(className = "meeting-new-create-d-time")
    public WebElement timeField;

    @FindBy(className = "meeting-new-create-d-duration")
    public WebElement durationField;

    @FindBy (linkText = "Attendees:")
    public WebElement attendeesTag;

    @FindBy(id = "USERS_user_input")
    public WebElement attendeesUserSearchField;

    @FindBy(xpath = "//span[contains(@id,'USERS_tab')]")
    public List <WebElement> attendeesFinderTypeList;

    @FindBy (xpath = "//div[@class='company-department company-department-first']/span")
    public WebElement attendeesCompanyDepartment;

    @FindBy (xpath = "//div[@class='company-department']")
    public List <WebElement> attendeesCompanyDepartmentList;

    @FindBy (id = "//span[@id='meeting_members']")
    public List <WebElement> meetingAttendeesMembers;

    @FindBy (linkText = "Administrative assistant:")
    public WebElement adminAssistanceTag;

    @FindBy (xpath = "//div[@class='menu-popup-items']/a")
    public List <WebElement> adminAssistanceList;

    @FindBy (xpath = "(//span[@class='meeting-new-members-right'])[2]")
    public WebElement adminAssistanceMember;

    @FindBy (className = "meeting-new-meeting-plase-text")
    public WebElement locationTag;

    @FindBy (xpath = "//input[@name='PLACE']")
    public WebElement locationField;

    @FindBy (xpath = "//label[@for='EVENT_NOTIFY']")
    public WebElement invitationCheckBox;

    @FindBy (className = "webform-field-label")
    public WebElement meetingDescriptionTag;


    @FindBy(xpath = "//span[@class='meeting-new-duration-time']/span")
    public List <WebElement> minHours;

    @FindBy (id = "LHE_iframe_bxlhe4909")
    public WebElement getMeetingDescriptionFrameField;

    @FindBy (id = "mouseposition-extension-element-full-container")
    public WebElement meetingDescInputField;

    @FindBy (name = "bxu_files[]")
    public WebElement addFileButton;

    @FindBy (xpath = "//span[.='Project meeting']")
    public WebElement meetingDescProjMeetingButton;

    @FindBy (name = "AGENDA_TITLE[n0]")
    public WebElement topicField;

    @FindBy (name = "AGENDA_RESPONSIBLE[n0][]")
    public WebElement agendaDropdownElem;

    @FindBy (xpath = "//input[@value='Due by']")
    public WebElement agendaDueDateField;

    @FindBy (xpath = "//span[.='Save']")
    public WebElement agendaSaveButton;

    @FindBy (xpath = "//span[.='Cancel']")
    public WebElement agendaCancelButton;

    @FindBy (xpath = "//span[.='Add topic']")
    public WebElement agendaAdTopicButton;

    @FindBy(xpath = "//div[@id='meeting_toolbar_layout']//a[.='Add from meeting']")
    public WebElement agendaAddFromMeetingButton;

    @FindBy (xpath = "//div[@id='meeting_toolbar_layout']//a[.='Add from task']")
    public WebElement agendaAddFromTassButton;

    @FindBy(className = "webform-button-text")
    public WebElement createMeetingButton;

    @FindBy (xpath = "//div[@class='meeting-new-select-but-wrap']//a[.='Cancel']")
    public WebElement newMeetingCreateCancelButton;

    @FindBy (className = "meeting-ag-edit-close")
    public WebElement agendaDeleteButton;

    @FindBy (className = "meeting-ag-edit-edit")
    public WebElement agendaEditButton;

    public void inputIntoIMeetingDescriptionFrame (String description) {
        Driver.getDriver().switchTo().frame(getMeetingDescriptionFrameField);
        meetingDescInputField.sendKeys(description);
        Driver.getDriver().switchTo().defaultContent();
    }

    public void selectAgendaDropdownList (String option) {
        Select select = new Select(agendaDropdownElem);
        select.selectByVisibleText(option);
    }

    public List <WebElement> getAgendaDropDownList () {
        Select select = new Select(agendaDropdownElem);
        return select.getOptions();


    }




}
