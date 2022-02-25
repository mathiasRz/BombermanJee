package forms;

import javax.servlet.http.HttpServletRequest;

import bean.BeanException;
import dao.DaoException;
import dao.JoueurDao;


public class ConnexionForm {
	private JoueurDao joueurDao;
	private String resultat;
	
	public ConnexionForm(JoueurDao joueurDao) {
		this.joueurDao=joueurDao;
	}

	public void verifierIdenfiant( HttpServletRequest request) throws BeanException {
		String nom = request.getParameter("nom");
		String mdp = request.getParameter("mdp");
		
		try {
			if (!joueurDao.verifierLogin(nom, mdp)) {
				throw new BeanException("identifiants incorrects, veuillez réessayer !");
			}
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			request.setAttribute("erreur",e.getMessage());
		}
		
		
		resultat = " vous êtes connectés !";
		
		
	}
	public String getResultat() {
		return resultat;
	}

	public void setResultat(String resultat) {
		this.resultat = resultat;
	}
	
	
}
