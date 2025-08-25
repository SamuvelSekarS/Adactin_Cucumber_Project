package com.pageobjectmanager;

import com.pageobjectmodel.BookedItineraryPage;
import com.pageobjectmodel.BookingConfirmationPage;
import com.pageobjectmodel.HotelBookingPage;
import com.pageobjectmodel.LoginPage;
import com.pageobjectmodel.SearchPage;
import com.pageobjectmodel.SelectHotel;
import com.utility.FileReaderManager;

public class PageObjectManager {
	
	private FileReaderManager fileReader;

	private LoginPage loginPage;
	
	private SearchPage searchPage;
	
	private SelectHotel selectHotel;
	
	private HotelBookingPage bookHotel;
	
	private BookingConfirmationPage bookingConfirmation;
	
	private BookedItineraryPage bookedItineraryPage;

	public BookedItineraryPage getBookedItineraryPage() {
		if (bookedItineraryPage == null) {
			bookedItineraryPage = new BookedItineraryPage();
			
		}
		return bookedItineraryPage;
	}

	public BookingConfirmationPage getBookingConfirmation() {
		if (bookingConfirmation == null) {
			bookingConfirmation = new BookingConfirmationPage();
		}
		return bookingConfirmation;
	}

	public FileReaderManager getFileReader() {
		return fileReader;
	}

	public HotelBookingPage getBookHotel() {
		if (bookHotel == null) {
			bookHotel = new HotelBookingPage();
		}
		return bookHotel;
	}

	public SelectHotel getSelectHotel() {
		if (selectHotel == null) {
			selectHotel = new SelectHotel();
		}
		return selectHotel;
	}

	public FileReaderManager getFileReaderManager() {
		if (fileReader == null) {
			fileReader = new FileReaderManager();
		}
		return fileReader;
	}

	public LoginPage getLoginPage() {
		if (loginPage == null) {
			loginPage = new LoginPage();
		}
		return loginPage;
	}

	public SearchPage getSearchPage() {
		if (searchPage == null) {
			searchPage = new SearchPage();
		}
		return searchPage;
	}
	
}
