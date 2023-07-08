package br.com.corext.admcorext.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class LoginController {

    @GetMapping("/login")
    public ModelAndView loginSgext() {
        ModelAndView modelAndView = new ModelAndView("login.html");

        // RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        // HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();

        // System.out.println(request.toString());
        // System.out.println(requestAttributes.toString());

        
        // WebSecurityConfig config = new WebSecurityConfig();
    
        // String user = config.userDetailsService();

        // JsonObject jsonObj = new JsonObject();
        // jsonObj.addProperty(user, user);

        // InMemoryUserDetailsManager user = config.userDetailsService().userExists(user);

        // modelAndView.addObject("user", jsonObj);
        // System.out.println(modelAndView);
        // System.out.println(jsonObj);

        return modelAndView;
    }

}
