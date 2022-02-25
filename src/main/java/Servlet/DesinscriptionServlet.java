package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DaoException;
import dao.DaoFactory;
import dao.JoueurDao;

/**
 * Servlet implementation class DesinscriptionServlet
 */
@WebServlet(DesinscriptionServlet.DESINSCRIPTION_URL)
public class DesinscriptionServlet extends HttpServlet {
	
	/**
	 * L'URL de désinscription
	 */
	public static final String DESINSCRIPTION_URL = "/desinscription";
	
	private static final long serialVersionUID = 1L;
	
	private JoueurDao joueurDao;

    public void init() throws ServletException {
        DaoFactory daoFactory = DaoFactory.getInstance();
        this.joueurDao = daoFactory.getUtilisateurDao();
    }
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DesinscriptionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		try {
			joueurDao.supprimer((String) session.getAttribute("nomSession"));
			request.setAttribute("valide", "vous avez bien été désinscrits !");
			session.invalidate();
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			request.setAttribute("erreur", e.getMessage());
		}
		request.getRequestDispatcher("/WEB-INF/desinscription.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
