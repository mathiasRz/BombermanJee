package dao;


import bean.BeanException;
import bean.Joueur;

public interface JoueurDao {
	
	public void ajouter(Joueur joueur)throws DaoException, BeanException;
	public void supprimer(String nom)throws DaoException;
	public boolean verifierLogin(String nom,String mdp) throws DaoException;
}
