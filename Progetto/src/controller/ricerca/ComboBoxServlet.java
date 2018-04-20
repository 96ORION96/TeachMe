package controller.ricerca;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classiDao.ProdottoDao;

/**
 * Servlet implementation class ComboBoxServlet
 */
@WebServlet("/ComboBoxServlet")
public class ComboBoxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ComboBoxServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<String> list1= new ArrayList<>();
		ArrayList<String> list2= new ArrayList<>();
		ArrayList<String> list3= new ArrayList<>();
		
		try {
			list1= ProdottoDao.getCorsi();
			list2= ProdottoDao.getFacolta();
			list3= ProdottoDao.getUniversita();
			request.setAttribute("corsi", list1);
			request.setAttribute("facolta", list2);
			request.setAttribute("universita", list3);
			getServletContext().getRequestDispatcher("/ricerca.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			response.getWriter().println(e.getMessage());
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
