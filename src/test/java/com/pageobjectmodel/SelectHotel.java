package com.pageobjectmodel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Base_Class;
import com.interfaceelement.SelectHotelPageInterfaceElement;

public class SelectHotel extends Base_Class implements SelectHotelPageInterfaceElement{

	@FindBy(id = selectButton_id)
	private WebElement radioBtn;

	@FindBy(id = continue_id)
	private WebElement continueBtn;

	public SelectHotel() {
		PageFactory.initElements(driver, this);
	}

	public void hotelSelect() {
		elementClick(radioBtn);
	}
	public void continueButton() {
		elementClick(continueBtn);
	}
}
//		javaScriptClick(radioBtn);
//		javaScriptClick(continueBtn);



