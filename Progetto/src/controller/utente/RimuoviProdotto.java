package controller.utente;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.api.Session;

import beans.UtenteBeans;

/**
 * Servlet implementation class RimuoviProdotto
 */
@WebServlet("/RimuoviProdotto")
public class RimuoviProdotto extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UtenteBeans utente; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RimuoviProdotto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		utente = (UtenteBeans) session.getAttribute("utente");
			if(utente!=null) {
					String id = request.getParameter("id");
					String tipo = request.getParameter("tipo");
						if(tipo.equals("libro")) {
							try {
								classiDao.LibroDao.Delete_libro(id);
								
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
							
						}else if(tipo.equals("appunti")) {
							try {
								classiDao.AppuntiDao.Delete_appunti(id);
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
							
						}else if(tipo.equals("lezioni")){
							try {
								classiDao.LezioneDao.Delete_lezione(id);
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
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
