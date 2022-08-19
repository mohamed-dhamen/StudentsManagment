package com.mohameddahmane.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mohameddahmane.dao.StudentDAO;
import com.mohameddahmane.dto.StudentDTO;
import com.mohameddahmane.models.Student;

@Controller
public class StudentController {
	
	@Autowired
	private StudentDAO studentdao;
	
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String homePage() { 
		return "index";
	}
	
	@RequestMapping(value="showstudent",method=RequestMethod.GET)
	public String showStudentInfo(Model model) {
		List<Student >students=studentdao.getAllStudents();
				for(Student st:students) {
					System.out.println(st);
				}
			model.addAttribute("students", students);
			
			return "student-list";
	}
	

	@RequestMapping(value="/addStudent", method=RequestMethod.GET)
	public String addStudent(Model model) {
		 StudentDTO studentDTO = new StudentDTO();
		model.addAttribute("student",studentDTO);
		return "add-student";
	}
	
	@RequestMapping(value="/saveStudent", method=RequestMethod.POST)
	public String addStudent(Student  student) {
		studentdao.addStudent(student); 
		return "redirect:/showstudent";
	}
	
	

}
