package net.evdokimov.eshopSpring.web;


import net.evdokimov.eshopSpring.model.Product;
import net.evdokimov.eshopSpring.model.ProductType;
import net.evdokimov.eshopSpring.service.EshopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.LinkedHashMap;
import java.util.Map;

import static java.util.Collections.singletonMap;
import static java.util.Collections.unmodifiableMap;

import static net.evdokimov.eshopSpring.web.SessionAttributes.PRODUCTS_IN_BUCKET;


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
        model.addAttribute("from", productTypeListId);
        return "productsChosenList";
    }

    @RequestMapping(value = "/productAddToBucket/{id}", method = RequestMethod.GET)
    public String doAddToBucket (@PathVariable("id") int id, HttpSession session) {
        Product product = eshopService.findProductById(id);
        Map<Product, Integer> oldBucked = (Map <Product, Integer >)session.getAttribute(PRODUCTS_IN_BUCKET);
        if (oldBucked == null) {
            session.setAttribute(PRODUCTS_IN_BUCKET, singletonMap(product, 1));
        } else {
            Map<Product, Integer> newBucked = new LinkedHashMap<>(oldBucked);
            if (!newBucked.containsKey(product)) {
                newBucked.put(product, 1);
            } else {
                newBucked.put(product, newBucked.get(product) + 1);
            }
            session.setAttribute(PRODUCTS_IN_BUCKET, unmodifiableMap(newBucked));
        }
        return "redirect:/product/" + id;
    }

    @RequestMapping(value = "/productRemoveFromBucket/{id}/{from}", method = RequestMethod.GET)
    public String doRemoveFromBucket (@PathVariable("id") int id, @PathVariable("from") String from, HttpSession session) {
        Product product = eshopService.findProductById(id);
        Map<Product, Integer> oldBucked = (Map < Product, Integer >)session.getAttribute(PRODUCTS_IN_BUCKET);
        Map<Product, Integer> newBucked = new LinkedHashMap<>(oldBucked);
        if (newBucked.get(product) > 1) {
            newBucked.put(product, newBucked.get(product) - 1);
        } else {
            newBucked.remove(product);
        }
        session.setAttribute(PRODUCTS_IN_BUCKET, unmodifiableMap(newBucked));
        String to = from.replace("&", "/");
        return "redirect:/" + to;
    }

    @RequestMapping(value = "/productRemoveAllFromBucket/{from}", method = RequestMethod.GET)
    public String doRemoveAllFromBucket (@PathVariable("from") String from, HttpSession session) {
        session.removeAttribute(PRODUCTS_IN_BUCKET);
        String to = from.replace("&", "/");
        return "redirect:/" + to;
    }

    @RequestMapping(value = "/bucket", method = RequestMethod.GET)
    public String showBucket () {
        return "bucket";
    }


    @RequestMapping(value = "/productRemove/{id}", method = RequestMethod.GET)
    public String doRemoveProduct(@PathVariable("id") int id) {
        eshopService.deleteProduct(id);
        return "redirect:/productAll";
    }

    @RequestMapping(value = "/productAdd", method = RequestMethod.POST)
    public String doAddProduct(HttpServletRequest request) {
        String productName = request.getParameter("productName");
        String productType = request.getParameter("productType");
        ProductType productTypeForSave = eshopService.findType(productType);
        Product productForSave = new Product();
        productForSave.setName(productName);
        productForSave.setType(productTypeForSave);
        eshopService.saveProduct(productForSave);
        return "redirect:/productAll";
    }




}
