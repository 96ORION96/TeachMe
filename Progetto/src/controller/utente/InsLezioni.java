package controller.utente;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.LezioneBeans;
import beans.LibroBeans;
import beans.UtenteBeans;

/**
 * Servlet implementation class InsLezioni
 */
@WebServlet("/InsLezioni")
public class InsLezioni extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsLezioni() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		
		UtenteBeans utente;
		HttpSession session = request.getSession();
		utente = (UtenteBeans) session.getAttribute("utente");
		
		if(utente != null) {
			try {
				
					String id;
					
						while(true) {
							Random ran = new Random();
							int num=ran.nextInt(100000000);
							id = "lez-"+num;

							ArrayList<LezioneBeans> lezTest = new ArrayList<>();
							lezTest = classiDao.LezioneDao.Select_lezione_id(id);
		
								if(lezTest.isEmpty()) {	break;  }
		
						}
			
					String email      = utente.getEmail();
					String titolo     = request.getParameter("titolo");
					String materia    =	request.getParameter("mat");
					String facolta	  = request.getParameter("fac");
					String universita = request.getParameter("uni");
					Double prezzo     = (double) Integer.parseInt(request.getParameter("prezzo"));
					
					LezioneBeans lez = new LezioneBeans(titolo, id, materia, facolta,universita , email, prezzo);
					classiDao.LezioneDao.Insert(lez);
					getServletContext().getRequestDispatcher("/areaUtente.jsp").forward(request, response);	
					

				} catch (NumberFormatException e) {
					request.setAttribute("double", "si");
					getServletContext().getRequestDispatcher("/areaUtente.jsp").forward(request, response);
				}catch (Exception e) {
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
