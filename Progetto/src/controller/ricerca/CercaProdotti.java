package controller.ricerca;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import beans.AdminBeans;
import beans.AppuntiBeans;
import beans.LezioneBeans;
import beans.LibroBeans;
import beans.UtenteBeans;

/**
 * Servlet implementation class CercaUtenti
 */
@WebServlet("/CercaProdotti")
public class CercaProdotti extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UtenteBeans utente; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CercaProdotti() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		utente = (UtenteBeans) session.getAttribute("utente");
		
		if(utente != null) {
						try {
							
							
							String email = utente.getEmail();
							
							
							
							ArrayList<LibroBeans> libri=classiDao.LibroDao.Select_libri_email(email);
							ArrayList<AppuntiBeans>appunti = classiDao.AppuntiDao.Select_appunti_email(email);
							ArrayList<LezioneBeans>lezioni = classiDao.LezioneDao.Select_lezione_email(email);
							
							request.setAttribute("libri", libri);
							
							
							request.setAttribute("appunti",appunti);
							
							
							request.setAttribute("lezioni", lezioni);
							
							getServletContext().getRequestDispatcher("/rimProd.jsp").forward(request, response);
							
							
						

							
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
