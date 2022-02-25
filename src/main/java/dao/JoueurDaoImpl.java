package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bean.BeanException;
import bean.Joueur;

public class JoueurDaoImpl implements JoueurDao {
	private DaoFactory daoFactory;

    JoueurDaoImpl(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }
    

	@Override
	public void ajouter(Joueur joueur) throws DaoException, BeanException {
		// TODO Auto-generated method stub
		Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultat = null;
        try {
            connexion = daoFactory.getConnection();
            
            //requête de verification de l'unicité du nom du joueur avant de l'ajouter à la base
            preparedStatement = connexion.prepareStatement("SELECT nom FROM joueur WHERE nom=?;");
            preparedStatement.setString(1, joueur.getNom());
            resultat = preparedStatement.executeQuery();
            if (resultat.next()) {
            	throw new BeanException("Ce pseudo existe déja !");
            }
            
            preparedStatement = connexion.prepareStatement("INSERT INTO joueur(nom,mdp,pays,nb_parties,nb_parties_win) VALUES(?,?,?,?,?);");
            preparedStatement.setString(1, joueur.getNom());
            preparedStatement.setString(2, joueur.getMdp());
            preparedStatement.setString(3, joueur.getPays());
            preparedStatement.setInt(4, joueur.getNb_parties());
            preparedStatement.setInt(5, joueur.getNb_parties_win());
            preparedStatement.executeUpdate();
            connexion.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DaoException("Impossible de communiquer avec la base de données");
        }
    }
	
	public boolean verifierLogin(String nom,String mdp) throws DaoException {
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
        ResultSet resultat = null;

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement("SELECT nom FROM Joueur WHERE nom=? AND mdp=?;");
            preparedStatement.setString(1, nom);
            preparedStatement.setString(2, mdp);
            resultat = preparedStatement.executeQuery();
            
            if (resultat.next()) {
            	return true;
            }
            else {
            	return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DaoException("Impossible de communiquer avec la base de données");
        }
        finally {
            try {
                if (connexion != null) {
                    connexion.close();  
                }
            } catch (SQLException e) {
                throw new DaoException("Impossible de communiquer avec la base de données");
            }
        }
	}


	@Override
	public void supprimer(String nom) throws DaoException {
		// TODO Auto-generated method stub
		Connection connexion = null;
        PreparedStatement preparedStatement = null;
        try {
            connexion = daoFactory.getConnection();
            
            preparedStatement = connexion.prepareStatement("DELETE FROM joueur WHERE nom=?;");
            preparedStatement.setString(1, nom);
            preparedStatement.executeUpdate();
            connexion.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DaoException("Impossible de communiquer avec la base de données");
        }
	}

}
