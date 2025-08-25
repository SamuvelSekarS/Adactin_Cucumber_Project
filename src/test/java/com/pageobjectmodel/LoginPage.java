package com.pageobjectmodel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//import com.aventstack.extentreports.ExtentTest;
import com.base.Base_Class;
import com.interfaceelement.LoginPageInterFaceElements;
import com.utility.FileReaderManager;

public class LoginPage extends Base_Class implements LoginPageInterFaceElements{

	@FindBy(id = userName_id)
	private WebElement userName;

	@FindBy(id = password_id)
	private WebElement passWord;

	@FindBy(xpath = login_xpath)
	private WebElement loginBtn;

	public LoginPage() {
		PageFactory.initElements(driver,this );
	}


	FileReaderManager data = new FileReaderManager();

	public void userName() {
		passInput(userName, data.getDataproperty("loginusername"));
	}
	public void passWord() {
		passInput(passWord, data.getDataproperty("loginpassword"));
	}
	public void clickLoginButton() {
		elementClick(loginBtn);
		System.out.println("some changes 1");
	}
}
