package org.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.web.model.User;
import org.web.service.UserService;

@Controller
public class UserController {

    private UserService userService;

    public UserController(@Autowired UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getAllUsers")
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUser());
        return "getAllUsers";
    }

    @GetMapping("/getAddUser")
    public String getAddUser() {
        return "getAddUser";
    }

    @PostMapping("/addUser")
    public String postAddUser(@ModelAttribute User user) {
        userService.add(user);
        return "redirect:/getAllUsers";
    }

    @GetMapping("/getDeleteUser")
    public String getDeleteUser(@RequestParam("id") Long id, Model model) {
        model.addAttribute("user", userService.findById(id));
        return "getDeleteUser";
    }

    @PostMapping("/postDeleteUser")
    public String postDeleteUser(@RequestParam("id") Long id) {
        userService.delete(id);
        return "redirect:/getAllUsers";
    }

    @GetMapping("/getUpdateUser")
    public String getUpdateUser(@RequestParam("id") Long id, Model model) {
        model.addAttribute("user", userService.findById(id));
        return "getUpdateUser";
    }

    @PostMapping("/updateUser")
    public String postUpdateUser(@ModelAttribute User user) {
        userService.update(user);
        return "redirect:/getAllUsers";
    }

}
