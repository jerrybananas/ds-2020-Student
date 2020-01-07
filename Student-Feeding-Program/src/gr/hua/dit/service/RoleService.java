package gr.hua.dit.service;

import java.util.List;

import gr.hua.dit.entity.Role;

public interface RoleService {
	public List<Role> getRoles();

	public void saveRole (Role role);
	
	public Role getRole(String role_name);

	public void deleteRole(String role_name);
}
