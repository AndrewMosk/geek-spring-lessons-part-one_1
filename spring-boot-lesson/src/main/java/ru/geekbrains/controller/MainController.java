package ru.geekbrains.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

    @GetMapping("login")
    public String showMyLoginPage(Model model,
                                  @RequestParam (value = "error", required = false) String error,
                                  @RequestParam (value = "logout", required = false) String logout) {
        model.addAttribute("error", error != null);
        model.addAttribute("logout", logout != null);

        return "login";
    }
}