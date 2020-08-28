package Cucumber_v6_4_0.Implementation;

import io.cucumber.datatable.DataTable;
import io.cucumber.java8.En;

public class Java8Implementation implements En {

	public Java8Implementation() {

		Given("My Name Is {string} And Email Is email", (String rowNum, DataTable table) -> {

			System.out.println(table.asList().get(Integer.parseInt(rowNum)));
		});

		Given("User Browser Opens", (DataTable dataTable) -> {

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
