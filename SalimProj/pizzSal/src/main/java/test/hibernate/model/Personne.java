package test.hibernate.model;

public class Personne {

	private int id;
	private String nom;
	private String prenom;
	private String tel;
	private String Email;

	public Personne() {
		super();
	}

	public Personne( String nom, String prenom, String tel, String email) {
//		super();
//		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.tel = tel;
		Email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	@Override
	public String toString() {
		return "Personne [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", tel=" + tel + ", Email=" + Email + "]";
	}


}
