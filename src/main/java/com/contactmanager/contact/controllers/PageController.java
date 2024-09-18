package com.contactmanager.contact.controllers;

// import org.aspectj.bridge.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.validation.BindingResult;

import com.contactmanager.contact.Entities.User;
import com.contactmanager.contact.forms.UserForm;
import com.contactmanager.contact.helper.Message;
import com.contactmanager.contact.helper.MessageType;
import com.contactmanager.contact.services.UserServices;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class PageController {

    @Autowired
    private UserServices userService;

    @GetMapping("/")
    public String index() {
        return "redirect:/home";
    }

    @GetMapping("/home")

    public String home(Model model) {
        model.addAttribute("name", "Spring Boot");
        System.out.println("Home page handler");
        return "home";
    }

    // route for about
    @GetMapping("/about")

    public String aboutPage() {
        return new String("about");
    }

    @GetMapping("/service")

    public String servicePage(Model model) {
        model.addAttribute("name", "Spring Boot");
        System.out.println("Home page handler");
        return "service";
    }

    @GetMapping("/contact")
    public String getContactPage() {
        return new String("contact");
    }

    // for login page
    @GetMapping("/login")
    public String getloginPage() {
        return new String("login");
    }

    // for registration page
    @GetMapping("/register")
    public String getSignUpPage(Model model) {
        UserForm userform = new UserForm();
        // default data can also be used.
        model.addAttribute("userform", userform);
        return new String("register");
    }

    // processing register
    @PostMapping(value = "/do-register")
    public String processRegister(@Valid @ModelAttribute UserForm userForm,BindingResult rBindingResult, HttpSession session) {
        System.out.println("processing registration");
        // we have to fetch the form data

        // validate userForm
        
        // validate form data
        if (rBindingResult.hasErrors()) {
            return "register";
        }

        // save to database

        // userservice
        // User user = User.builder().name(userForm.getName()).email(userForm.getEmail()).password(userForm.getPassword())
        //         .phoneNumber(userForm.getPhoneNumber()).profileLink("").build();

        User user = new User();
        user.setName(userForm.getName());
        user.setEmail(userForm.getEmail());
        user.setPassword(userForm.getPassword());
        user.setPhoneNumber(userForm.getPhoneNumber());
        user.setProfileLink("https://www.pngkit.com/png/detail/126-1262807_instagram-default-profile-picture-png.png");



        User savedUser = userService.saveUser(user);

        System.out.println("saved user");
        // message = "registration succesful"


   Message message = Message.builder().content("Registration Successful").type(MessageType.green).build();

        session.setAttribute("message", message);
        return "redirect:/register";
    }

}
