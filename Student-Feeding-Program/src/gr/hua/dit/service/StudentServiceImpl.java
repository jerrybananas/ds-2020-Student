package gr.hua.dit.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gr.hua.dit.dao.StudentDAO;
import gr.hua.dit.entity.Student;

@Service
public class StudentServiceImpl implements StudentService {

	// inject the CustomerDAO
	@Autowired
	private StudentDAO studentDAO;
	
	@Override
	@Transactional
	public List<Student> getStudents() {
		return studentDAO.getStudents();
	}

	@Override
	@Transactional
	public void saveStudent(Student student) {
		studentDAO.saveStudent(student);
	}
	
	@Override
	@Transactional
	public void updateStudent(Student student) {
		studentDAO.updateStudent(student);
	}

	@Override
	@Transactional
	public Student getStudent(int student_id) {
		return studentDAO.getStudent(student_id);
	}

	@Override
	@Transactional
	public void deleteStudent(int student_id) {
		studentDAO.deleteStudent(student_id);
	}

	

}
