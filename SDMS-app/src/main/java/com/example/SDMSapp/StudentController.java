package com.example.SDMSapp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
	@Autowired
	StudentRepository sp;
	@PostMapping("/save")
	public Student saveStudent(@RequestBody Student student) {
		Student student1 = sp.save(student);
		return student1;
	}

	@RequestMapping(value = "/")
	public String hello() {
		return "Welcome to Batch-13 Student details.\nHere you can Put, post, Delete, Update and GET the Student details";
	}
	
	@GetMapping("/findAll")
	public List<Student> getStudents(@RequestBody Student student){
		List<Student> student2 = sp.findAll();
		return student2;
	}
	
	@GetMapping("/findById/{id}")
	public Student getStudent(@PathVariable int id) {
		Student student3 = sp.findById(id).orElse(null);
		return student3;
	}
	
	@PutMapping("/update/{id}")
	public Student updateStudent(@PathVariable int id, @RequestBody Student student) {
		Student student4 = sp.findById(id).orElse(null);
		student4.setName(student.getName());
		student4.setEnglish(student.getEnglish());
		student4.setKannada(student.getKannada());
		student4.setChemistry(student.getChemistry());
		student4.setBiology(student.getBiology());
		student4.setMaths(student.getMaths());
		student4.setScience(student.getScience());
		sp.save(student4);
		return student4;
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable int id){
		sp.deleteById(id);
		return new ResponseEntity<String>("Student deleted successfully", HttpStatus.OK);
		
	}
}

