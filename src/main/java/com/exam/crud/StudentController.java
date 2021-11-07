package com.exam.crud;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
//@RestController  //use this if the response need JSON object ad API for other applicatrion or whatever. 
@CrossOrigin("*")
@RequestMapping("/students/")
public class StudentController {
	private final StudentRepository studentRepository;
	@Autowired
	public StudentController(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}

	@GetMapping
	public String studentsAll(Model model) {
		model.addAttribute("students", studentRepository.findAll());
		return "studentlist";
	}
	
	@GetMapping("/sts")
	  List<Student> all() {
	    return (List<Student>) studentRepository.findAll();
	  }

	@GetMapping("add")
	public String showSaveStudent(Student student) {
		return "savestudent";
	}

	@PostMapping("add")
	public String SaveStudent(@Valid Student student, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "savestudent";
		}
		studentRepository.save(student);
		model.addAttribute("students", studentRepository.findAll());
		return "redirect:/students/";
	}

	@GetMapping("edit/{id}")
	public String showUpdateStudent(@PathVariable("id") Long id, Model model) {
		Student student = studentRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
		model.addAttribute("student", student);
		return "updatestudent";
	}

	@PostMapping("update/{id}")
	public String updateStudent(@PathVariable("id") Long id, @Valid Student student, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			student = studentRepository.findById(id)
					.orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
			return "updatestudent";
		}
		studentRepository.save(student);
		model.addAttribute("students", studentRepository.findAll());
		return "redirect:/students/";
	}

	@GetMapping("delete/{id}")
	public String deleteStudent(@PathVariable("id") Long id, Model model) {
		Student student = studentRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
		studentRepository.delete(student);
		model.addAttribute("students", studentRepository.findAll());
		return "redirect:/students/";
	}

}
