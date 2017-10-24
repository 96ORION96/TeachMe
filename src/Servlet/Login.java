package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Beans.UtenteBeans;
import Connessione.User;
/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UtenteBeans utente;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		{
			HttpSession session = request.getSession();
			 utente = (UtenteBeans) session.getAttribute("utente");
			 
			
			 String strLogin = request.getParameter("user");
			 String strPsw   = request.getParameter("psw");

			
					try {
						utente=ClassiDao.UtenteDao.SelectUtente(strLogin, strPsw);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						
						System.out.println("ecc1");
						

					}
				
		
					if(utente==null)
					{
							
						getServletContext().getRequestDispatcher("/homepage.jsp").forward(request, response);
					}

					
					else
					{
						utente.setLogin(true);
						session.setAttribute("utente", utente);
						getServletContext().getRequestDispatcher("/homepage.jsp").forward(request, response);
						
					}

				
			 	
    }
  }
}
	
