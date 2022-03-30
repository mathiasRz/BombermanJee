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
 * Servlet implementation class CompteServlet
 */
@WebServlet(CompteServlet.COMPTE_URL)
public class CompteServlet extends HttpServlet {
	
	/**
	 * L'URL de compte
	 */
	public static final String COMPTE_URL = "/compte";
	
	private static final long serialVersionUID = 1L;
    
	private JoueurDao joueurDao;

    public void init() throws ServletException {
        DaoFactory daoFactory = DaoFactory.getInstance();
        this.joueurDao = daoFactory.getUtilisateurDao();
    }
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CompteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		int bucks = 0;
		try {
			bucks = joueurDao.getBucks((String) session.getAttribute("nomSession"));
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			request.setAttribute("erreur", e.getMessage());
		}
		request.setAttribute("bucks", bucks);
		request.getRequestDispatcher("/WEB-INF/compte.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
