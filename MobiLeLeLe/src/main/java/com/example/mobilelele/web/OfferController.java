package com.example.mobilelele.web;

import com.example.mobilelele.models.dtos.banding.AddOfferDTO;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller("/offers/all")
public class OfferController {

    @GetMapping("/offers/all")
    public String allOffers(){
        return "offers";
    }

    @GetMapping("/offers/add")
    public String addOffer(){
        return "offer-add";
    }

//    @PostMapping("/offers/add")
//    public String postAddOffer(@Valid @ModelAttribute(name = "addOfferDTO")AddOfferDTO addOfferDTO,
//                               BindingResult bindingResult, RedirectAttributes redirectAttributes){
//
//        if (bindingResult.hasErrors()){
//            redirectAttributes.addFlashAttribute("addOfferDTO",addOfferDTO);
//            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.addOfferDTO",bindingResult);
//        }
//
//
//    }

    @ModelAttribute(name = "addOfferDTO")
    public AddOfferDTO addOfferDTO(){
        return new AddOfferDTO();
    }
}
