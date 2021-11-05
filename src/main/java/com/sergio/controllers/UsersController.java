package com.sergio.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.sergio.models.User;
import com.sergio.services.UserService;

@Controller
public class UsersController {

	private final UserService userService;
	

	public UsersController(UserService userService) {
		this.userService = userService;
		
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String displayMain() {

		return "index.jsp";
	}

	@RequestMapping(value = "/users/add", method = RequestMethod.POST)
	public String createUser(@RequestParam(value = "firstname") String firstname,
			@RequestParam(value = "lastname") String lastname, @RequestParam(value = "email") String email,
			@RequestParam(value = "password") String password, @RequestParam(value = "confpass") String confpass,
			RedirectAttributes redirectAttributes, HttpSession session) {

		if (!firstname.equalsIgnoreCase("") && !lastname.equalsIgnoreCase("") && !email.equalsIgnoreCase("")
				&& !password.equalsIgnoreCase("") && !confpass.equalsIgnoreCase("")) {

			List<User> user = userService.getUserByEmail(email);

			if (user.size() > 0) {
				redirectAttributes.addFlashAttribute("errorMessage", "That user email already exists!")
						.addFlashAttribute("clase", "danger");
				return "redirect:/";
			} else {
				if (!password.equals(confpass)) {
					redirectAttributes
							.addFlashAttribute("errorMessage", "Password and password confirmation do not match")
							.addFlashAttribute("clase", "danger");
					return "redirect:/";
				} else {

				
					userService.registerUser(firstname, lastname, email, password);


					redirectAttributes.addFlashAttribute("errorMessage", "User added successfully!!")
							.addFlashAttribute("clase", "success");

					return "redirect:/";
				}

			}
		} else {

			redirectAttributes.addFlashAttribute("errorMessage", "All fields should be completed to proceed!!")
					.addFlashAttribute("clase", "danger");
			return "redirect:/";
		}
	}

	@RequestMapping(value = "/authentication", method = RequestMethod.POST)
	public String login(@RequestParam(value = "logEmail") String logEmail,
			@RequestParam(value = "logPass") String logPass, RedirectAttributes redirectAttributes,
			HttpSession session) {

		if (!logEmail.equalsIgnoreCase("") && !logPass.equalsIgnoreCase("")) {

			List<User> user = userService.getUserByEmail(logEmail);

			if (user.size() == 0) {
				redirectAttributes.addFlashAttribute("loginErrorMessage", "Wrong credentials")
						.addFlashAttribute("clase", "danger");
				return "redirect:/";
			} else {
				User currentUser = user.get(0);

				if (userService.validateUser(currentUser, logPass)) {

					session.setAttribute("firstName", currentUser.getFirstname());
					session.setAttribute("lastName", currentUser.getLastname());
					session.setAttribute("email", currentUser.getEmail());
					session.setAttribute("user_id", currentUser.getUser_id());

					return "redirect:/home";
				} else {
					redirectAttributes.addFlashAttribute("loginErrorMessage", "Wrong credentials (password)")
							.addFlashAttribute("clase", "danger");
					return "redirect:/";
				}
			}
		} else {
			redirectAttributes.addFlashAttribute("errorMessage", "All fields should be completed to proceed!!")
					.addFlashAttribute("clase", "danger");
			return "redirect:/";

		}
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String displayDashboard() {

		
		

		return "home.jsp";

	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.removeAttribute("firstName");
		session.removeAttribute("lastName");
		session.removeAttribute("email");
		session.removeAttribute("user_id");
		return "redirect:/";
	}

}
