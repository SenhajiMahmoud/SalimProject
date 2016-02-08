package test.hibernate.manager;

import org.hibernate.Session;

import test.hibernate.model.Personne;
import test.hibernate.util.HibernateUtil;

public class PersonneManager {
	
	
	public void ajout(String nom, String prenom, String tel, String email) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Personne p = new Personne();
		p.setNom(nom);
		p.setPrenom(prenom);
		p.setTel(tel);
		p.setEmail(email);
		session.save(p);
		session.getTransaction().commit();
	}
	
	public void supprimer(int id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Personne p = session.load(Personne.class, id);
		
		session.delete(p);
		session.getTransaction().commit();
	}
}
