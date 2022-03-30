package forms;

import javax.servlet.http.HttpServletRequest;

import bean.BeanException;
import bean.Joueur;
import dao.DaoException;
import dao.JoueurDao;

public class InscriptionForm {
	private JoueurDao joueurDao;
	private String resultat;
	
	public InscriptionForm(JoueurDao joueurDao) {
		this.joueurDao=joueurDao;
	}

	public void inscription( HttpServletRequest request ) throws BeanException {
		String nom = request.getParameter("nom");
		String mdp = request.getParameter("mdp");
		String pays = request.getParameter("pays");
		
		if (nom.length()>10) {
			throw new BeanException("le nom ne doit pas d�passer 10 caract�res.");
		}
		if (mdp.length()<6 || mdp.length()>25) {
			throw new BeanException("le mot de passe doit contenir entre 6 � 25 caract�res.");
		}
		if (pays.length()>15) {
			throw new BeanException("le pays ne doit pas d�passer 15 caract�res.");
		}
		
		Joueur joueur = new Joueur(nom,mdp,pays,5000);
		
		try {
			joueurDao.ajouter(joueur);
			resultat = "vous �tes bien inscrits !";
		} 
		catch (Exception e) {
				request.setAttribute("erreur", e.getMessage());
		}
	}
	
	public String getResultat() {
		return resultat;
	}

	public void setResultat(String resultat) {
		this.resultat = resultat;
	}
}
