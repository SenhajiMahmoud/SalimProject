package test.hibernate.test;

import test.hibernate.manager.PersonneManager;
import test.hibernate.util.HibernateUtil;

public class TestMain {

	public static void main(String[] args) {
		PersonneManager pm = new PersonneManager();
		pm.ajout("Senhaji", "Mahmoud", "0666065573", "senhaji.mahmoud.mi@gmail.com");
//		pm.ajout("Mimid", "Mahmoud", "0666065573", "senhaji.mahmoud.mi@gmail.com");
//		pm.ajout("sss", "Mahmoud", "0666065573", "sema_ma@hotmail.fr");
		HibernateUtil.sessionFactory.close();
	}

}