package com.runnerclass;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;




@RunWith(Cucumber.class)
@CucumberOptions(features = ".\\src\\test\\resources\\Feature\\Adactin.feature",    

                 glue = {"com.step"},
                 dryRun =!true,
                 plugin = {"pretty",
                		 "html:Reports/AdactinHTMLReports.html",
                		 "json:Reports/AdactinJSONReports.json",
                		 "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                         }
		
		          // tags= "@smoke"
		
		
		
		
		
		
		)

public class AdactinRunner {
	
	}
