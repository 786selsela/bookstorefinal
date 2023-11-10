package com.bookStore.controller;

import com.bookStore.entity.Seller;
import com.bookStore.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/sellers")
public class SellerController {
    private final SellerService sellerService;

    @Autowired
    public SellerController(SellerService sellerService) {
        this.sellerService = sellerService;
    }

    @GetMapping
    public String showSellerList(Model model) {
        List<Seller> sellers = sellerService.getAllSellers();
        model.addAttribute("sellers", sellers);
        return "seller_list"; // Thymeleaf template to display a list of sellers
    }

    @GetMapping("/create")
    public String showSellerForm(Model model) {
        model.addAttribute("seller", new Seller());
        return "seller_form"; // Thymeleaf template for creating or editing a seller
    }

    @PostMapping("/save")
    public String saveSeller(@ModelAttribute("seller") Seller seller) {
        sellerService.saveSeller(seller);
        return "redirect:/sellers"; // Redirect to the list of sellers
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Seller seller = sellerService.getSellerById(id);
        model.addAttribute("seller", seller);
        return "seller_form"; // Thymeleaf template for creating or editing a seller
    }

    @GetMapping("/delete/{id}")
    public String deleteSeller(@PathVariable("id") Long id) {
        sellerService.deleteSeller(id);
        return "redirect:/sellers"; // Redirect to the list of sellers
    }
}



