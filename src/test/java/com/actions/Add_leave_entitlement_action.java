package com.actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.pages.Add_leave_entitlement_page;

public class Add_leave_entitlement_action {
	
	 Add_leave_entitlement_page ep;

	    public Add_leave_entitlement_action(WebDriver driver) {

	        ep = new Add_leave_entitlement_page(driver);
	    }
	
	    public void leavePage() {

	        ep.leave_page.click();
	    }
	public void addEntitlement() {
		ep.entitlement_link.click();
		ep.add_entitlement.click();
	}
	public void user_details(String name,String entitlement) {
		ep.employee_name.sendKeys(name);
		
		
	}
	
	

}
