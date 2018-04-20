package controller.utente;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.LibroBeans;
import beans.UtenteBeans;

/**
 * Servlet implementation class InsLibri
 */
@WebServlet("/InsLibri")
public class InsLibri extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsLibri() {
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
			
								Random rand = new Random();
								int num = rand.nextInt(1000000000);
								id = "lib-"+num;
			
								ArrayList<LibroBeans> libroTest = new ArrayList<>();
								libroTest = classiDao.LibroDao.Select_libri_id(id);
					
									if(libroTest.isEmpty()) {	break;  }
					
						}
						
		String email       = utente.getEmail();
		String titolo     = request.getParameter("titolo");
		String materia    =	request.getParameter("mat");
		String facolta	  = request.getParameter("fac");
		String universita = request.getParameter("uni");
		Double prezzo     = (double) Integer.parseInt(request.getParameter("prezzo"));
		
		LibroBeans libro = new LibroBeans(email, id, titolo, materia, facolta, universita, prezzo);
		classiDao.LibroDao.Insert(libro);
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
