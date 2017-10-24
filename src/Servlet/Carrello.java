package Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Beans.AppuntiBeans;
import Beans.LibroBeans;
import Beans.UtenteBeans;
import Connessione.User;

/**
 * Servlet implementation class Carrello
 */
@WebServlet("/Carrello")
public class Carrello extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Carrello() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UtenteBeans utente;
		HttpSession session = request.getSession();
		utente = (UtenteBeans) session.getAttribute("utente");
		String isbn = (String)request.getParameter("libro");
		String idApp= (String)request.getParameter("appunti");
		String idLez= (String)request.getParameter("lezione");
		
			if(isbn != null) {
				try {
					utente.addLibri(ClassiDao.LibroDao.Select_libri_isbn(isbn));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
			
			if(idLez != null) {
				try {
					utente.addLezioni(ClassiDao.LezioneDao.Select_lezione_id(idLez));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
			
			if(idApp != null) {
				try {
					utente.addAppunti(ClassiDao.AppuntiDao.Select_appunti_id(idApp));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		
		getServletContext().getRequestDispatcher("/cart.jsp").forward(request, response);
	}
					
			
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
