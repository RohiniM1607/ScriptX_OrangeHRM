package com.actions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pages.ContactDetailsPage;
import com.utilities.CommonUtils;
import com.utilities.HelperClass;

public class ContactDetailsActions {

    ContactDetailsPage contactDetailsPage;
    WebDriverWait wait;
    HelperClass helper = new HelperClass();

    public ContactDetailsActions() {
        this.contactDetailsPage = new ContactDetailsPage();
        wait = new WebDriverWait(helper.getDriver(), Duration.ofSeconds(15));
    }

    public void updateContactDetails(String sheetName, int rowNum) {
        CommonUtils.loadExcel(sheetName);

        clearAndType(contactDetailsPage.street1,      CommonUtils.getCellData(rowNum, "Street1"));
        clearAndType(contactDetailsPage.street2,      CommonUtils.getCellData(rowNum, "Street2"));
        clearAndType(contactDetailsPage.city,         CommonUtils.getCellData(rowNum, "City"));
        clearAndType(contactDetailsPage.state,        CommonUtils.getCellData(rowNum, "State"));
        clearAndType(contactDetailsPage.zipCode,      CommonUtils.getCellData(rowNum, "ZipCode"));

        contactDetailsPage.country.click();
        selectDropdown(CommonUtils.getCellData(rowNum, "Country"));

        clearAndType(contactDetailsPage.homeTelephone, CommonUtils.getCellData(rowNum, "HomeTelephone"));
        clearAndType(contactDetailsPage.mobile,        CommonUtils.getCellData(rowNum, "Mobile"));
        clearAndType(contactDetailsPage.workTelephone, CommonUtils.getCellData(rowNum, "WorkTelephone"));
        clearAndType(contactDetailsPage.workEmail,     CommonUtils.getCellData(rowNum, "WorkEmail"));
    }

    public void clickSave() {
        wait.until(ExpectedConditions.elementToBeClickable(contactDetailsPage.btnSave));
        contactDetailsPage.btnSave.click();
    }

    public void clickAddAttachment() {
        wait.until(ExpectedConditions.elementToBeClickable(contactDetailsPage.btnAddAttachment));
        contactDetailsPage.btnAddAttachment.click();
    }

    public void uploadAttachment(String sheetName, int rowNum) {
        CommonUtils.loadExcel(sheetName);
        String filePath    = CommonUtils.getCellData(rowNum, "AttachmentPath");
        String description = CommonUtils.getCellData(rowNum, "AttachmentDescription");

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='file']")));
        contactDetailsPage.fileInput.sendKeys(filePath);

        wait.until(ExpectedConditions.visibilityOf(contactDetailsPage.attachmentDescription));
        contactDetailsPage.attachmentDescription.clear();
        contactDetailsPage.attachmentDescription.sendKeys(description);
    }

    public void clickAttachmentSave() {
        wait.until(ExpectedConditions.elementToBeClickable(contactDetailsPage.btnAttachmentSave));
        contactDetailsPage.btnAttachmentSave.click();
    }

    public String getSuccessMessage() {
        WebDriverWait toastWait = new WebDriverWait(helper.getDriver(), Duration.ofSeconds(15));
        return toastWait.until(ExpectedConditions.visibilityOf(
            contactDetailsPage.txtSuccessMessage)).getText().trim();
    }

    private void clearAndType(org.openqa.selenium.WebElement element, String value) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(Keys.CONTROL + "a");
        element.sendKeys(Keys.DELETE);
        element.sendKeys(value);
    }

    private void selectDropdown(String value) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//div[@role='listbox']//span[text()='" + value + "']"))).click();
    }
}