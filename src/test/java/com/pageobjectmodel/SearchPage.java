package com.pageobjectmodel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Base_Class;
import com.interfaceelement.SearchPageInterfaceElements;

public class SearchPage extends Base_Class implements SearchPageInterfaceElements{

	@FindBy(id = location_ID)
	private WebElement location;

	@FindBy(name = hotels_name)
	private WebElement hotels;

	@FindBy(id = roomtype_id)
	private WebElement roomType;

	@FindBy(xpath = noOfRooms_xpath)
	private WebElement NoOfRooms;

	@FindBy(xpath = checkIn_xpath)
	private WebElement checkIn;

	@FindBy(xpath = CheckOut_xpath)
	private WebElement checkOut;

	@FindBy(xpath = AdultperRom_xpath)
	private WebElement AdultRoom;

	@FindBy(xpath = childperRoom_xpath)
	private WebElement childRoom;

	@FindBy(xpath = SearchBtn_xpath)
	private WebElement searchBtn;

	public SearchPage() {
		PageFactory.initElements(driver, this);
	}

	public void location() {
		selectByVisibleText(location,"Sydney");
	}
	public void hotel() {
		selectByVisibleText(hotels, "Hotel Sunshine");
	}
	public void roomType() {

		selectByVisibleText(roomType, "Double");
	}
	public void noOfRooms(){
		selectByVisibleText(NoOfRooms, "1 - One");
	}
	public void checkIn(){
		passInput(checkIn, "05/07/2025");
	}
	public void checkOut(){
		passInput(checkOut, "07/07/2025");
	}
	public void adultRoom() {
		selectByVisibleText(AdultRoom, "1 - One");
	}
	public void childRoom() {

		selectByVisibleText(childRoom, "2 - Two");
	}
	public void clickSearchButton() {

		elementClick(searchBtn);  
		
		System.out.println("some changes 2");
	}
}
