package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.BeanException;
import dao.DaoFactory;
import dao.JoueurDao;
import forms.ConnexionForm;

/**
 * Servlet implementation class ConnectionServlet
 */
@WebServlet(ConnexionServlet.CONNEXION_URL)
public class ConnexionServlet extends HttpServlet {
	
	/**
	 * L'URL de connexion
	 */
	public static final String CONNEXION_URL = "/connexion";
	
	private static final long serialVersionUID = 1L;
       
	
	private JoueurDao joueurDao;

    public void init() throws ServletException {
        DaoFactory daoFactory = DaoFactory.getInstance();
        this.joueurDao = daoFactory.getUtilisateurDao();
    }
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConnexionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/connexion.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ConnexionForm form = new ConnexionForm(joueurDao);
		try {
			form.verifierIdenfiant(request);
			HttpSession session = request.getSession();

	        session.setAttribute("nomSession", request.getParameter("nom"));
		} catch (BeanException e) {
			// TODO Auto-generated catch block
			request.setAttribute("erreur", e.getMessage());
		}
		
		request.setAttribute("form",form);
		doGet(request, response);
		
	}

}
