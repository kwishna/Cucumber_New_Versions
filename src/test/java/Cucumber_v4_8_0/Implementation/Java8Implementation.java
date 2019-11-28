package Cucumber_v4_8_0.Implementation;

import io.cucumber.java8.En;

public class Java8Implementation implements En {

	public Java8Implementation() {

		Given("User Browser Opens", (io.cucumber.datatable.DataTable dataTable) -> {

			System.out.println(dataTable.asLists());
		});

		When("User Opens {string}", (String string) -> {

			System.out.println("------------- "+string);
		});

		Then("User Enters Search Keyword {string} and {string}", (String key, String th) -> {

			System.out.println("------------- "+key+th);
		});

		Then("Hits Search Bar", () -> {

			System.out.println("-------------");
		});

		Then("Search Results Should Appear", () -> {

			System.out.println("-------------");
		});

	}
}
