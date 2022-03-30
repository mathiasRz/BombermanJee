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
            
            preparedStatement = connexion.prepareStatement(
            		"INSERT INTO joueur(nom,mdp,pays,bucks,white,black,lady,magnet,plasma,pretty,golem,regulus_bullzeeb,brain) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?);");
            preparedStatement.setString(1, joueur.getNom());
            preparedStatement.setString(2, joueur.getMdp());
            preparedStatement.setString(3, joueur.getPays());
            preparedStatement.setInt(4, joueur.getNb_bucks());
            preparedStatement.setInt(5, 1);
            preparedStatement.setInt(6, 0);
            preparedStatement.setInt(7, 0);
            preparedStatement.setInt(8, 0);
            preparedStatement.setInt(9, 0);
            preparedStatement.setInt(10, 0);
            preparedStatement.setInt(11, 0);
            preparedStatement.setInt(12, 0);
            preparedStatement.setInt(13, 0);
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


	@Override
	public void achatSkin(String nom,int bucks,String skin) throws DaoException, BeanException {
		// TODO Auto-generated method stub
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
        ResultSet resultat = null;

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement("SELECT bucks FROM Joueur WHERE nom=?;");
            preparedStatement.setString(1, nom);
            resultat = preparedStatement.executeQuery();
            resultat.next();
            if (resultat.getInt("bucks")-bucks > 0) {
            	preparedStatement = connexion.prepareStatement("UPDATE joueur SET bucks=?,"+skin+"=1 WHERE nom=?;");
                preparedStatement.setInt(1, resultat.getInt("bucks")-bucks);
                preparedStatement.setString(2, nom);
                preparedStatement.executeUpdate();
                connexion.commit();
                
                /*
                preparedStatement = connexion.prepareStatement("UPDTATE joueur SET ?=1 WHERE nom=?;");
                preparedStatement.setString(1, skin);
                preparedStatement.setString(2, nom);
                preparedStatement.executeUpdate();
                connexion.commit();
                */
            }
            else {
            	throw new BeanException("Pas assez de bucks pour acheter ce skin !");
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
	public int[] getSkins(String nom) throws DaoException {
		// TODO Auto-generated method stub
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
        ResultSet resultat = null;

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement("SELECT white,black,lady,magnet,plasma,pretty,golem,regulus_bullzeeb,brain FROM Joueur WHERE nom=?;");
            preparedStatement.setString(1, nom);
            resultat = preparedStatement.executeQuery();
            
            resultat.next();
            
            int[] skins = new int[9];
            for (int i=0; i < 9; ++i) {
            	skins[i] = resultat.getInt(i+1);
            }
            
            return skins;
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
	public int getBucks(String nom) throws DaoException {
		// TODO Auto-generated method stub
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
        ResultSet resultat = null;

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement("SELECT bucks FROM Joueur WHERE nom=?;");
            preparedStatement.setString(1, nom);
            resultat = preparedStatement.executeQuery();
            
            resultat.next();
            
            return resultat.getInt("bucks");
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
	
	

}
