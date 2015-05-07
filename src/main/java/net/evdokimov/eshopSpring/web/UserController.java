package net.evdokimov.eshopSpring.web;

import net.evdokimov.eshopSpring.model.User;
import net.evdokimov.eshopSpring.repository.exceptions.NotSuchElementException;
import net.evdokimov.eshopSpring.service.EshopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;


@Controller
public class UserController {

    private final EshopService eshopService;

    @Autowired
    public UserController(EshopService eshopService) {
        this.eshopService = eshopService;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String showRegistrationForm (Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String doRegistration (@Valid User user, BindingResult result, Model model, HttpSession session) {
        if (result.hasErrors()) {
            return "registration";
        }
        try {
            User userForSave = this.eshopService.saveUser(user);
            session.setAttribute("user", userForSave);
            model.addAttribute("regState", true);
            return "registration";
            //TODO: Why such exception?
        } catch (Exception e) {
            model.addAttribute("loginOrEmailExist", true);
            return "registration";
        }
    }

    @RequestMapping(value = "/logout/{from}", method = RequestMethod.GET)
    public String doLogout (@PathVariable("from") String from, HttpSession session) {
        session.removeAttribute("user");
        String to = from.replace("&","/");
        return "redirect:/" + to ;
    }

    @RequestMapping(value = "/login/{from}", method = RequestMethod.GET)
    public String showLoginForm (@PathVariable("from") String from, Model model) {
        model.addAttribute("from", from);
        return "login";
    }

    @RequestMapping(value = "/login/{from}", method = RequestMethod.POST)
    public String doLogin (@PathVariable("from") String from, Model model, HttpSession session, HttpServletRequest req) {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String to = from.replace("&","/");
        try {
            User user = this.eshopService.findUserByLoginAndPassword(login, password);
            session.setAttribute("user", user);
            return "redirect:/" + to;
        } catch (NotSuchElementException e) {
            model.addAttribute("badLogin", true);
            return "login";
        }
    }
}
