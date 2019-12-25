package Cucumber_v4_8_0.experiment.impl;

import io.cucumber.core.api.TypeRegistry;
import io.cucumber.core.api.TypeRegistryConfigurer;
import io.cucumber.cucumberexpressions.ParameterByTypeTransformer;
import io.cucumber.cucumberexpressions.ParameterType;
import io.cucumber.datatable.*;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.ObjectMapper;

import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

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
		typeRegistry.setDefaultParameterTransformer(new ParameterByTypeTransformer(){
			private final ObjectMapper objectMapper = new ObjectMapper();
			@Override
			public Object transform(String fromValue, Type toValueType) throws Throwable {
				return objectMapper.convertValue(fromValue, objectMapper.constructType(toValueType));
			}
		});


		typeRegistry.setDefaultDataTableEntryTransformer(new TableEntryByTypeTransformer(){
			private final ObjectMapper objectMapper = new ObjectMapper();

			@Override
			public <T> T transform(Map<String, String> entry, Class<T> type, TableCellByTypeTransformer cellTransformer) {
				return objectMapper.convertValue(entry, type);
			}
		});


		typeRegistry.setDefaultDataTableCellTransformer(new TableCellByTypeTransformer (){
			private final ObjectMapper objectMapper = new ObjectMapper();

			@Override
			public <T> T transform(String value, Class<T> cellType) {
				return objectMapper.convertValue(value, cellType);
			}
		});




		//**************** DataTable****************
		typeRegistry.defineDataTableType(new DataTableType(Student.class, new TableEntryTransformer<Student>() {
			@Override
			public Student transform(Map<String, String> entry) {
				return Student.createStudent(entry.get("name"), entry.get("roll"));
			}
		}));

		typeRegistry.defineDataTableType(new DataTableType(Student.class, new TableCellTransformer<Student>() {
			@Override
			public Student transform(String cell) {
				return Student.createStudentOne(cell.toUpperCase());
			}
		}));

//		typeRegistry.defineDataTableType(new DataTableType(Student.class, new TableRowTransformer<Student>() {
//			@Override
//			public Student transform(List<String> row) {
//				return Student.createStudentTwo(row);
//			}
//		}));

		typeRegistry.defineDataTableType(new DataTableType(Student.class, new TableTransformer<Student>() {
			@Override
			public Student transform(DataTable table) throws Throwable {
				List<Student> lects = table.asMaps().stream().map(m -> Student.createStudent(m.get("name"), m.get("roll")))
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