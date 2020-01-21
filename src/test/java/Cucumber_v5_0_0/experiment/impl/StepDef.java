package Cucumber_v5_0_0.experiment.impl;

import Cucumber_v5_0_0.experiment.impl.Student;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java8.En;
import io.cucumber.java8.Scenario;

public class StepDef implements En {

	public StepDef(){

		Given("My Name Is {string} And Email Is email", (String rowNum, DataTable table) -> {

			System.out.println(table.asList().get(Integer.parseInt(rowNum)));
		});

		Given("(s)he is my first scenario", (Student stu) -> {
			// Write code here that turns the phrase above into concrete actions
			System.out.println("Given Implemented - "+stu.toString());
			assert false;
		});

		When("(s)he is my second scenario", () -> {
			// Write code here that turns the phrase above into concrete actions
			System.out.println("When Implemented - ");
			assert true;
		});
	}

	@Before
	public void capture_scenario(Scenario scenario){
		System.out.println(scenario.getName());
	}
}
