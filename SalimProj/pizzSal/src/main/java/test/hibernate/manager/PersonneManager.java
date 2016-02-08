package test.hibernate.manager;

import org.hibernate.Session;

import test.hibernate.model.Personne;
import test.hibernate.util.HibernateUtil;

public class PersonneManager {
	private Session session;
	
	public PersonneManager() {
		session = HibernateUtil.getSessionFactory().getCurrentSession();
	}

	public void ajout(String nom, String prenom, String tel, String email) {
		
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
		session.beginTransaction();
		Personne p = session.load(Personne.class, id);
		session.delete(p);
		session.getTransaction().commit();
	}

	public void Modifier(int id) {
		session.beginTransaction();
		Personne p = session.get(Personne.class, id);
		p.setNom("aaa");
		p.setPrenom("bbb");
		p.setTel("mmmmmmmmmm");
		p.setEmail("sss@ss.fr");
//		session.update(p);
		System.out.println(p.getNom());
		session.getTransaction().commit();
	}

	public void Chercher(Personne p) {
		session.beginTransaction();
		session.persist(p);
		if (session.contains(p)) {
			System.out.println("ok");
		} else {
			System.out.println("p Non trouvee");
		}
		session.getTransaction().commit();
	}

}
