package gr.hua.dit.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gr.hua.dit.dao.UniversityDAO;
import gr.hua.dit.entity.University;

@Service
public class UniversityServiceImpl implements UniversityService {

	// inject the CustomerDAO
	@Autowired
	private UniversityDAO uniDAO;
	
	@Override
	@Transactional
	public List<University> getUniversities() {
		return uniDAO.getUniversities();
	}

	@Override
	@Transactional
	public void saveUniversity(University uni) {
		uniDAO.saveUniversity(uni);
	}
	
	@Override
	@Transactional
	public void updateUniversity(University uni) {
		uniDAO.updateUniversity(uni);
	}

	@Override
	@Transactional
	public University getUniversity(int uni_id) {
		return uniDAO.getUniversity(uni_id);
	}

	@Override
	@Transactional
	public void deleteUniversity(int uni_id) {
		uniDAO.deleteUniversity(uni_id);
	}

}
