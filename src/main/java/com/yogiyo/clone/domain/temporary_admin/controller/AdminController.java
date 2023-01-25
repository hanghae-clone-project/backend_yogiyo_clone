package com.yogiyo.clone.domain.temporary_admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @RequestMapping("/login")
    public String adminLogin() {
        return "admin_login";
    }

    @RequestMapping("/signup")
    public String adminSignup() {
        return "admin_signup";
    }
}
