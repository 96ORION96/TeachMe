package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Beans.UtenteBeans;

/**
 * Servlet implementation class Registrazione
 */
@WebServlet("/Registrazione")
public class Registrazione extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
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
		String user = request.getParameter("user");
		String psw = request.getParameter("psw");
		String psw_conf = request.getParameter("psw_conf");
		int matr =Integer.parseInt(request.getParameter("matricola"));
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String fac = request.getParameter("facolta");
		String uni = request.getParameter("uni");
		String mail = request.getParameter("mail");
		String adress = request.getParameter("adress");
		String city = request.getParameter("city");
		int cap = Integer.parseInt(request.getParameter("cap"));
		UtenteBeans utentebeans = new UtenteBeans(user, psw, matr,nome, cognome, fac, uni, mail,adress, city, cap);
			if(psw.equals(psw_conf)){
				try {
					ClassiDao.UtenteDao.Insert(utentebeans);
					out.println("<HTML>");
					 out.println("<HEAD>");
					 out.println("<TITLE>Registazione completata</TITLE>");
					 out.println("</HEAD>");
					 out.println("<BODY>");
					 out.println("<H3 align='center'>Complimenti " + nome + "</H3>");
					 out.println("<h4>la tua registrazione è avvenuta con successo<h4>");
					 out.println("</BODY>");
					 out.println("</HTML>");
					 out.close();
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println("errore insert");
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
