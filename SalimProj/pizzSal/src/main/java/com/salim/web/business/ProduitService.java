package com.salim.web.business;

import java.util.List;

import models.Produit;

public interface ProduitService {
	public int add(Produit p);
	public Produit get(String ref);
	public List<Produit> list();
}
