package Cucumber_v4_7_2.Implementation;

import Pages.PageOne;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Implementation {

	PageOne one;

	/*@Given("User Browser Opens")
	public void user_Browser_Opens(DataTable table) {
		one = new PageOne();
		System.out.println("Opennig Browser \n" + table);
	}

	@When("User Opens (.)")
	public void user_Opens(String url) {

		one.opens(url);
	}

	@Then("User Enters Search Keyword (.)")
	public void user_Enters_Search_Keyword(String keyword) {

		one.enterKeyword(keyword);
	}

	@Then("Hits Search Bar")
	public void hits_Search_Bar() {

		one.hitEnter();
	}

	@Then("Search Results Should Appear")
	public void search_Results_Should_Appear() {

		one.verifyResultCount();
	}*/

}
