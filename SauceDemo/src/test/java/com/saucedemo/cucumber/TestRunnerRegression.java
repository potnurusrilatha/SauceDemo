package com.saucedemo.cucumber;

import cucumber.api.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)

@CucumberOptions(
        features = "src\\test\\java\\com\\saucedemo\\cucumber\\featuresTes",        
//        glue = "classpath:src/test/java/com/saucedemo/cucumber/steps/LoginStep.java",
        format = {
                "json:target/cucumber-regression.json",
                "pretty",	
                "html:target/cucumber/reports"}
)
public class TestRunnerRegression {

	
		public static void main(String[] args) {
//		    PropertyReader propertyReader;
		   //String environmenttype = propertyReader.getProperty("environment");
		}
}