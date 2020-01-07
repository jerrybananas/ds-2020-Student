package gr.hua.dit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import gr.hua.dit.entity.Student;
import gr.hua.dit.entity.User;
import gr.hua.dit.service.StudentService;
import gr.hua.dit.service.UserService;

@Controller
@RequestMapping("")
public class LoginController {

	@Autowired
	private StudentService studentService;

	@Autowired
	private UserService userService;

	public static int loginid, loginid2;

	//////////////////////////////////////////////////
	// Login
	/////////////////////////////////////////////////
	@GetMapping("/login")
	public String login(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		// add page title
		model.addAttribute("pageTitle", "Login");
		return "login-form";
	}

	@GetMapping("/login-again")
	public String login2(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		// add page title
		model.addAttribute("pageTitle", "Login");
		return "login-form-failed";
	}

	//////////////////////////////////////////////////
	// Employee Login check
	/////////////////////////////////////////////////
	@PostMapping(value = "/checkLogin")
	public String checkLogin(@ModelAttribute("userLogin") User user) {
		// save the customer using the service
		System.out.println(user.getUser_mail() + "  Student Logged in");
		List<User> users = userService.getUsers();
		for (User eachUser : users) {
			if (eachUser.getUser_mail().equals(user.getUser_mail())
					&& eachUser.getUser_password().equals(user.getUser_password())) {
				loginid2 = eachUser.getUser_id();
				System.out.println("Logged in");
				return "redirect:/user/home";
			}
		}
		System.out.println("Wrong credentials");
		return "redirect:/login-again";
	}

	//////////////////////////////////////////////////
	// Student Login check
	/////////////////////////////////////////////////
	@PostMapping("/checkStudentLogin")
	public String checkStudentLogin(@ModelAttribute("studentLogin") User user) {
		// save the customer using the service
		System.out.println(user.getUser_mail() + "  Student Logged in");
		List<Student> students = studentService.getStudents();
		for (Student eachStudent : students) {
			if (eachStudent.getStudent_mail().equals(user.getUser_mail())
					&& eachStudent.getStudent_password().equals(user.getUser_password())) {
				loginid = eachStudent.getStudent_id();
				System.out.println("Logged in");
				return "redirect:/student/home";
			}
		}
		System.out.println("Wrong credentials");
		return "redirect:/login-again";

	}

	@PostMapping(value = "/login/{mail}/conf/{password}", produces = "application/json;charset=utf-8")
	public Student studentLogin(@PathVariable("mail") String mail, @PathVariable("password") String password) {
		System.out.println(mail);
		List<Student> students = studentService.getStudents();
		for (Student eachStudent : students) {
			if (eachStudent.getStudent_mail().equals(mail)
					&& eachStudent.getStudent_password().equals(password)) {
				System.out.println("Logged in");
				return eachStudent;
			}
		}
		return null;
	}
	
	

}
