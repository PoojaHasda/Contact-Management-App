package com.contactmanager.contact.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class PageController {

    @GetMapping("/")
    public String index() {
        return "redirect:/home";
    }
    
    @GetMapping("/home")

    public String home(Model model){
        model.addAttribute("name", "Spring Boot");
        System.out.println("Home page handler");
        return "home";
    }


    // route for about
    @GetMapping("/about")

    public String aboutPage(){
        return new String("about");
    }

    @GetMapping("/service")

    public String servicePage(Model model){
        model.addAttribute("name", "Spring Boot");
        System.out.println("Home page handler");
        return "service";
    }

    @GetMapping("/contact")
    public String getContactPage(){
        return new String("contact");
    }

    @GetMapping("/login")
    public String getloginPage() {
        return new String("login");
    }

    
    @GetMapping("/register")
    public String getSignUpPage() {
        return new String("register");
    }
    

}
