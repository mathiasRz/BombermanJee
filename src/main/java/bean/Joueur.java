package bean;

public class Joueur {
	
	private String nom;
	private String mdp;
	private String pays;
	private int nb_bucks;
	
	public Joueur(String nom, String mdp, String pays, int nb_bucks) {
		this.nom = nom;
		this.mdp = mdp;
		this.pays = pays;
		this.nb_bucks = nb_bucks;
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	public String getPays() {
		return pays;
	}
	public void setPays(String pays) {
		this.pays = pays;
	}
	public int getNb_bucks() {
		return nb_bucks;
	}
	public void setNb_bucks(int nb_bucks) {
		this.nb_bucks = nb_bucks;
	}
	
	
}
