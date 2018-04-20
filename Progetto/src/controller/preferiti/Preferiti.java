 package controller.preferiti;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Connessione.User;
import beans.AppuntiBeans;
import beans.LezioneBeans;
import beans.LibroBeans;
import beans.UtenteBeans;

/**
 * Servlet implementation class Preferiti
 */
@WebServlet("/Carrello")
public class Preferiti extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Preferiti() {
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
		
		if(utente != null) {	
			String id = (String)request.getParameter("id");
				
						try {
							
							
							ArrayList<AppuntiBeans> appunti=new ArrayList<AppuntiBeans>();
							appunti=classiDao.AppuntiDao.Select_appunti_id(id);
							
							if( !appunti.isEmpty()) {
								utente.addAppunti(appunti.get(0));
							}

							
							ArrayList<LibroBeans> libro=new ArrayList<LibroBeans>();
							libro=classiDao.LibroDao.Select_libri_id(id);
							
							if( !libro.isEmpty()) {
								utente.addLibri(libro.get(0));
							}
							
							
							ArrayList<LezioneBeans> lezione=new ArrayList<LezioneBeans>();
							lezione=classiDao.LezioneDao.Select_lezione_id(id);
							
							if( !lezione.isEmpty()) {
								utente.addLezioni(lezione.get(0));
							}


						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		}
					
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
