package com.pageobjectmodel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Base_Class;
import com.interfaceelement.HotelBookingPageInterfaceElement;
import com.utility.FileReaderManager;

public class HotelBookingPage extends Base_Class implements HotelBookingPageInterfaceElement{

	@FindBy(id=firstName_id)
	private WebElement firstName;

	@FindBy(id=lastName_id)
	private WebElement lastName;

	@FindBy(id=billingAddress_id)
	private WebElement billingAddress;

	@FindBy(id=creditCardNo_id)
	private WebElement creditCardNo;

	@FindBy(id=creditCardType_id)
	private WebElement creditCardType;

	@FindBy(id=selectMonth_id)
	private WebElement CardExpiryMonth;

	@FindBy(id=selectYear_id)
	private WebElement CardExpiryYear;

	@FindBy(id=cvvNumber_id)
	private WebElement cvvNumber;

	@FindBy(xpath=bookNow_xpath)
	private WebElement bookNowBtn;

	public HotelBookingPage() {
		PageFactory.initElements(driver, this);
	}

	FileReaderManager data = new FileReaderManager();

	public void firstName(){
		passInput(firstName, data.getDataproperty("firstname"));
	}

	public void lastName(){
		passInput(lastName, data.getDataproperty("lastname"));
	}
	public void billingAddress() {
		passInput(billingAddress, data.getDataproperty("billingaddress"));
	}
	public void creditCardNumber() {
		passInput(creditCardNo, data.getDataproperty("creditcardnumber"));
	}
	public void creditCardtype() {
		selectByVisibleText(creditCardType, "American Express");
	}
	public void cardExpiryDate() {
		selectByVisibleText(CardExpiryMonth, "August");
		selectByVisibleText(CardExpiryYear, "2027");
	}
	public void cvvNumber() throws InterruptedException {
		passInput(cvvNumber, data.getDataproperty("cvvnumber"));

		
		Thread.sleep(3000);
	}
	public void bookNowButton() throws InterruptedException {
		//javaScriptClick(bookNowBtn);
		elementClick(bookNowBtn);

		Thread.sleep(7000);
	}
}
