package gr.hua.dit.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;

import gr.hua.dit.entity.Service;

@Repository
public class ServiceDAOImpl implements ServiceDAO {
	// inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Service> getServices() {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create a query
		Query<Service> query = currentSession.createQuery("from Service order by service_id", Service.class);

		// System.out.println(query);
		// execute the query and get the results list
		List<Service> services = query.getResultList();

		// return the results
		return services;
	}

	@Override
	@Transactional
	public void saveService(Service service) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// save the customer
		currentSession.save(service);

	}
	
	@Override
	@Transactional
	public void updateService(Service service) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// save the customer
		currentSession.update(service);

	}

	@Override
	public Service getService(int service_id) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// get and return Customer
		Service service = currentSession.get(Service.class, service_id);
		return service;
	}

	@Override
	@Transactional
	public void deleteService(int service_id) {

		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// find the customer
		Service service = currentSession.get(Service.class, service_id);

		// delete customer
		currentSession.delete(service);
	}

}
