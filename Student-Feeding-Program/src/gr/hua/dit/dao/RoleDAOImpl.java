package gr.hua.dit.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gr.hua.dit.entity.Role;

@Repository
public class RoleDAOImpl implements RoleDAO {
	// inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Role> getRoles() {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		// create a query
		Query<Role> query = currentSession.createQuery("from Role order by role_user_id", Role.class);
		// execute the query and get the results list
		List<Role> roles = query.getResultList();
		//System.out.println(roles.toString());		
		//return the results
		return roles;
	}

	@Override
	public void saveRole(Role role) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save the customer
		currentSession.save(role);
		
	}

	@Override
	public Role getRole(String role_name) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//get and return Customer
		Role user = currentSession.get(Role.class, role_name);
		return user;
	}

	@Override
	public void deleteRole(String role_name) {
		
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// find the customer
		Role user = currentSession.get(Role.class, role_name);

		
		// delete customer
		currentSession.delete(user);
	}

}
