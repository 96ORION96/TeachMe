package controller.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.AdminBeans;
import beans.UtenteBeans;
import classiDao.*;

/**
 * Servlet implementation class RimuoviUtente
 */
@WebServlet("/RimuoviUtente")
public class RimuoviUtente extends HttpServlet {
	private static final long serialVersionUID = 1L;
      private AdminBeans admin;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RimuoviUtente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		HttpSession session = request.getSession();
		admin = (AdminBeans) session.getAttribute("admin");
		
		if(admin != null) {
						try {
							System.out.println("RimuoviUtente");
							
							String email = request.getParameter("email");
							System.out.println(email);
							classiDao.AdminDao.Delete_Utente(email);
							
							classiDao.LezioneDao.Delete_lezione_mail(email);
							classiDao.AppuntiDao.Delete_appunti_email(email);
							classiDao.LibroDao.Delete_libro_email(email);
							
							getServletContext().getRequestDispatcher("/admin.jsp").forward(request, response);

							
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
