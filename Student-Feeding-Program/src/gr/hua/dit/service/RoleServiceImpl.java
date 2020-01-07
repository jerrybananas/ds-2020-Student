package gr.hua.dit.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gr.hua.dit.dao.RoleDAO;
import gr.hua.dit.entity.Role;

@Service
public class RoleServiceImpl implements RoleService {

	// inject the CustomerDAO
	@Autowired
	private RoleDAO roleDAO;
	
	@Override
	@Transactional
	public List<Role> getRoles() {
		return roleDAO.getRoles();
	}

	@Override
	@Transactional
	public void saveRole(Role role) {
		roleDAO.saveRole(role);
	}

	@Override
	@Transactional
	public Role getRole(String role_name) {
		return roleDAO.getRole(role_name);
	}

	@Override
	@Transactional
	public void deleteRole(String role_name) {
		roleDAO.deleteRole(role_name);
	}

}
