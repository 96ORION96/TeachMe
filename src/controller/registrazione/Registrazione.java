package controller.registrazione;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.UtenteBeans;

/**
 * Servlet implementation class Registrazione
 */
@WebServlet("/Registrazione")
public class Registrazione extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String emailRegex = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@studenti.unisa.it$";
	private static final String pswRegex = "^[a-zA-Z0-9\\.-_]{1,10}$";
	private static final String matRegex = "^[0-9]{4}$";
	private static final String nomeRegex = "^[a-zA-Z]{1,20}$";
	private static final String cognomeRegex = "^[a-zA-Z\\S]{1,20}$";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registrazione() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		String psw = request.getParameter("psw");
		String psw_conf = request.getParameter("pswConf");
		int matr = 0;
		if(!request.getParameter("matricola").equals("")) 
			matr =Integer.parseInt(request.getParameter("matricola"));
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String fac = request.getParameter("facolta");
		String uni = request.getParameter("uni");
		String mail = request.getParameter("mail");
		String city = request.getParameter("citta");
		
	
		if(fac!=null || uni!=null || city!=null || (Pattern.matches(nomeRegex, nome)) || (Pattern.matches(cognomeRegex, cognome)) || (Pattern.matches(emailRegex, mail))
				|| (Pattern.matches(pswRegex, psw))) {
			
		UtenteBeans utentebeans = new UtenteBeans(psw, matr, nome, cognome, fac, uni, mail, city);
			if(psw.equals(psw_conf)){
				try {
					classiDao.UtenteDao.Insert(utentebeans);
					getServletContext().getRequestDispatcher("/home.jsp").forward(request, response);
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println("errore insert");
				}
			}
		
	}else {
		request.setAttribute("errorReg", "si");
		getServletContext().getRequestDispatcher("/registrazione.jsp").forward(request, response);
		
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

