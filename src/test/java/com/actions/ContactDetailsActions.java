package com.actions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pages.ContactDetailsPage;
import com.utilities.ConfigReader;
import com.utilities.HelperClass;

public class ContactDetailsActions {

    ContactDetailsPage contactDetailsPage;
    WebDriverWait wait;
    ConfigReader testData;
    HelperClass helper = new HelperClass();

    public ContactDetailsActions() {
        this.contactDetailsPage = new ContactDetailsPage();
        wait = new WebDriverWait(helper.getDriver(), Duration.ofSeconds(15));
        testData = new ConfigReader("testData.properties");
    }

    private void waitForLoaderToDisappear() {
        try {
            WebDriverWait loaderWait = new WebDriverWait(helper.getDriver(), Duration.ofSeconds(10));
            loaderWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.oxd-form-loader")));
        } catch (Exception e) {
        }
    }

    private void clearAndType(org.openqa.selenium.WebElement element, String value) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();
        element.sendKeys(Keys.CONTROL + "a");
        element.sendKeys(Keys.DELETE);
        element.sendKeys(value);
    }

    public void updateContactDetails() {

        waitForLoaderToDisappear();

        clearAndType(contactDetailsPage.street1, testData.getData("contact_street1"));
        clearAndType(contactDetailsPage.street2, testData.getData("contact_street2"));
        clearAndType(contactDetailsPage.city, testData.getData("contact_city"));
        clearAndType(contactDetailsPage.state, testData.getData("contact_state"));
        clearAndType(contactDetailsPage.zipCode, testData.getData("contact_zip"));

        wait.until(ExpectedConditions.elementToBeClickable(contactDetailsPage.country));
        contactDetailsPage.country.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='listbox']//span[text()='" + testData.getData("contact_country") + "']"))).click();

        clearAndType(contactDetailsPage.homeTelephone, testData.getData("contact_homeTelephone"));
        clearAndType(contactDetailsPage.mobile, testData.getData("contact_mobile"));
        clearAndType(contactDetailsPage.workTelephone, testData.getData("contact_workTelephone"));
        clearAndType(contactDetailsPage.workEmail, testData.getData("contact_workEmail"));
    }

    public void clickSave() {
        wait.until(ExpectedConditions.elementToBeClickable(contactDetailsPage.btnSave));
        contactDetailsPage.btnSave.click();
    }

    public String getSuccessMessage() {
        WebDriverWait toastWait = new WebDriverWait(helper.getDriver(), Duration.ofSeconds(15));
        return toastWait.until(ExpectedConditions.visibilityOf(contactDetailsPage.txtSuccessMessage)).getText().trim();
    }

    public void clickAddAttachment() {
        wait.until(ExpectedConditions.elementToBeClickable(contactDetailsPage.addIcon));
        contactDetailsPage.addIcon.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='dialog']")));
    }

    public void uploadAttachment() {
        wait.until(ExpectedConditions.presenceOfElementLocated(
            By.xpath("//input[@type='file']")));
        contactDetailsPage.fileInput.sendKeys(testData.getData("contact_attachmentPath"));
    }

    public void clickSaveAttachment() {
        wait.until(ExpectedConditions.elementToBeClickable(contactDetailsPage.btnAttachmentSave));
        contactDetailsPage.btnAttachmentSave.click();
    }
}