package Cucumber_v5_0_0.experiment.impl;

import Cucumber_v5_0_0.experiment.impl.Student;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.core.api.TypeRegistry;
import io.cucumber.core.api.TypeRegistryConfigurer;
import io.cucumber.cucumberexpressions.ParameterByTypeTransformer;
import io.cucumber.cucumberexpressions.ParameterType;
import io.cucumber.datatable.*;

import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

//import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.ObjectMapper; // Removed In v5.0.0

/**
 * v5.0.0 Onwards. TypeRegistryConfigurer Deprecated!
 * See <a href="https://github.com/cucumber/cucumber-jvm/blob/master/examples/java-calculator/src/test/java/io/cucumber/examples/java/ShoppingSteps.java">Annotation based example</a>
 * See <a href="https://github.com/cucumber/cucumber-jvm/blob/master/examples/java8-calculator/src/test/java/io/cucumber/examples/java8/ShoppingSteps.java">Lambda based example</a>
 */
public class CustomTransformer implements TypeRegistryConfigurer {

	@Override
	public Locale locale() {
		return Locale.ENGLISH;
	}

	@Override
	public void configureTypeRegistry(TypeRegistry typeRegistry) {

		//**************** default parameter transformer **************
		/**
		 *
		 * https://grasshopper.tech/311/
		 * https://grasshopper.tech/340/
		 * For Default Convert :
		 * Given Customer John orders COFFEE
		 * Given Customer Jane orders LEMONADE
		 *
		 * @Given("Customer {customer} orders {beverage}") // If Not Using setDefaultParameterTransformer
		 * @Given("Customer {} orders {}") // If Using setDefaultParameterTransformer
		 *
		 * public void customerOrders(Customer customer, Beverage beverage) {
		 *     System.out.println("Customer name is " + customer.getName() + " orders " + beverage);
		 * }
		 *
		 */
		typeRegistry.setDefaultParameterTransformer(new ParameterByTypeTransformer() {
			private final ObjectMapper objectMapper = new ObjectMapper();

			@Override
			public Object transform(String fromValue, Type toValueType) throws Throwable {
				return objectMapper.convertValue(fromValue, objectMapper.constructType(toValueType));
			}
		});


		typeRegistry.setDefaultDataTableEntryTransformer(new TableEntryByTypeTransformer() {

			private final ObjectMapper objectMapper = new ObjectMapper();

			@Override
			public Object transform(Map<String, String> map, Type type, TableCellByTypeTransformer tableCellByTypeTransformer) throws Throwable {
				return objectMapper.constructType(type);
			}
		});


		typeRegistry.setDefaultDataTableCellTransformer(new TableCellByTypeTransformer() {

			private final ObjectMapper objectMapper = new ObjectMapper();

			@Override
			public Object transform(String s, Type type) throws Throwable {
				return objectMapper.constructType(type);
			}

		});


		//**************** DataTable****************
		typeRegistry.defineDataTableType(new DataTableType(Cucumber_v5_0_0.experiment.impl.Student.class, new TableEntryTransformer<Cucumber_v5_0_0.experiment.impl.Student>() {
			@Override
			public Cucumber_v5_0_0.experiment.impl.Student transform(Map<String, String> entry) {
				return Cucumber_v5_0_0.experiment.impl.Student.createStudent(entry.get("name"), entry.get("roll"));
			}
		}));

		typeRegistry.defineDataTableType(new DataTableType(Cucumber_v5_0_0.experiment.impl.Student.class, new TableCellTransformer<Cucumber_v5_0_0.experiment.impl.Student>() {
			@Override
			public Cucumber_v5_0_0.experiment.impl.Student transform(String cell) {
				return Cucumber_v5_0_0.experiment.impl.Student.createStudentOne(cell.toUpperCase());
			}
		}));

//		typeRegistry.defineDataTableType(new DataTableType(Student.class, new TableRowTransformer<Student>() {
//			@Override
//			public Student transform(List<String> row) {
//				return Student.createStudentTwo(row);
//			}
//		}));

		typeRegistry.defineDataTableType(new DataTableType(Cucumber_v5_0_0.experiment.impl.Student.class, new TableTransformer<Cucumber_v5_0_0.experiment.impl.Student>() {
			@Override
			public Cucumber_v5_0_0.experiment.impl.Student transform(DataTable table) throws Throwable {
				List<Cucumber_v5_0_0.experiment.impl.Student> lects = table.asMaps().stream().map(m -> Cucumber_v5_0_0.experiment.impl.Student.createStudent(m.get("name"), m.get("roll")))
						.collect(Collectors.toList());
				return Student.createStudentThree(lects);
			}
		}));

		// *************** parameter or examples ****************
		/**
		 * ParameterType
		 * "user",     -> Maps to the pattern mentioned in the stepdefinition expression {user}
		 * ".*?",      -> Regular expression for matching
		 * User.class, -> Desired object class
		 * User::new   -> Transformation code, kind of similar to what is written in unmarshal() of custom XStream converter
		 *
		 *  Given the student is Krishna
		 * /
		 typeRegistry.defineParameterType(new ParameterType<Student>("student", ".*?",
		 Student.class, (String s) -> new Student(s)));

		 /**
		 * Given the student are jane,john,colin,alice
		 */
		typeRegistry.defineParameterType(new ParameterType<List>("student", ".*?", List.class, (String s) -> Arrays.asList(s.split(","))));

		/**
		 * Given the date is 2017-11-05T09:54:13
		 */
		typeRegistry.defineParameterType(new ParameterType<LocalDateTime>("date_iso_local_date_time", "\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}",
				LocalDateTime.class, (String s) -> LocalDateTime.parse(s)));
	}
}