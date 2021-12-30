package com.springbootcrud.controller;

import com.springbootcrud.exception.UserNotFounExceptiom;
import com.springbootcrud.service.UserService;
import com.springbootcrud.user.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class UserController {
    private UserService service;

    public UserController(UserService uservice) {
        this.service = uservice;
    }

    @GetMapping("/users")
    public String showUserList(Model model){
        List<User> users = service.listAll();
        model.addAttribute("listUsers",users);
        return "users";
    }
    @GetMapping("/users/new")
    public String addNewUser(Model model){
        model.addAttribute("user",new User());
        model.addAttribute("pagetitle","Add New User");
        return "user_form";
    }

    @PostMapping("/user/save")
    public String userSave(User user, RedirectAttributes re){
        service.save(user);
        re.addFlashAttribute("message","The User Has Benn Saved Succesfully");
        return "redirect:/users";
    }

    @GetMapping("/users/edit/{id}")
    public String ShowEditForm(@PathVariable("id")Integer id, Model model, RedirectAttributes re){
        try {
            User user = service.getById(id);
            model.addAttribute("user",user);
            model.addAttribute("pagetitle","Edit User ( Id  " + id +")");
            return "user_form";
        } catch (UserNotFounExceptiom userNotFounExceptiom) {
            re.addFlashAttribute("message","The User Has Benn Saved Succesfully");
            return "redirect:/users";
        }
    }

    @GetMapping("/users/delete/{id}")
    public String deleteForm(@PathVariable("id")Integer id, RedirectAttributes re){
        try {
            service.delete(id);
            re.addFlashAttribute("message","The User ID " + id + " has been deleted.");
        } catch (UserNotFounExceptiom e) {
            re.addFlashAttribute("message",e.getMessage());
        }
        return "redirect:/users";
    }
}
