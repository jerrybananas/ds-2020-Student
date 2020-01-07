package gr.hua.dit.service;

import java.util.List;

import gr.hua.dit.entity.Service;

public interface ServiceService {
	public List<Service> getServices();

	public void saveService (Service service);
	
	public void updateService (Service service);
	
	public Service getService(int service_id);

	public void deleteService(int service_id);
}
