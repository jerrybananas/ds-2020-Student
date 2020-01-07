package gr.hua.dit.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gr.hua.dit.entity.Admin;


@Repository
public class AdminDAOImpl implements AdminDAO {
	// inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Admin> getAdmins() {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		System.out.println("hey");
		// create a query
		Query<Admin> query = currentSession.createQuery("from Admin order by last_name", Admin.class);
		System.out.println("hey");
		// System.out.println(query);
		// execute the query and get the results list
		List<Admin> admins = query.getResultList();

		// return the results
		return admins;
	}

	@Override
	public void saveAdmin(Admin admin) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// save the customer
		currentSession.save(admin);

	}

	@Override
	public Admin getAdmin(int admin_id) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// get and return Customer
		Admin admin = currentSession.get(Admin.class, admin_id);
		return admin;
	}

	@Override
	public void deleteAdmin(int admin_id) {

		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// find the customer
		Admin admin = currentSession.get(Admin.class, admin_id);

		// delete customer
		currentSession.delete(admin);
	}

}
