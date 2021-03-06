package com.salim.web.business;

import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import org.springframework.stereotype.Service;

import models.Produit;

@Service
public class DefaultProduitService implements ProduitService {

	HashMap<String, Produit> list;

	public DefaultProduitService() {
		list = new HashMap<String, Produit>();
		list.put("C01", new Produit("C01", "Clav", 20, 2));
		list.put("C02", new Produit("C02", "Clav", 20, 2));
		list.put("C03", new Produit("C03", "Clav", 20, 2));

	}

	public int add(Produit p) {
		if (list.containsKey(p.getRef())) {
			return 0;
		} else {
			list.put(p.getRef(), p);
			return 1;
		}
	}

	public Produit get(String ref) {
		return list.get(ref);
	}

	public List<Produit> list() {
		return new Vector<Produit>(list.values());
	}

}
