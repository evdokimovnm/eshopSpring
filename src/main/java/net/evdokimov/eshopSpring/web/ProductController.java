package net.evdokimov.eshopSpring.web;


import net.evdokimov.eshopSpring.service.EshopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;




@Controller
public class ProductController {

    private final EshopService eshopService;

    @Autowired
    public ProductController(EshopService eshopService) {
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

//    @RequestMapping(value = "/productAddToBucket/{id}", method = RequestMethod.GET)
//    pub



}
