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
import forms.InscriptionForm;

/**
 * Servlet implementation class InscriptionServlet
 */
@WebServlet(InscriptionServlet.INSCRIPTION_URL)
public class InscriptionServlet extends HttpServlet {
	
	/**
	 * L'URL de l'inscription
	 */
	public static final String INSCRIPTION_URL = "/inscription";
	
	private static final long serialVersionUID = 1L;
    
	private JoueurDao joueurDao;

    public void init() throws ServletException {
        DaoFactory daoFactory = DaoFactory.getInstance();
        this.joueurDao = daoFactory.getUtilisateurDao();
    }
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InscriptionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/inscription.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		InscriptionForm form = new InscriptionForm(joueurDao);
		
		try {
			form.inscription(request);
			HttpSession session = request.getSession();

	        session.setAttribute("nomSession", request.getParameter("nom"));
		} catch (BeanException e) {
			request.setAttribute("erreur", e.getMessage());;
		}
		
		request.setAttribute("form",form);
		doGet(request, response);
	}

}
