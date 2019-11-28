package Cucumber_v4_7_2.Implementation;
import io.cucumber.java8.En;
import io.cucumber.datatable.DataTable;

public class Java8Implementation implements En {

	public Java8Implementation() {

		Given("User Browser Opens", (DataTable dataTable) -> {

			System.out.println(dataTable.asLists());
		});

		When("User Opens '{}'", (String url) -> {
			
			System.out.println("------------- "+url);
		});

		Then("User Enters Search Keyword {} and {}", (String key, String th) -> {
			
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
