package models;

public class Produit {
	private String ref;
	private String desig;
	private double pu;
	private double qs;

	public Produit() {
		super();
	}

	public Produit(String ref, String desig, double pu, double qs) {
		super();
		this.ref = ref;
		this.desig = desig;
		this.pu = pu;
		this.qs = qs;
	}

	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	public String getDesig() {
		return desig;
	}

	public void setDesig(String desig) {
		this.desig = desig;
	}

	public double getPu() {
		return pu;
	}

	public void setPu(double pu) {
		this.pu = pu;
	}

	public double getQs() {
		return qs;
	}

	public void setQs(double qs) {
		this.qs = qs;
	}

}
