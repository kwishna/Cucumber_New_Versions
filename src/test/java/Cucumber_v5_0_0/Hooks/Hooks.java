package Cucumber_v5_0_0.Hooks;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java8.Scenario;

public class Hooks {

	@After(order = 1)
	public void after1(Scenario s){
		System.out.println("After Each Scenario order1");
	}

	@After(order = 2)
	public void after2(Scenario s){
		System.out.println("After Each Scenario order2");
	}

	@Before("@int")
	public void before1(Scenario s){
		System.out.println("Before Each Scenario @int");
	}

	@AfterStep
	public void afterEachStep(Scenario s){
		System.out.println("After Each Step");
	}
}
