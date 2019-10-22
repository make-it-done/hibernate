package com.rohit;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rohit.entity.NotFoundException;
import com.rohit.entity.Student;

@Controller
public class ControllerClass {

	@RequestMapping("/test")
	public String test() {
		return "My name is Rohit Kumar";
	}

	@RequestMapping("/test/{testValue}")
	public String testValue(@PathVariable int testValue) throws Exception {
		if (testValue > 15)
			throw new NotFoundException("got value greater than 15 resource not found");
		else
			return "I got " + testValue + " as an input";
	}

	@RequestMapping("/stringTest/{firstName}")
	public Student getName(@PathVariable String firstName) {
		Student student = new Student(firstName, "Kumar", "Islampur");
		return student;
	}

}
