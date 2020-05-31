package ru.geekbrains.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.geekbrains.persist.entity.User;
import ru.geekbrains.service.UserService;

@RequestMapping("/user")
@Controller
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String userList(Model model,
                           @RequestParam(name = "minAge", required = false, defaultValue = "0") Integer minAge,
                           @RequestParam(name = "maxAge", required = false, defaultValue = "0") Integer maxAge,
                           @RequestParam(name = "page", required = false, defaultValue = "1") Integer page, // еще однин вариант использования параметра без опции required = false
                           @RequestParam(name = "size", required = false, defaultValue = "5") Integer size) {

        logger.info("User list. With minAge = {} and maxAge = {}", minAge, maxAge);

        Page<User> userPage = userService.filterByAge(minAge, maxAge, PageRequest.of(page - 1, size)); // page.orElse(1)-1 почему-то -1!?

        model.addAttribute("usersPage", userPage);
        model.addAttribute("minAge", minAge);
        model.addAttribute("maxAge", maxAge);
        model.addAttribute("prevPageNumber", userPage.hasPrevious() ? userPage.previousPageable().getPageNumber() + 1 : -1);
        model.addAttribute("nextPageNumber", userPage.hasNext() ? userPage.nextPageable().getPageNumber() + 1 : -1);

        return "users";
    }

    @GetMapping("new")
    public String createUser(Model model) {
        logger.info("Create user form");

        model.addAttribute("user", new User());
        return "user";
    }

    @PostMapping
    public String saveUser(User user) {
        logger.info("Save user method");

        userService.save(user);
        return "redirect:/user";
    }
}
