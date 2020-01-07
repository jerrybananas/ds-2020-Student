package gr.hua.dit.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gr.hua.dit.entity.University;

@Repository
public class UniversityDAOImpl implements UniversityDAO {
	// inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<University> getUniversities() {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		// create a query
		Query<University> query = currentSession.createQuery("from University order by uni_id", University.class);
		// execute the query and get the results list
		List<University> universities = query.getResultList();

		// return the results
		return universities;
	}

	@Override
	public void saveUniversity(University university) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// save the customer
		currentSession.save(university);

	}
	
	@Override
	@Transactional
	public void updateUniversity(University university) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// save the customer
		currentSession.update(university);

	}

	@Override
	public University getUniversity(int uni_id) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// get and return Customer
		University university = currentSession.get(University.class, uni_id);
		return university;
	}

	@Override
	@Transactional
	public void deleteUniversity(int uni_id) {

		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// find the customer
		University university = currentSession.get(University.class, uni_id);

		// delete customer
		currentSession.delete(university);
	}

}
