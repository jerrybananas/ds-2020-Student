package gr.hua.dit.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gr.hua.dit.dao.UserDAO;
import gr.hua.dit.entity.User;

@Service
public class UserServiceImpl implements UserService {

	// inject the CustomerDAO
	@Autowired
	private UserDAO userDAO;
	
	@Override
	@Transactional
	public List<User> getUsers() {
		return userDAO.getUsers();
	}

	@Override
	@Transactional
	public void saveUser(User user) {
		userDAO.saveUser(user);
	}
	
	@Override
	@Transactional
	public void updateUser(User user) {
		userDAO.updateUser(user);
	}

	@Override
	@Transactional
	public User getUser(int user_id) {
		return userDAO.getUser(user_id);
	}

	@Override
	@Transactional
	public void deleteUser(int user_id) {
		userDAO.deleteUser(user_id);
	}

}
