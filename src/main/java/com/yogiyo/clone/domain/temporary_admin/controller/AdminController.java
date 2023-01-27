package com.yogiyo.clone.domain.temporary_admin.controller;

import com.yogiyo.clone.domain.temporary_admin.dto.StoreAddResponseDto;
import com.yogiyo.clone.domain.temporary_admin.service.AdminApiService;
import com.yogiyo.clone.domain.user.dto.LoginForm;
import com.yogiyo.clone.domain.user.dto.UserInfoDto;
import com.yogiyo.clone.domain.user.entity.UserRole;
import com.yogiyo.clone.domain.user.entity.Users;
import com.yogiyo.clone.domain.user.service.UserService;
import com.yogiyo.clone.security.UserDetailsImpl;
import com.yogiyo.clone.security.jwt.JwtUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import static com.yogiyo.clone.security.jwt.JwtUtil.AUTHORIZATION_HEADER;

@Slf4j
@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final UserService userService;
    private final JwtUtil jwtUtil;
    private final AdminApiService adminApiService;

    @RequestMapping("/login")
    public String adminLogin() {
        return "admin_login";
    }

    @RequestMapping("/signup")
    public String adminSignup() {
        return "admin_signup";
    }

    @PostMapping("/main")
    public ModelAndView login(@RequestParam String username, @RequestParam String password, LoginForm loginForm,
                              HttpServletRequest request, HttpServletResponse response, HttpSession session) {

        loginForm.setEmail(username);
        loginForm.setPassword(password);
        Users users = userService.login(loginForm);
        response.addHeader(AUTHORIZATION_HEADER, jwtUtil.createToken(users.getUsername()));
        session.setAttribute(AUTHORIZATION_HEADER, jwtUtil.createToken(users.getUsername()));

        ModelAndView modelAndView = new ModelAndView();
        if (users.getUserRole().equals(UserRole.USER))
            modelAndView.setViewName("authorization_fail");
        else
            modelAndView.setViewName("page/admin_main_page");
        modelAndView.addObject("userRole",users.getUserRole());

        return modelAndView;
    }

    @GetMapping("/store-detail")
    public String store_detail(Model model) {
        List<StoreAddResponseDto> storeList = adminApiService.getStoreList();
        model.addAttribute("storeList", storeList);
        return "page/admin_store_detail";
    }

    @GetMapping("/admin-main")
    public String store_main() {
        return "page/admin_main";
    }

    @GetMapping("/menu-add")
    public String menu_add() {
        return "page/admin_menu_add";
    }

    @GetMapping("/menu-list")
    public String menu_list() {
        return "page/admin_menu_list";
    }

    @GetMapping("/order-list")
    public String order_list() {
        return "page/admin_order_list";
    }

    @GetMapping("/store-add")
    public String store_add(Model model) {
        List<UserInfoDto> userList = userService.getUserList();
        model.addAttribute("userList",userList);
        return "page/admin_store_add";
    }

    @GetMapping("/total-order-list")
    public String total_order_list() {
        return "page/admin_total_order_list";
    }

    @GetMapping("/review-list")
    public String review_list() {
        return "page/admin_review_list";
    }

    @GetMapping("/test1")
    public String test1() {
        return "page/admin_basket_test";
    }

    @GetMapping("/test2")
    public String test_order() {
        return "page/admin_test_order";
    }

    @GetMapping("/test-review")
    public String test_review() {
        return "page/admin_test_review";
    }

}
