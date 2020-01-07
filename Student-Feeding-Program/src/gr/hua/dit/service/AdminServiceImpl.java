package gr.hua.dit.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gr.hua.dit.dao.AdminDAO;
import gr.hua.dit.entity.Admin;

@Service
public class AdminServiceImpl implements AdminService {

	// inject the CustomerDAO
	@Autowired
	private AdminDAO AdminDAO;
	
	@Override
	@Transactional
	public List<Admin> getAdmins() {
		return AdminDAO.getAdmins();
	}

	@Override
	@Transactional
	public void saveAdmin(Admin Admin) {
		AdminDAO.saveAdmin(Admin);
	}

	@Override
	@Transactional
	public Admin getAdmin(int Admin_id) {
		return AdminDAO.getAdmin(Admin_id);
	}

	@Override
	@Transactional
	public void deleteAdmin(int Admin_id) {
		AdminDAO.deleteAdmin(Admin_id);
	}

}
