package gr.hua.dit.service;

import java.util.List;

import gr.hua.dit.entity.Student;

public interface StudentService {
	public List<Student> getStudents();

	public void saveStudent(Student student);
	
	public void updateStudent(Student student);
	
	public Student getStudent(int student_id);

	public void deleteStudent(int student_id);
}
