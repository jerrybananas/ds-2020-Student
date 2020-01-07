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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import gr.hua.dit.entity.Admin;
import gr.hua.dit.entity.Role;
import gr.hua.dit.entity.Service;
import gr.hua.dit.entity.Student;
import gr.hua.dit.entity.University;
import gr.hua.dit.entity.User;
import gr.hua.dit.service.AdminService;
import gr.hua.dit.service.RoleService;
import gr.hua.dit.service.ServiceService;
import gr.hua.dit.service.StudentService;
import gr.hua.dit.service.UniversityService;
import gr.hua.dit.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService adminservice;

	@Autowired
	private StudentService studentService;

	@Autowired
	private UserService userService;

	@Autowired
	private RoleService roleService;

	@Autowired
	private UniversityService universityService;

	@Autowired
	private ServiceService serviceService;

	public static String mail, studentMail;

	University uni;

	//////////////////////////////////////////////////
	// Login
	/////////////////////////////////////////////////
	@GetMapping("/login")
	public String login(Model model) {
		Admin admin = new Admin();
		model.addAttribute("admin", admin);
		// add page title
		model.addAttribute("pageTitle", "Admin Login");
		return "admin-login-form";
	}

	@GetMapping("/admin-login-again")
	public String login2(Model model) {
		Admin admin = new Admin();
		model.addAttribute("admin", admin);
		// add page title
		model.addAttribute("pageTitle", "Admin Login");
		return "admin-login-form-failed";
	}

	//////////////////////////////////////////////////
	// Admin Login check
	/////////////////////////////////////////////////
	@PostMapping(value = "/checkAdminLogin")
	public String checkLogin(@ModelAttribute("admin") Admin admin) {
		List<Admin> admins = adminservice.getAdmins();
		boolean x = false;
		for (Admin eachAdmin : admins) {
			if (admin.getMail().equals(eachAdmin.getMail()) && admin.getPassword().equals(eachAdmin.getPassword())) {
				System.out.println("Logged in");
				x = true;
			}
		}
		if (x == true) {
			return "redirect:/admin/home";
		} else {
			System.out.println("Wrong credentials");
			return "redirect:/admin-login-again";
		}
	}

	// ##########################################################################################################################
	// Admin Homepage
	// #########################################################################################################################
	@GetMapping(value = "/home")
	public String adminHome(Model model) {
		model.addAttribute("pageTitle", "Admin Home");
		return "admin-home-page";
	}

	// #########################################################################################################################
	// Admin Manage Students
	// #########################################################################################################################
	@GetMapping(value = "/students")
	public String adminManageStudents(Model model) {
		List<Student> students = studentService.getStudents();
		model.addAttribute("students", students);
		model.addAttribute("pageTitle", "Admin Manage Students");
		return "admin-students";
	}

	Student stud;

	@GetMapping("/students/{id}")
	public String getStudent(Model model, @PathVariable("id") int id) {
		List<Student> students = studentService.getStudents();
		for (Student eachstudents : students) {
			if (eachstudents.getStudent_id() == id) {
				stud = eachstudents;
			}
		}
		List<University> unis = universityService.getUniversities();
		model.addAttribute("student", stud);

		model.addAttribute("unis", unis);
		model.addAttribute("pageTitle", "Manage " + stud.getStudent_id());
		return "admin-student-update";
	}

	@RequestMapping(value = "/students/update", method = RequestMethod.POST, produces = { "application/json",
			"application/xml" })
	public String updateStudentAdmin(@RequestParam("student_first_name") String student_first_name,
			@RequestParam("student_last_name") String student_last_name,
			@RequestParam("student_mail") String student_mail,
			@RequestParam("student_password") String student_password, @RequestParam("uni") String uni,
			@RequestParam("both_parents_unemployed") boolean both_parents_unemployed,
			@RequestParam("siblings_at_university") int siblings_at_university,
			@RequestParam("family_income") int family_income, @RequestParam("same_city") boolean same_city,
			@RequestParam("student_points") int student_points,
			@RequestParam("student_verified") boolean student_verified,
			@RequestParam("papers_verified") boolean papers_verified) {
		stud.setStudent_first_name(student_first_name);
		stud.setStudent_last_name(student_last_name);
		stud.setStudent_mail(student_mail);
		stud.setStudent_password(student_password);
		stud.setStudent_uni(uni);
		stud.setBoth_parents_unemployed(both_parents_unemployed);
		stud.setSiblings_at_university(siblings_at_university);
		stud.setFamily_income(family_income);
		stud.setSame_city(same_city);
		stud.setStudent_points(student_points);
		stud.setStudent_verified(student_verified);
		stud.setPapers_verified(papers_verified);

		List<Student> students = studentService.getStudents();
		// check for constraints
		for (Student eachstudents : students) {
			if (eachstudents.getStudent_mail().equals(stud.getStudent_mail())
					&& eachstudents.getStudent_password().equals(stud.getStudent_password())) {
				studentService.deleteStudent(stud.getStudent_id());
				studentService.saveStudent(stud);
			}
		}
		studentService.updateStudent(stud);
		return "redirect:/admin/students";
	}

	@GetMapping("/students/add")
	public String addStudent(Model model) {
		Student student = new Student();
		List<University> unis = universityService.getUniversities();
		model.addAttribute("unis", unis);
		model.addAttribute("student", student);
		model.addAttribute("pageTitle", "Add Student");
		return "admin-student-add";
	}

	@RequestMapping(value = "/students/add-final", method = RequestMethod.POST, produces = { "application/json",
			"application/xml" })
	public String addStudentFinal(@RequestParam("student_first_name") String student_first_name,
			@RequestParam("student_last_name") String student_last_name,
			@RequestParam("student_mail") String student_mail,
			@RequestParam("student_password") String student_password, @RequestParam("uni") String uni) {
		Student st = new Student();
		st.setStudent_first_name(student_first_name);
		st.setStudent_last_name(student_last_name);
		st.setStudent_mail(student_mail);
		st.setStudent_password(student_password);
		st.setStudent_uni(uni);
		List<Student> students = studentService.getStudents();
		// check for constraints
		for (Student eachstudents : students) {
			if (eachstudents.getStudent_mail().equals(st.getStudent_mail())
					&& eachstudents.getStudent_password().equals(st.getStudent_password())) {
				return "redirect:/admin/students/add";
			}
		}
		studentService.saveStudent(st);
		return "redirect:/admin/students";
	}

	@GetMapping("/students/delete/{id}")
	public String deleteStudent(Model model, @PathVariable("id") int id) {
		studentService.deleteStudent(id);
		return "redirect:/admin/students";
	}

	// #########################################################################################################################
	// Admin Manage Staff
	// #########################################################################################################################
	@GetMapping(value = "/staff")
	public String adminManageStaff(Model model) {
		List<User> users = userService.getUsers();
		model.addAttribute("users", users);
		model.addAttribute("pageTitle", "Admin Manage Staff");
		return "admin-staff";
	}

	@GetMapping("/staff/add")
	public String adminAddStaff(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		model.addAttribute("pageTitle", "Add Staff");
		return "admin-staff-add";
	}

	@RequestMapping(value = "/staff/add-final", method = RequestMethod.POST, produces = { "application/json",
			"application/xml" })
	public String adminAddStaffFinal(@RequestParam("user_first_name") String user_first_name,
			@RequestParam("user_last_name") String user_last_name, @RequestParam("user_mail") String user_mail,
			@RequestParam("user_password") String user_password) {
		User user = new User();
		user.setUser_first_name(user_first_name);
		user.setUser_last_name(user_last_name);
		user.setUser_mail(user_mail);
		user.setUser_password(user_password);

		List<User> users = userService.getUsers();
		// check for constraints
		for (User eachUser : users) {
			if (eachUser.getUser_mail().equals(user_mail) && eachUser.getUser_password().equals(user_password)) {
				return "redirect:/admin/staff/add";
			}
		}
		userService.saveUser(user);
		return "redirect:/admin/staff";
	}

	User us;

	@GetMapping("/staff/{id}")
	public String adminUpdateStaff(Model model, @PathVariable("id") int id) {
		List<User> users = userService.getUsers();
		// check for constraints
		for (User eachUser : users) {
			if (eachUser.getUser_id() == id) {
				us = eachUser;
			}
		}

		model.addAttribute("user", us);
		model.addAttribute("pageTitle", "Manage " + us.getUser_first_name());
		return "admin-staff-update";
	}

	@RequestMapping(value = "/staff/addFinal", method = RequestMethod.POST, produces = { "application/json",
			"application/xml" })
	public String adminUpdateFinalStaff(@RequestParam("user_id") int user_id,
			@RequestParam("user_first_name") String user_first_name,
			@RequestParam("user_last_name") String user_last_name, @RequestParam("user_mail") String user_mail,
			@RequestParam("user_password") String user_password) {
		User user = new User();
		user.setUser_first_name(user_first_name);
		user.setUser_id(user_id);
		user.setUser_last_name(user_last_name);
		user.setUser_mail(user_mail);
		user.setUser_password(user_password);

		List<User> users = userService.getUsers();
		// check for constraints
		for (User eachUser : users) {
			if (eachUser.getUser_mail().equals(user_mail) && eachUser.getUser_password().equals(user_password)) {
				return "redirect:/admin/staff/add";
			}
		}
		userService.updateUser(user);
		return "redirect:/admin/staff";
	}

	@GetMapping("/staff/delete/{id}")
	public String adminDeleteStaff(Model model, @PathVariable("id") int id) {
		userService.deleteUser(id);
		return "redirect:/admin/staff";
	}

	// #########################################################################################################################
	// Admin Manage Universities
	// #########################################################################################################################
	@GetMapping(value = "/universities")
	public String adminManageUniversities(Model model) {
		List<University> universities = universityService.getUniversities();
		model.addAttribute("universities", universities);
		model.addAttribute("pageTitle", "Admin Manage Universities");
		return "admin-universities";
	}

	@GetMapping("/universities/{id}")
	public String getUniversityBack(Model model, @PathVariable("id") int id) {
		if (id == -1) {
			uni = null;
			University university = new University();
			model.addAttribute("university", university);
			model.addAttribute("pageTitle", "Add University");
			return "admin-universities-add";
		}
		List<University> universities = universityService.getUniversities();
		for (University eachUniversity : universities) {
			if (eachUniversity.getUni_id() == id) {
				uni = eachUniversity;
			}
		}
		model.addAttribute("university", uni);
		model.addAttribute("pageTitle", "Manage " + uni.getUni_name());
		return "admin-universities-update";
	}

	@RequestMapping(value = "/universities/updateUniversity", method = RequestMethod.POST, produces = {
			"application/json", "application/xml" })
	public String updateUniversityAdmin(@RequestParam("uni_name") String uni_name,
			@RequestParam("eligible_uni_id") int eligible_uni_id, @RequestParam("uni_seats") int uni_seats) {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		uni.setUni_name(uni_name);
		uni.setLast_change(timestamp);
		uni.setEligible_uni_id(eligible_uni_id);
		uni.setUni_seats(uni_seats);
		// System.out.println(university2.toString());
		universityService.updateUniversity(uni);
		return "redirect:/admin/universities";
	}

	@RequestMapping(value = "/universities/add", method = RequestMethod.POST, produces = { "application/json",
			"application/xml" })
	public String addUniversityAdmin(@RequestParam("uni_name") String uni_name,
			@RequestParam("eligible_uni_id") int eligible_uni_id, @RequestParam("uni_seats") int uni_seats) {
		University university = new University();
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		university.setLast_change(timestamp);
		university.setEligible_uni_id(eligible_uni_id);
		university.setUni_seats(uni_seats);
		university.setUni_name(uni_name);
		// System.out.println(university2.toString());
		universityService.saveUniversity(university);
		return "redirect:/admin/universities";
	}

	/*
	 * @GetMapping("/universities/delete/{id}") public String
	 * adminDeleteUniversity(Model model, @PathVariable("id") int id) {
	 * universityService.deleteUniversity(id); return
	 * "redirect:/admin/universities"; }
	 */

	// #########################################################################################################################
	// Admin Manage Services
	// #########################################################################################################################

	@GetMapping(value = "/services")
	public String adminManageServices(Model model) {
		List<Service> services = serviceService.getServices();
		model.addAttribute("services", services);
		model.addAttribute("pageTitle", "Admin Manage Services");
		return "admin-services";
	}

	@GetMapping("/services/add")
	public String adminAddServices(Model model) {
		Service service = new Service();
		List<Role> roles = roleService.getRoles();
		List<String> roles1 = new ArrayList<String>();
		for (Role eachRole : roles) {
			if (!roles1.contains(eachRole.getRole_name())) {
				roles1.add(eachRole.getRole_name());
			}
		}
		model.addAttribute("roles", roles1);
		model.addAttribute("service", service);
		model.addAttribute("pageTitle", "Add Service");
		return "admin-service-add";
	}

	Service ser;

	@GetMapping("/services/{id}")
	public String getServiceBack(Model model, @PathVariable("id") int id) {
		List<Service> services = serviceService.getServices();
		for (Service eachService : services) {
			if (eachService.getService_id() == id) {
				ser = eachService;
			}
		}
		List<Role> roles = roleService.getRoles();
		List<String> roles1 = new ArrayList<String>();
		for (Role eachRole : roles) {
			if (!roles1.contains(eachRole.getRole_name())) {
				roles1.add(eachRole.getRole_name());
			}
		}

		model.addAttribute("service", ser);
		model.addAttribute("roles", roles1);
		model.addAttribute("pageTitle", "Manage " + ser.getService_name());
		return "admin-services-update";
	}

	@RequestMapping(value = "/services/updateFinal", method = RequestMethod.POST, produces = { "application/json",
			"application/xml" })
	public String adminUpdateFinalServices(@RequestParam("service_name") String service_name,
			@RequestParam("service_url") String service_url,
			@RequestParam("service_role_name") String service_role_name) {
		Service service = new Service();
		service.setService_name(service_name);
		service.setService_role_name(service_role_name);
		service.setService_url(service_url);
		serviceService.updateService(service);
		return "redirect:/admin/services";
	}

	@RequestMapping(value = "/services/addFinal", method = RequestMethod.POST, produces = { "application/json",
			"application/xml" })
	public String adminAddFinalServices(@RequestParam("service_name") String service_name,
			@RequestParam("service_url") String service_url,
			@RequestParam("service_role_name") String service_role_name) {
		Service service = new Service();
		service.setService_name(service_name);
		service.setService_role_name(service_role_name);
		service.setService_url(service_url);
		serviceService.saveService(service);
		return "redirect:/admin/services";
	}

	@GetMapping("/services/delete/{id}")
	public String adminDeleteService(Model model, @PathVariable("id") int id) {
		serviceService.deleteService(id);
		return "redirect:/admin/services";
	}

	// #########################################################################################################################
	// Admin Manage Roles
	// #########################################################################################################################

	/*
	 * @GetMapping(value = "/roles") public String adminManageRoles(Model model) {
	 * List<Role> roles = roleService.getRoles(); model.addAttribute("roles",
	 * roles); model.addAttribute("pageTitle", "Admin Manage Roles"); return
	 * "admin-role"; }
	 * 
	 * @GetMapping("/roles/add") public String adminAddRoles(Model model) {
	 * List<User> users = userService.getUsers(); model.addAttribute("users",
	 * users); model.addAttribute("pageTitle", "Add Role"); return "admin-role-add";
	 * }
	 * 
	 * Role r;
	 * 
	 * @GetMapping("/roles/{id}") public String getRoleBack(Model
	 * model, @PathVariable("id") int id) { List<Service> services =
	 * serviceService.getServices(); for (Service eachService : services) { if
	 * (eachService.getService_id() == id) { ser = eachService; } } List<Role> roles
	 * = roleService.getRoles(); List<String> roles1 = new ArrayList<String>(); for
	 * (Role eachRole : roles) { if (!roles1.contains(eachRole.getRole_name())) {
	 * roles1.add(eachRole.getRole_name()); } }
	 * 
	 * model.addAttribute("service", ser); model.addAttribute("roles", roles1);
	 * model.addAttribute("pageTitle", "Manage " + ser.getService_name()); return
	 * "admin-role-update"; }
	 * 
	 * @RequestMapping(value = "/roles/updateFinal", method = RequestMethod.POST,
	 * produces = { "application/json", "application/xml" }) public String
	 * adminUpdateFinalRoles(@RequestParam("service_name") String service_name,
	 * 
	 * @RequestParam("service_url") String service_url,
	 * 
	 * @RequestParam("service_role_name") String service_role_name) { Service
	 * service = new Service(); service.setService_name(service_name);
	 * service.setService_role_name(service_role_name);
	 * service.setService_url(service_url); serviceService.updateService(service);
	 * return "redirect:/admin/roles"; }
	 * 
	 * @RequestMapping(value = "/roles/addFinal", method = RequestMethod.POST,
	 * produces = { "application/json", "application/xml" }) public String
	 * adminAddFinalRoles(@RequestParam("role") String
	 * role, @RequestParam("user_id") int user_id) { Service service = new
	 * Service(); Role role1 = new Role(); role1.setRole_name(role);
	 * role1.setRole_user_id(user_id); roleService.saveRole(role1); return
	 * "redirect:/admin/roles"; }
	 * 
	 * @GetMapping("/roles/delete/{id}") public String adminDeleteRole(Model
	 * model, @PathVariable("id") int id) { //roleService.deleteRole(id); return
	 * "redirect:/admin/roles"; }
	 */

}
