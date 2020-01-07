package gr.hua.dit.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gr.hua.dit.dao.ServiceDAO;

@Service
public class ServiceServiceImpl implements ServiceService {

	// inject the CustomerDAO
	@Autowired
	private ServiceDAO serviceDAO;
	
	@Override
	@Transactional
	public List<gr.hua.dit.entity.Service> getServices() {
		return serviceDAO.getServices();
	}

	@Override
	public void saveService(gr.hua.dit.entity.Service service) {
		serviceDAO.saveService(service);		
	}
	
	@Override
	public void updateService(gr.hua.dit.entity.Service service) {
		serviceDAO.updateService(service);		
	}

	@Override
	public gr.hua.dit.entity.Service getService(int service_id) {
		return serviceDAO.getService(service_id);
	}

	@Override
	public void deleteService(int service_id) {
		serviceDAO.deleteService(service_id);		
	}

}
