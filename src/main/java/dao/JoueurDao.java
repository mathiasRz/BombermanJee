package dao;


import bean.BeanException;
import bean.Joueur;

public interface JoueurDao {
	
	public void ajouter(Joueur joueur)throws DaoException, BeanException;
	public void supprimer(String nom)throws DaoException;
	public boolean verifierLogin(String nom,String mdp) throws DaoException;
	public void achatSkin(String nom,int bucks,String skin) throws DaoException, BeanException;
	public int[] getSkins(String nom) throws DaoException;
	public int getBucks(String nom) throws DaoException;
}
