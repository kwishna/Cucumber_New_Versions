package Cucumber_v5_0_0.experiment.impl;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Student {

	private String name;
	private String roll;

	private Student(String name, String roll){
		this.name = name;
		this.roll = roll;
	}

	public Student(String s) {
		this.name = RandomStringUtils.randomAlphabetic(5);
		this.roll = ""+ThreadLocalRandom.current().nextInt(100);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRoll() {
		return roll;
	}

	public void setRoll(String roll) {
		this.roll = roll;
	}

	public static Student createStudent(String name, String roll){
		return new Student(name+" createStudent", roll);
	}

	public static Student createStudentOne(String name){
		return new Student(name+" createStudentOne", ""+ThreadLocalRandom.current().nextInt(100));
	}

	public static Student createStudentTwo(List<String> li){
		return new Student(li.get(0)+" createStudentTwo", li.get(ThreadLocalRandom.current().nextInt(li.size())));
	}

	public static Student createStudentThree(List<Student> lects) {
		return lects.get(ThreadLocalRandom.current().nextInt(lects.size()));
	}

	@Override
	public String toString() {
		return this.getName() +", "+this.getRoll();
	}

}
