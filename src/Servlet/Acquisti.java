
package Servlet;
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

import Beans.AppuntiBeans;
import Beans.LezioneBeans;
import Beans.LibroBeans;
import Beans.UtenteBeans;
import ClassiDao.AppuntiDao;
import ClassiDao.LezioneDao;
import ClassiDao.LibroDao;
import Connessione.User;

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
		
		ServletContext context=getServletContext();

		ArrayList<LezioneBeans> risLezioni=null;
		ArrayList<AppuntiBeans> risAppunti=null;
		ArrayList<LibroBeans>   risLibro=null;
		String valueUniversita =(String)request.getParameter("universita");
		String valueFacolta =(String)request.getParameter("facolta");
		String valueCorso =(String)request.getParameter("corso");
		String tipo = (String)request.getParameter("tipo");
		
			if("libri".equals(tipo)) {
				
				try {
					risLibro=ClassiDao.LibroDao.Select_libro_mat_fac_uni(valueCorso, valueFacolta, valueUniversita);
					for(int i=0;i<risLibro.size();i++)
					response.getWriter().write(risLibro.get(i).toString()+" <input type=\"button\" value=\"aggiungi al carrello\" onclick=\"funCarr(\"libro\")\"/>"+"<br/><br/>");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		
			if("appunti".equals(tipo)) {
				
					try {
						risAppunti=ClassiDao.AppuntiDao.Select_appunti_mat_fac_uni(valueCorso, valueFacolta, valueUniversita);
						for(int i=0;i<risAppunti.size();i++)
							response.getWriter().write(risAppunti.get(i).toString()+" <input type=\"button\" value=\"aggiungi al carrello\" onclick=\"funCarr(risAppunti.get(i))\"/>"+"<br/><br/>");
						

					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
				}
				
			}
		
		
			if("lezioni".equals(tipo)) {
				
				try {
					risLezioni=ClassiDao.LezioneDao.Select_lezione_mat_fac_uni(valueCorso, valueFacolta, valueUniversita);
					for(int i=0;i<risLezioni.size();i++)
						response.getWriter().write(risLezioni.get(i).toString()+" <input type=\"button\" value=\"aggiungi al carrello\" onclick=\"funCarr(risLezioni.get(i))\"/>"+"<br/> <br/>");
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
