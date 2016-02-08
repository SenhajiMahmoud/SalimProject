package com.salim.pzz.controller;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.salim.web.business.ProduitService;

import models.Produit;
import test.hibernate.manager.PersonneManager;
import test.hibernate.model.Personne;
import test.hibernate.util.HibernateUtil;

@Controller
public class ProdController {

	@Autowired
	ProduitService service;
	private Session session;
	PersonneManager pm = new PersonneManager();

	public ProdController() {

		pm = new PersonneManager();
		session = HibernateUtil.getSessionFactory().getCurrentSession();

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

	@RequestMapping("/tt")
	@SuppressWarnings("unchecked")
	public ModelAndView TestHibernate() {

		pm.ajout("Senhaji", "Mahmoud", "0666065573", "senhaji.mahmoud.mi@gmail.com");
		pm.ajout("Mimid", "Mahmoud", "0666065573", "senhaji.mahmoud.mi@gmail.com");
		pm.ajout("sss", "Mahmoud", "0666065573", "sema_ma@hotmail.fr");

		session.beginTransaction();
		
		List<Personne> l = session.createQuery("from Personne").list();
		for (Personne personne : l) {
			System.out.println(personne);
		}
		// HibernateUtil.sessionFactory.close();
		return new ModelAndView("ProduitList", "model", "ok");
	}

}
