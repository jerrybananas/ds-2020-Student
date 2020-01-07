package gr.hua.dit.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gr.hua.dit.entity.Student;

@Repository
public class StudentDAOImpl implements StudentDAO {
	// inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Student> getStudents() {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create a query
		Query<Student> query = currentSession.createQuery("from Student order by student_last_name", Student.class);

		// System.out.println(query);
		// execute the query and get the results list
		List<Student> students = query.getResultList();

		// return the results
		return students;
	}

	@Override
	public void saveStudent(Student student) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// save the customer
		currentSession.save(student);

	}
	
	@Override
	public void updateStudent(Student student) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// save the customer
		currentSession. update(student);

	}

	@Override
	public Student getStudent(int student_id) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// get and return Customer
		Student student = currentSession.get(Student.class, student_id);
		return student;
	}

	@Override
	public void deleteStudent(int student_id) {

		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// find the customer
		Student student = currentSession.get(Student.class, student_id);

		// delete customer
		currentSession.delete(student);
	}

}
