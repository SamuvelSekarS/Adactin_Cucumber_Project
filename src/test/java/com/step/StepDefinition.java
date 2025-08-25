package com.step;

import com.base.Base_Class;
import com.pageobjectmanager.PageObjectManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition extends Base_Class {
	PageObjectManager pageObjectManager = new PageObjectManager();
	
	@Given("User launch the browser and URL")
	public void user_launch_the_browser_and_url() {
	    launchBrowser(pageObjectManager.getFileReaderManager().getDataproperty("browser"));
	    launchUrl(pageObjectManager.getFileReaderManager().getDataproperty("url"));
	   
	}

	@When("User enter the username as {string}")
	public void user_enter_the_username_as(String string) {
	    
	   pageObjectManager.getLoginPage().userName();
	}

	@When("User enter the password as {string}")
	public void user_enter_the_password_as(String string) {
	    
	   pageObjectManager.getLoginPage().passWord();
	}

	@When("User click on the submit button")
	public void user_click_on_the_submit_button() {
	    pageObjectManager.getLoginPage().clickLoginButton();
	   
	}

	@Then("User verifies the new page contains expected URL {string}")
	public void user_verifies_the_new_page_contains_expected_url(String string) {
	    
	   
	}

	@Then("User verifies new page contains expected text")
	public void user_verifies_new_page_contains_expected_text() {
	    
	   
	}

	@Then("User verifies Logout button is displayed on the page")
	public void user_verifies_logout_button_is_displayed_on_the_page() {
	    
	   
	}

	@When("User select the location")
	public void user_select_the_location() {
	    pageObjectManager.getSearchPage().location();
	   
	}

	@When("User select the hotel")
	public void user_select_the_hotel() {
	    
	   pageObjectManager.getSearchPage().hotel();
	}

	@When("User select the room type")
	public void user_select_the_room_type() {
	    pageObjectManager.getSearchPage().roomType();
	   
	}

	@When("User select the number of rooms")
	public void user_select_the_number_of_rooms() {
	    pageObjectManager.getSearchPage().noOfRooms();
	   
	}

	@When("User enter the check in date")
	public void user_enter_the_check_in_date() {
	    pageObjectManager.getSearchPage().checkIn();
	   
	}

	@When("User enter the check out date")
	public void user_enter_the_check_out_date() {
	    
	   pageObjectManager.getSearchPage().checkOut();
	}

	@When("User select the adult count")
	public void user_select_the_adult_count() {
	    pageObjectManager.getSearchPage().adultRoom();
	   
	}

	@When("User select the children count")
	public void user_select_the_children_count() {
	    
	   pageObjectManager.getSearchPage().childRoom();
	}

	@When("User click on the search button")
	public void user_click_on_the_search_button() {
	    
	   pageObjectManager.getSearchPage().clickSearchButton();
	}

	@When("User click the hotel information")
	public void user_click_the_hotel_information() {
	    pageObjectManager.getSelectHotel().hotelSelect();
	   
	}

	@When("User click on the continue button")
	public void user_click_on_the_continue_button() {
	    
	   pageObjectManager.getSelectHotel().continueButton();
	}

	@When("User enter the first name")
	public void user_enter_the_first_name() {
	    pageObjectManager.getBookHotel().firstName();
	   
	}

	@When("User enter the last name")
	public void user_enter_the_last_name() {
	    
	   pageObjectManager.getBookHotel().lastName();
	}

	@When("User enter the billing address")
	public void user_enter_the_billing_address() {
	   pageObjectManager.getBookHotel().billingAddress(); 
	   
	}

	@When("User enter the credit card number")
	public void user_enter_the_credit_card_number() {
	    
	   pageObjectManager.getBookHotel().creditCardNumber();
	}

	@When("User select the credit card type")
	public void user_select_the_credit_card_type() {
	    
	   pageObjectManager.getBookHotel().creditCardtype();
	}

	@When("User select the expiry date")
	public void user_select_the_expiry_date() {
	    pageObjectManager.getBookHotel().cardExpiryDate();
	   
	}

	@When("User enter CVV number")
	public void user_enter_cvv_number() throws InterruptedException {
	    
	   pageObjectManager.getBookHotel().cvvNumber();
	   pageObjectManager.getBookHotel().bookNowButton();
	}

	@When("User click on the book now button")
	public void user_click_on_the_book_now_button() throws InterruptedException {
		Thread.sleep(3000);
	    pageObjectManager.getBookingConfirmation().clickItineraryButton();
	   
	}

	@When("User click on my Itinerary button")
	public void user_click_on_my_itinerary_button() throws InterruptedException {
		Thread.sleep(5000);
	   pageObjectManager.getBookedItineraryPage().orderId(); 
	   
	}

	@When("User enter the order Id and click on go button")
	public void user_enter_the_order_id_and_click_on_go_button() {
	    pageObjectManager.getBookedItineraryPage().clickGoButton();
	   
	}
	
	@When("User click the logout button")
	public void user_click_the_logout_button() {
	    pageObjectManager.getBookedItineraryPage().clickLogoutButton();
	   
	}
	@When("User terminates the browser")
	public void user_terminates_the_browser() {
        terminateBrowser();
	}


	
}
