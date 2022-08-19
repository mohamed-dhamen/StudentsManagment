package com.mohameddahmane.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.mohameddahmane.models.Student;
import com.mohameddahmane.rowmapper.StudentRowMapper;

public class StudentDAOImp implements StudentDAO {
	
	
	private JdbcTemplate jdbcTemplate;
	private DataSource dataSource;
	
	public StudentDAOImp(DataSource dataSource) {
		jdbcTemplate=new JdbcTemplate(dataSource);
	}
	

	@Override
	public List<Student> getAllStudents() {
		String sql="SELECT * FROM `student`;";
		List<Student> students=jdbcTemplate.query(sql, new StudentRowMapper());
		
		return students;
	}

	@Override
	public void addStudent(Student student) {
		Object[] studentInfo= {student.getName(),student.getAge(),student.getCity(),student.getStudent_id()};
		String sql="INSERT INTO `student`(`name`, `age`, `city`, `student_id`) VALUES (?,?,?,?)";
			jdbcTemplate.update(sql,studentInfo);
			
	}

	@Override
	public Student getStudentById(int id) {
		String sql="SELECT `name`, `age`, `city`, `student_id`, `id` FROM `student` WHERE id=?";
		return jdbcTemplate.queryForObject(sql,new Object[] {id},new StudentRowMapper());
	}

	@Override
	public int deletStudent(int id) {
		String sql = "DELETE FROM `student` WHERE `id`="+id;
		return jdbcTemplate.update(sql);
	}


	@Override
	public int updateStudent(Student student) {
		String sql = "UPDATE `student` SET `student_id`='"+student.getStudent_id()
        +"',`name`='"+student.getName()+"',`city`='"+student.getCity()
        +"',`age`='"+student.getAge()+"' WHERE  `id`="+student.getId();
	
		return jdbcTemplate.update(sql);
	}
	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

}
