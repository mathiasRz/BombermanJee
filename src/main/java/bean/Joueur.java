package bean;

public class Joueur {
	
	private String nom;
	private String mdp;
	private String pays;
	private int nb_parties;
	private int nb_parties_win;
	
	public Joueur(String nom, String mdp, String pays, int nb_parties, int nb_parties_win) {
		this.nom = nom;
		this.mdp = mdp;
		this.pays = pays;
		this.nb_parties = nb_parties;
		this.nb_parties_win = nb_parties_win;
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
	public int getNb_parties() {
		return nb_parties;
	}
	public void setNb_parties(int nb_parties) {
		this.nb_parties = nb_parties;
	}
	public int getNb_parties_win() {
		return nb_parties_win;
	}
	public void setNb_parties_win(int nb_parties_win) {
		this.nb_parties_win = nb_parties_win;
	}
	
	
}
