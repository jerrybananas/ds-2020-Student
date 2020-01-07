/*package gr.hua.dit.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import gr.hua.dit.entity.University;
import gr.hua.dit.entity.UserList;
import gr.hua.dit.service.UniversityService;
import gr.hua.dit.service.UserService;

@RestController
@RequestMapping("/user")
public class ApiController {
	
	@Autowired
	private UniversityService universityservice;
	

	/*
	 * @RequestMapping(value = "/checklogin", method = RequestMethod.POST, produces
	 * = { "application/json", "application/xml" }) public boolean
	 * CheckLogin(@RequestParam("mail") String mail, @RequestParam("password")
	 * String password) { return loginservice.checkLogin(mail,password);
	 * 
	 * }
	 *
	
	@RequestMapping(value="/delete/{id}", method= RequestMethod.DELETE, produces = { "application/json", "application/xml" })
	public ResponseEntity deleteUniversity1(@PathVariable("id") int id) {

		System.out.println(id);
		universityservice.deleteUniversity(id);
		return new ResponseEntity(HttpStatus.OK);
	}
	
	

}*/
