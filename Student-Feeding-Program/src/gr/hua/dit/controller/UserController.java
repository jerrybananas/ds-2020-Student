package gr.hua.dit.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import gr.hua.dit.entity.Role;
import gr.hua.dit.entity.Service;
import gr.hua.dit.entity.Student;
import gr.hua.dit.entity.University;
import gr.hua.dit.entity.User;
import gr.hua.dit.service.RoleService;
import gr.hua.dit.service.ServiceService;
import gr.hua.dit.service.StudentService;
import gr.hua.dit.service.UniversityService;
import gr.hua.dit.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	// inject the customer service
	@Autowired
	private UserService userService;

	@Autowired
	private RoleService roleService;

	@Autowired
	private ServiceService serviceService;

	@Autowired
	private UniversityService universityService;

	@Autowired
	private StudentService studentService;

	User user;
	Student student2;
	University university2;

	// ##########################################################################################################################
	// Home screen
	// ##########################################################################################################################
	@GetMapping("/home")
	public String homePage(Model model) {
		List<Role> roles = roleService.getRoles();
		List<User> users = userService.getUsers();
		List<Service> services = serviceService.getServices();

		List<Role> userRoles = new ArrayList<Role>();
		List<Service> userservices = new ArrayList<Service>();

		// get roles for signed in user
		for (User eachUser : users) {
			for (Role eachRole : roles) {
				if (eachRole.getRole_user_id() == eachUser.getUser_id()
						&& eachUser.getUser_id() == LoginController.loginid2) {
					userRoles.add(eachRole);
					user = eachUser;

				}
			}

		}
		// Get services for each of the roles that the signed in user has access to
		if (!userRoles.isEmpty()) {
			for (Role eachRole : userRoles) {
				for (Service eachservice : services) {
					if (eachRole.getRole_name().equals(eachservice.getService_role_name())) {
						userservices.add(eachservice);
					}
				}
			}

			model.addAttribute("services", userservices);
			model.addAttribute("roles", userRoles);
			model.addAttribute("user", user);
			model.addAttribute("pageTitle", "Employee Home Page");
			return "home-page";
		} else {
			System.out.println("bad");
			model.addAttribute("pageTitle", "Login Failed");
			return "redirect:/login-again";
		}

	}

	// ##########################################################################################################################
	// Staff
	// ##########################################################################################################################

	//////////////////////////////////////////////////
	// Validate student's documents - search
	/////////////////////////////////////////////////
	@GetMapping("/verify-search")
	public String validateDocumentsSearch(Model model) {
		// List<Student> students = studentService.getStudents();
		// model.addAttribute("students", students);
		Student student = new Student();
		model.addAttribute("student", student);
		model.addAttribute("pageTitle", "Validate student documents");
		return "staff-validations-search";
	}

	//////////////////////////////////////////////////
	// Validate student's documents - search results
	/////////////////////////////////////////////////
	@RequestMapping(value = "/verify-choose", method = RequestMethod.POST, produces = { "application/json",
			"application/xml" })
	public String validateDocumentsChoose(@ModelAttribute("student") Student student, Model model) {
		List<Student> students = studentService.getStudents();
		List<Student> std = new ArrayList<Student>();
		for (Student eachStudent : students) {
			if (eachStudent.getStudent_first_name().equals(student.getStudent_first_name())
					&& eachStudent.getStudent_last_name().equals(student.getStudent_last_name())) {
				std.add(eachStudent);
			}
		}
		model.addAttribute("students", std);
		model.addAttribute("pageTitle", "Pick student");
		return "staff-validations-pick";
	}

	//////////////////////////////////////////////////
	// Validate student's documents - change validation for student ID
	/////////////////////////////////////////////////
	@GetMapping("/verify/{id}")
	public String validateDocuments(Model model, @PathVariable("id") int id) {
		List<Student> students = studentService.getStudents();
		for (Student eachStudent : students) {
			if (eachStudent.getStudent_id() == id) {
				eachStudent.setPapers_verified(true);
				studentService.updateStudent(eachStudent);
			}
		}
		model.addAttribute("pageTitle", "Validate student documents");
		return "redirect:/user/verify-search";
	}

	//////////////////////////////////////////////////
	// Validate student's documents - save the changes for student
	/////////////////////////////////////////////////
	@RequestMapping(value = "verify/Documents", method = RequestMethod.POST, produces = { "application/json",
			"application/xml" })
	public String verifyDocuments(@RequestParam("papers_verified") boolean papers_verified,
			@RequestParam("student_verified") boolean student_verified) {
		System.out.println(student2.toString());
		student2.setPapers_verified(papers_verified);
		student2.setStudent_verified(student_verified);
		System.out.println(student2.toString());
		studentService.updateStudent(student2);
		return "redirect:/user/verify-search";
	}

	//////////////////////////////////////////////////
	// Verify students
	/////////////////////////////////////////////////
	@GetMapping("/verify-students")
	public String validateStudent(Model model) {
		List<Student> students = studentService.getStudents();
		model.addAttribute("students", students);
		model.addAttribute("pageTitle", "Verify students");
		return "staff-verify-student";
	}
	
	@GetMapping("/verify-student/{id}")
	public String validateStudents(Model model, @PathVariable("id") int id) {
		List<Student> students = studentService.getStudents();
		for (Student eachStudent : students) {
			if (eachStudent.getStudent_id() == id) {
				eachStudent.setStudent_verified(true);
				studentService.updateStudent(eachStudent);
			}
		}
		model.addAttribute("pageTitle", "Validate student documents");
		return "redirect:/user/verify-students";
	}

	// ##########################################################################################################################
	// Manager
	// ##########################################################################################################################

	@GetMapping("/manage-universities")
	public String updateNumbers(Model model) {
		List<University> universities = universityService.getUniversities();
		String uniName = null;
		// sort universities by grouping with bubble-sort
		University temp = new University();
		for (int i = 0; i < universities.size(); i++) {
			for (int j = 1; j < (universities.size() - i); j++) {
				if (universities.get(j - 1).getEligible_uni_id() > universities.get(j).getEligible_uni_id()) {
					temp = universities.get(j - 1);
					universities.set(j - 1, universities.get(j));
					universities.set(j, temp);
				}
			}
		}
		model.addAttribute("uniName", uniName);
		model.addAttribute("universities", universities);
		model.addAttribute("pageTitle", "Manage Universities");
		return "manager-manage-uni";
	}

	@GetMapping("/manage-universities/{id}")
	public String getUniversityBack(Model model, @PathVariable("id") int id) {
		List<University> universities = universityService.getUniversities();
		for (University eachUniversity : universities) {
			if (eachUniversity.getUni_id() == id) {
				university2 = eachUniversity;
			}
		}
		model.addAttribute("university", university2);
		model.addAttribute("pageTitle", "Manage " + university2.getUni_name());
		return "manager-manage-uni-id";
	}

	@RequestMapping(value = "/manage-universities/saveUniversity", method = RequestMethod.POST, produces = {
			"application/json", "application/xml" })
	public String updateUniversity(@RequestParam("eligible_uni_id") int eligible_uni_id,
			@RequestParam("uni_seats") int uni_seats) {
		// System.out.println(university2.toString());
		// update last_change
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		System.out.println(timestamp);
		university2.setLast_change(timestamp);
		university2.setEligible_uni_id(eligible_uni_id);
		university2.setUni_seats(uni_seats);
		// System.out.println(university2.toString());
		universityService.updateUniversity(university2);
		return "redirect:/user/manage-universities";
	}

}
