package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.BeanException;
import dao.DaoException;
import dao.DaoFactory;
import dao.JoueurDao;
import forms.AchatForm;
import forms.InscriptionForm;

/**
 * Servlet implementation class Boutique
 */
@WebServlet(BoutiqueServlet.BOUTIQUE_URL)
public class BoutiqueServlet extends HttpServlet {
	
	/**
	 * L'URL de l'accueil
	 */
	public static final String BOUTIQUE_URL = "/boutique";
	
	private static final long serialVersionUID = 1L;
	
	private JoueurDao joueurDao;

    public void init() throws ServletException {
        DaoFactory daoFactory = DaoFactory.getInstance();
        this.joueurDao = daoFactory.getUtilisateurDao();
    }
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoutiqueServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		if (session.getAttribute("nomSession") != null) { 
			int[] skins = new int[9];
			int bucks = 0;
			try {
				skins = joueurDao.getSkins((String) session.getAttribute("nomSession"));
				bucks = joueurDao.getBucks((String) session.getAttribute("nomSession"));
			} catch (DaoException e) {
				// TODO Auto-generated catch block
				request.setAttribute("erreur", e.getMessage());
			}
			
			
			request.setAttribute("skins", skins);
			request.setAttribute("bucks", bucks);
		}
		request.getRequestDispatcher("/WEB-INF/boutique.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		AchatForm form = new AchatForm(joueurDao);
		
		try {
			form.achat(request, (String) session.getAttribute("nomSession"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			request.setAttribute("erreur", e.getMessage());
		} 
		
		request.setAttribute("form",form);
		doGet(request, response);
	}

}
