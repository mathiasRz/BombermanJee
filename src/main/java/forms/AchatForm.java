package forms;

import javax.servlet.http.HttpServletRequest;

import bean.BeanException;
import dao.DaoException;
import dao.JoueurDao;

public class AchatForm {
	private JoueurDao joueurDao;
	
	public AchatForm(JoueurDao joueurDao) {
		this.joueurDao=joueurDao;
	}
	
	public void achat(HttpServletRequest request, String nom) throws DaoException, BeanException {
		
		String nomJoueur = nom;
		int montantAchat = Integer.parseInt(request.getParameter("valeur"));
		String skin = request.getParameter("skin");
		
		joueurDao.achatSkin(nom,montantAchat,skin);
	}
	
}
