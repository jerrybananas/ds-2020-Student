package gr.hua.dit.dao;

import java.util.List;

import gr.hua.dit.entity.User;

public interface UserDAO {

	public List<User> getUsers();

	public void saveUser(User user);
	
	public void updateUser(User user);
	
	public User getUser(int user_id);

	public void deleteUser(int user_id);
	
}
