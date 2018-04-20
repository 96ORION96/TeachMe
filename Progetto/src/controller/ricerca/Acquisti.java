
package controller.ricerca;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Context;
import org.apache.catalina.core.ApplicationContext;

import com.google.gson.Gson;

import Connessione.User;
import beans.AppuntiBeans;
import beans.LezioneBeans;
import beans.LibroBeans;
import beans.UtenteBeans;
import classiDao.AppuntiDao;
import classiDao.LezioneDao;
import classiDao.LibroDao;

/**
 * Servlet implementation class Acquisti
 */
@WebServlet("/Acquisti")
public class Acquisti extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UtenteBeans utente;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Acquisti() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		

		ArrayList<LezioneBeans> risLezioni=null;
		ArrayList<AppuntiBeans> risAppunti=null;
		ArrayList<LibroBeans>   risLibro=null;
		String valueUniversita =(String)request.getParameter("universita");
		String valueFacolta =(String)request.getParameter("facolta");
		String valueCorso =(String)request.getParameter("corso");
		String tipo = (String)request.getParameter("tipo");
		Gson parser = new Gson();
			if("libri".equals(tipo)) {
				
				try {
					
					
					risLibro=classiDao.LibroDao.Select_libro_mat_fac_uni(valueCorso, valueFacolta, valueUniversita);
					String libri_gson = parser.toJson(risLibro);
					response.getWriter().write(libri_gson);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		
			if("appunti".equals(tipo)) {
				
					try {
						risAppunti=classiDao.AppuntiDao.Select_appunti_mat_fac_uni(valueCorso, valueFacolta, valueUniversita);
						String appunti_gson = parser.toJson(risAppunti);
						response.getWriter().write(appunti_gson);

					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
				}
				
			}
		
		
			if("lezioni".equals(tipo)) {
				
				try {
					risLezioni=classiDao.LezioneDao.Select_lezione_mat_fac_uni(valueCorso, valueFacolta, valueUniversita);
					String lezioni_gson = parser.toJson(risLezioni);
					response.getWriter().write(lezioni_gson);
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
