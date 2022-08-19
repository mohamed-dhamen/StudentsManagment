package com.mohameddahmane.dao;

import java.util.List;

import javax.sql.DataSource;

import com.mohameddahmane.models.Student;

public interface StudentDAO {
	 public List<Student> getAllStudents();
	 public void addStudent(Student student);
	 public Student getStudentById(int id);
	 public int deletStudent(int id);
	 public int updateStudent(Student student);
	 public void setDataSource(DataSource dataSource);

}
