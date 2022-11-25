package com.openid.client.login;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @GetMapping("/userportal")
    public String getUserPortal(Model model) {
        System.out.println(" in controller" );


        Object principal = SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();

// put the UserDetails object here.
        model.addAttribute("userDetails", principal);
        return "userportal";
    }

    @GetMapping("/open")
    public String getOpenHomePage(Model model) {
        System.out.println(" in controller" );
        return "open";
    }

}
