package com.openid.client.login;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {

    @GetMapping("/userportal")
    public String getUserPortal(@RequestParam Map<String,String> allRequestParams, Model model,
                                @AuthenticationPrincipal DefaultOidcUser defaultOidcUser) {

        allRequestParams.values().stream().forEach(  System.out::println  );

        System.out.println(" model"  + model.toString());

        Object principal = SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();

        model.addAttribute("userDetails", principal);

        model.addAttribute("claims", defaultOidcUser.getClaims());

        Map<String, Object> attributes = defaultOidcUser.getAttributes();

        return "userportal";
    }

    @GetMapping("/open")
    public String getOpenHomePage(Model model) {
        System.out.println(" in controller" );
        return "open";
    }

}
