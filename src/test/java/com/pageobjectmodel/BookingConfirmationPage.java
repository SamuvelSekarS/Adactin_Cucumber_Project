package com.pageobjectmodel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Base_Class;
import com.interfaceelement.BookingConfirmationPageInterfaceElement;

public class BookingConfirmationPage extends Base_Class implements BookingConfirmationPageInterfaceElement {

	@FindBy(xpath=myItinerary_xpath)
	private WebElement itineraryBtn;

	public BookingConfirmationPage() {
		PageFactory.initElements(driver, this);
	}

	public void clickItineraryButton() {
		//elementClick(itineraryBtn);
		javaScriptClick(itineraryBtn);
	}
}
