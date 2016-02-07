package com.salim.pzz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.salim.web.business.ProduitService;

import models.Produit;

@Controller
public class ProdController {

	@Autowired
	ProduitService service;

	public ProdController() {
	}

	@RequestMapping("/ProduitAjouter")
	public String ajouterProd(@ModelAttribute Produit p, Model model) {
		if (service.add(p) > 0) {
			model.addAttribute("model", service.list());
			return "ProduitList";
		} else {
			model.addAttribute("model", "Impossible d'ajouter ce produit");
			return "repError";
		}
	}

	@RequestMapping("/ProduitChercher")
	public String ChercherProd(String ref, Model model) {
			Produit p = service.get(ref);
			model.addAttribute("model", p);
			return "ProduitChercher";
	}
	
	
	@RequestMapping("/ProduitList")
	public ModelAndView listProd() {
			return new ModelAndView("ProduitList", "model", service.list());
	}

}
