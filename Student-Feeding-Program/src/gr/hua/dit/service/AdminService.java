package gr.hua.dit.service;

import java.util.List;

import gr.hua.dit.entity.Admin;

public interface AdminService {
	public List<Admin> getAdmins();

	public void saveAdmin(Admin Admin);
	
	public Admin getAdmin(int Admin_id);

	public void deleteAdmin(int Admin_id);
}
