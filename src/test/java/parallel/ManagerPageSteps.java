package parallel;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.pages.LoginPage;
import com.pages.ManagerPage;
import com.qa.factory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ManagerPageSteps {
	
	private static String title;
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private ManagerPage managerpage;
	
	@Given("User has already logged into an Application")
	public void user_has_already_logged_into_an_application(DataTable ManagerTable) {
		
		List<Map<String, String>> managerList = ManagerTable.asMaps();
		String userName = managerList.get(0).get("username"); 
		String password = managerList.get(0).get("password");
		DriverFactory.getDriver().get("https://demo.guru99.com/V4/index.php");
		managerpage = loginPage.doLogin(userName, password);
	    
	}

	@Given("User is on Manager Page")
	public void user_is_on_manager_page() {
		managerpage.getManagersPageTitle();
		 
		 	
	}
	@When("User gets the title of the page")
	public void user_gets_the_title_of_the_page() {
		title = loginPage.getLoginPageTitle();
		System.out.println("Page title is: " + title);
		
		
	}
	
	@Then("Page title should be {string}")
	public void page_title_should_be(String expectedTitleName) {
		
		System.out.println(title);
	}

	@Then("Then Page title should be {string}")
	public void then_page_title_should_be(String string, DataTable managerTable) {
		List<String> expManagerSectionsList = managerTable.asList();
		System.out.println("Expected manager section list: "+expManagerSectionsList);
		List<String> actualManagerSectionsList = managerpage.getManagerSectionList();
		System.out.println("Actual manager section list: "+actualManagerSectionsList);
		Assert.assertTrue(expManagerSectionsList.containsAll(actualManagerSectionsList));
	   
	}

	@Then("Manager Section Counts is {int}")
	public void manager_section_counts_is(Integer expectedSectionCount) {
	//	Assert.assertTrue(managerpage.getManagerSectionCount() == expectedSectionCount);
	}

	

}
