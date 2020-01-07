package gr.hua.dit.dao;

import java.util.List;

import gr.hua.dit.entity.University;

public interface UniversityDAO {

	public List<University> getUniversities();

	public void saveUniversity(University university);
	
	public void updateUniversity(University university);
	
	public University getUniversity(int university_id);

	public void deleteUniversity(int university_id);
	
}
