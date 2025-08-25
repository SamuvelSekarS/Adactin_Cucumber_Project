package com.pageobjectmodel;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.base.Base_Class;
import com.interfaceelement.BookedItineraryPageInterfaceElement;
import com.utility.FileReaderManager;

public class BookedItineraryPage extends Base_Class implements BookedItineraryPageInterfaceElement{

	@FindBy(id=searchOrderId_id)
	private WebElement orderId;

	@FindBy(id=go_id)
	private WebElement goBtn;

	@FindBy(id=logout_id)
	private WebElement logoutBtn;

	public BookedItineraryPage(){
		PageFactory.initElements(driver, this);
	}
	FileReaderManager data = new FileReaderManager();
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	public void orderId() {
		wait.until(ExpectedConditions.visibilityOf(orderId));
		passInput(orderId, data.getDataproperty("orderid"));
		wait.until(ExpectedConditions.elementToBeClickable(goBtn));
	}
	public void clickGoButton() {
		elementClick(goBtn);
	}
	public void clickLogoutButton() {
		wait.until(ExpectedConditions.elementToBeClickable(logoutBtn));
		elementClick(logoutBtn);
	}
}
