package net.evdokimov.eshopSpring.web;

import net.evdokimov.eshopSpring.model.User;
import net.evdokimov.eshopSpring.service.EshopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;


@Controller
public class EshopController {

    private final EshopService eshopService;

    @Autowired
    public EshopController(EshopService eshopService) {
        this.eshopService = eshopService;
    }


    @RequestMapping(value = "/productAll", method = RequestMethod.GET)
    public String showsProductsAndTypes (Model model) {
        model.addAttribute("productList", eshopService.findProducts());
        model.addAttribute("productTypeList", eshopService.findTypes());
        return "productAll";
    }

    @RequestMapping(value = "/product/{productId}", method = RequestMethod.GET)
    public String showProduct (@PathVariable("productId") int productId, Model model) {
        model.addAttribute("product", eshopService.findProductById(productId));
        return "product";
    }

    @RequestMapping(value = "/productChoose/{productTypeListId}", method = RequestMethod.GET)
    public String showProductTypeList (@PathVariable("productTypeListId") int productTypeListId, Model model) {
        model.addAttribute("productList", eshopService.findProductByTypeId(productTypeListId));
        return "productsChosenList";
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
        User userForSave = this.eshopService.saveUser(user);
        session.setAttribute("user", userForSave);
        return "redirect:/productAll";
    }


}
