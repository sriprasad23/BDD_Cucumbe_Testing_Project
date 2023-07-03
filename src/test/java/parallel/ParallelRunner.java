package parallel;



import org.testng.annotations.DataProvider;


import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;




@CucumberOptions(
				plugin = {"pretty",
							"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
							"timeline:test-output-thread/", "rerun:target/failedRerun.txt" 
							},
						//	tags = "not @Skip",
							glue= {"parallel"},
							features= {"src/test/resources/parallel"}		
							 
				 )

public class ParallelRunner extends AbstractTestNGCucumberTests { 
	
	
	@Override
	@DataProvider(parallel=true)
	public Object [][] scenarios(){
		return super.scenarios();
		
	}
	

}
