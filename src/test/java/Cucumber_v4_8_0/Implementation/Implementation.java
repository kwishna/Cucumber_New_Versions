package Cucumber_v4_8_0.Implementation;

import Pages.PageOne;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Implementation {

	/*PageOne one;

	@Given("User Browser Opens")
	public void user_Browser_Opens(DataTable table) {
		one = new PageOne();
		System.out.println("Opennig Browser \n" + table);
	}

	@When("User Opens {string}")
	public void user_Opens(String url) {

		one.opens(url);
		System.out.println("user_Opens " + url);
	}

	@Then("User Enters Search Keyword \'(.*)\' and \"(.*)\"")
	public void user_Enters_Search_Keyword(String keyword, String th) {

		one.enterKeyword(keyword);
		System.out.println("user_Enters_Search_Keyword " + keyword +" And "+th);
	}

	@Then("Hits Search Bar")
	public void hits_Search_Bar() {

		one.hitEnter();
		System.out.println("hits_Search_Bar ");
	}

	@Then("Search Results Should Appear")
	public void search_Results_Should_Appear() {
		System.out.println("search_Results_Should_Appear ");
		one.verifyResultCount();
	}*/
}
