/*
 * Note: This file implementation moved to parallel folder structre in order to implement TestNG 
 * Do Execute:  > src/test/java/parallel-ParallelRunner.java run this file for execution
 * 
*/


package testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features= {"src/test/resources/AppFeatures"},
					glue = {"stepDefinitions","AppHooks"},
					plugin = {"pretty",
							"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
							"timeline:test-output-thread/"
							
							 }
				 )
public class Guru99TestRunner {

}
