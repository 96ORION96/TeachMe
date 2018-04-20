package controller.visualizzazzione;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.AppuntiBeans;
import beans.LezioneBeans;
import beans.LibroBeans;

/**
 * Servlet implementation class CercaProdottiFacolta
 */
@WebServlet("/CercaProdottiFacolta")
public class CercaProdottiFacolta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CercaProdottiFacolta() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
				String facolta =(String) request.getParameter("val");
				ArrayList<LibroBeans> libri;
				ArrayList<AppuntiBeans>appunti;
				ArrayList<LezioneBeans>lezioni;
				
			
				appunti = classiDao.AppuntiDao.Select_appunti_facolta(facolta);
				libri   = classiDao.LibroDao.Select_libro_facolta(facolta);
				lezioni = classiDao.LezioneDao.Select_lezione_facolta(facolta);
				
				request.setAttribute("appunti", appunti);
				request.setAttribute("libri", libri);
				request.setAttribute("lezioni", lezioni);
				
				getServletContext().getRequestDispatcher("/visProdAlt.jsp").forward(request, response);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
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
