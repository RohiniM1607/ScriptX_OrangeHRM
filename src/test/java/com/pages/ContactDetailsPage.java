package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactDetailsPage extends BasePage {

    @FindBy(xpath = "//label[text()='Street 1']/following::input[1]")
    public WebElement street1;

    @FindBy(xpath = "//label[text()='Street 2']/following::input[1]")
    public WebElement street2;

    @FindBy(xpath = "//label[text()='City']/following::input[1]")
    public WebElement city;

    @FindBy(xpath = "//label[text()='State/Province']/following::input[1]")
    public WebElement state;

    @FindBy(xpath = "//label[text()='Zip/Postal Code']/following::input[1]")
    public WebElement zipCode;

    @FindBy(xpath = "//label[text()='Country']/parent::div/following-sibling::div//div[contains(@class,'oxd-select-text')]")
    public WebElement country;

    @FindBy(xpath = "//label[text()='Home']/following::input[1]")
    public WebElement homeTelephone;

    @FindBy(xpath = "//label[text()='Mobile']/following::input[1]")
    public WebElement mobile;

    @FindBy(xpath = "//label[text()='Work']/following::input[1]")
    public WebElement workTelephone;

    @FindBy(xpath = "//label[text()='Work Email']/following::input[1]")
    public WebElement workEmail;

    @FindBy(xpath = "(//button[normalize-space()='Save'])[1]")
    public WebElement btnSave;

    @FindBy(xpath = "//div[contains(@class,'oxd-toast ')]//p[contains(@class,'oxd-text')]")
    public WebElement txtSuccessMessage;

    @FindBy(xpath = "//h6[text()='Attachments']/following::button[normalize-space()=' Add'][1]")
    public WebElement btnAddAttachment;

    @FindBy(xpath = "//input[@type='file']")
    public WebElement fileInput;

    @FindBy(xpath = "//label[text()='Description']/following::textarea[1]")
    public WebElement attachmentDescription;

    @FindBy(xpath = "(//button[normalize-space()='Save'])[1]")
    public WebElement btnAttachmentSave;

    @FindBy(xpath = "//div[contains(@class,'oxd-toast ')]//p[contains(@class,'oxd-text')]")
    public WebElement txtAttachmentSuccessMessage;
}
