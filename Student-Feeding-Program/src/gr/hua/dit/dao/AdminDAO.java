package gr.hua.dit.dao;

import java.util.List;

import gr.hua.dit.entity.Admin;


public interface AdminDAO {

	public List<Admin> getAdmins();

	public void saveAdmin(Admin admin);
	
	public Admin getAdmin(int admin_id);

	public void deleteAdmin(int admin_id);
	
}
