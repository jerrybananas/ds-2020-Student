package gr.hua.dit.service;

import java.util.List;

import gr.hua.dit.entity.University;

public interface UniversityService {
	public List<University> getUniversities();

	public void saveUniversity(University uni);
	
	public void updateUniversity(University uni);
	
	public University getUniversity(int uni_id);

	public void deleteUniversity(int uni_id);
}
