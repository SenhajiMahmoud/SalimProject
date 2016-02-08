package test.hibernate.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import test.hibernate.manager.PersonneManager;
import test.hibernate.model.Personne;
import test.hibernate.util.HibernateUtil;

public class TestMain {
	public TestMain() {
		exp10();
	}
	
	void exp01(){
		PersonneManager pm = new PersonneManager();
		pm.ajout("Senhaji", "Mahmoud", "0666065573", "senhaji.mahmoud.mi@gmail.com");
		pm.ajout("Mimid", "Mahmoud", "0666065573", "senhaji.mahmoud.mi@gmail.com");
		pm.ajout("sss", "Mahmoud", "0666065573", "sema_ma@hotmail.fr");
		HibernateUtil.sessionFactory.close();
	}
	
	void exp02(){
		PersonneManager pm = new PersonneManager();
		pm.Modifier(2);
		HibernateUtil.sessionFactory.close();
	}
	
	void exp03(){
		PersonneManager pm = new PersonneManager();
		pm.supprimer(1);
		HibernateUtil.sessionFactory.close();
	}
	
	void exp04(){
		PersonneManager pm = new PersonneManager();
		Personne p = new Personne("Senhaji", "Mahmoud", "0666065573", "senhaji.mahmoud.mi@gmail.com");
		pm.Chercher(p);
		HibernateUtil.sessionFactory.close();
	}
	
	void exp05(){
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		Personne p = s.load(Personne.class, 2);
		System.out.println("Avant " + p );
		String q = "update personnes set Nom_personne='Mimidi' where id_personne=2;";
		s.createSQLQuery(q).executeUpdate();
		s.refresh(p);
		System.out.println("Apres " + p );
		s.getTransaction().commit();
		HibernateUtil.sessionFactory.close();
	}
	
	void exp06(){
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.getCurrentSession();
			s.beginTransaction();
				Personne p = s.load(Personne.class, 2);
				System.out.println(p + " " + s.isDirty());
				p.setNom("nom");
				System.out.println(p + " " + s.isDirty());
			s.getTransaction().commit();
		HibernateUtil.sessionFactory.close();
	}
	
	void exp07(){
		Session s = HibernateUtil.getSessionFactory().getCurrentSession();
		s.beginTransaction();
			s.beginTransaction();
				Personne p = s.get(Personne.class, 2);
				s.evict(p);
				p.setNom("nom3");
				s.update(p);
			s.getTransaction().commit();
		HibernateUtil.sessionFactory.close();
	}
	@SuppressWarnings("unchecked")
	void exp08(){
		Session s = HibernateUtil.getSessionFactory().getCurrentSession();
		s.beginTransaction();
			s.beginTransaction();
				String req = "select * from personnes";
				SQLQuery sql = s.createSQLQuery(req);
				sql.addEntity(Personne.class);
				
				List<Personne> pers = sql.list();
				for (Personne personne : pers) {
					System.out.println(personne);
				}
			s.getTransaction().commit();
		HibernateUtil.sessionFactory.close();
	}
	
	void exp09(){
		Session s = HibernateUtil.getSessionFactory().getCurrentSession();
		s.beginTransaction();
			s.beginTransaction();
				String q = "update personnes set Nom_personne='Mimidi' where id_personne=2;";
				SQLQuery sql = s.createSQLQuery(q);
				sql.executeUpdate();
			s.getTransaction().commit();
		HibernateUtil.sessionFactory.close();
	}
	
	
//	Langage HQL
	@SuppressWarnings("unchecked")
	void exp10(){
		Session s = HibernateUtil.getSessionFactory().getCurrentSession();
		s.beginTransaction();
//			s.beginTransaction();
				
				List<Personne> l = s.createQuery("from Personne").list();
				for (Personne personne : l) {
					System.out.println(personne);
				}
//			s.getTransaction().commit();
		HibernateUtil.sessionFactory.close();
	}
	
	public static void main(String[] args) {
		new TestMain();
	}

}
