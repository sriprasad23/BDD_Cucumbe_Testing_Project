package parallel;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		plugin = {"pretty",
					"rerun:target/failedRerun.txt" 
					},
		
					glue= {"parallel"},
					features= {"@target/failedRerun.txt"}		
					 
		 )


public class FailedRun extends AbstractTestNGCucumberTests {
	
	@Override
	@DataProvider(parallel=true)
	public Object [][] scenarios(){
		return super.scenarios();
		
	}

}
