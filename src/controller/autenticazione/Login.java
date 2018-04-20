package controller.autenticazione;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Connessione.User;
import beans.AdminBeans;
import beans.UtenteBeans;
/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UtenteBeans utente;
	private AdminBeans admin;
       
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
			 admin = (AdminBeans) session.getAttribute("admin");
			
			 String strMail = request.getParameter("mail");
			 String strPsw   = request.getParameter("psw");

			
					try {
				
						utente=classiDao.UtenteDao.SelectUtente(strMail, strPsw);
						admin=classiDao.AdminDao.SelectAdmin(strMail, strPsw);

					} catch (Exception e) {
						// TODO Auto-generated catch block
						
						System.out.println("Eccezzione dutante la login:utente o admin non trovato");
						

					}
				
		
					if(utente==null && admin==null)
					{
						request.setAttribute("control", "si");
						System.out.println("entrambi null");
						getServletContext().getRequestDispatcher("/home.jsp").forward(request, response);
					}

					
					else
					{
						if(utente!=null) {
							
							System.out.println("utente");
							utente.setLogin(true);
							session.setAttribute("utente", utente);
							getServletContext().getRequestDispatcher("/home.jsp").forward(request, response);
						}else {
							System.out.println("admin");
							admin.setLogin(true);
							System.out.println(admin.isLogin());
							session.setAttribute("admin", admin);
							getServletContext().getRequestDispatcher("/admin.jsp").forward(request, response);
						}	
						
						
					}

				
		}
  }
}
	
