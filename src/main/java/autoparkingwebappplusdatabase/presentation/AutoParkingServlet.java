package autoparkingwebappplusdatabase.presentation;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import autoparkingwebappplusdatabase.dao.DAO;
import autoparkingwebappplusdatabase.dao.DatabaseDAO;
import autoparkingwebappplusdatabase.dao.FileDAO;
import autoparkingwebappplusdatabase.service.AdminService;

/**
 * Servlet implementation class AutoParkingServlet
 */
public class AutoParkingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AutoParkingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * initializes parking map.
	 * validates admin and redirects to appropriate page.
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AdminService adminservice = new AdminService();
		DAO dao = new DatabaseDAO();
		
		String adminId= request.getParameter("adminId");
		String password = request.getParameter("password");
		String typeOfAdmin = "";
		typeOfAdmin = dao.getTypeOfAdmin(adminId, password);
		if(!typeOfAdmin.equals("")) {
			request.setAttribute("typeOfadmin", typeOfAdmin);
			//response.sendRedirect("menu.jsp");
			request.getRequestDispatcher("menu.jsp").forward(request, response);
		} else {
			request.setAttribute("message","INVALID LOGIN");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

	/**in turn calls doGet method.
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
