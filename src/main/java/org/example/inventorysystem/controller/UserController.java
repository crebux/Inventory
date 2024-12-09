package org.example.inventorysystem.controller;

import jakarta.servlet.http.HttpSession;
import org.example.inventorysystem.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/login")
    public String login(HttpSession session) {
        session.setAttribute("user", new User(1L, "admin", "admin"));
        return "redirect:/products";
    }
}
