package gr.hua.dit.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gr.hua.dit.entity.User;

@Repository
public class UserDAOImpl implements UserDAO {
	// inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<User> getUsers() {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create a query
		Query<User> query = currentSession.createQuery("from User order by user_last_name", User.class);

		// System.out.println(query);
		// execute the query and get the results list
		List<User> users = query.getResultList();

		// return the results
		return users;
	}

	@Override
	public void saveUser(User user) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// save the customer
		currentSession.save(user);

	}
	
	@Override
	public void updateUser(User user) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// save the customer
		currentSession.update(user);

	}

	@Override
	public User getUser(int user_id) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// get and return Customer
		User user = currentSession.get(User.class, user_id);
		return user;
	}

	@Override
	public void deleteUser(int user_id) {

		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// find the customer
		User user = currentSession.get(User.class, user_id);

		// delete customer
		currentSession.delete(user);
	}

}
