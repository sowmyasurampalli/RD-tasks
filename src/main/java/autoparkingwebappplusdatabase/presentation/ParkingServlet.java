package autoparkingwebappplusdatabase.presentation;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import autoparkingusingdao.exceptions.InvalidVehicleIdException;
import autoparkingusingdao.exceptions.ParkingSlotEmptyException;
import autoparkingwebappplusdatabase.bean.ParkingMap;
import autoparkingwebappplusdatabase.dao.DAO;
import autoparkingwebappplusdatabase.dao.DatabaseDAO;
import autoparkingwebappplusdatabase.dao.FileDAO;
import autoparkingwebappplusdatabase.service.AdminService;
import autoparkingwebappplusdatabase.service.ParkingService;
import autoparkingwebappplusdatabase.service.UnParkingService;

/**
 * Servlet implementation class ParkingServlet
 */
public class ParkingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ParkingServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * based on the choice of user in menu
	 * calls appropriate methods.
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("parkingServlet");
		PrintWriter out = response.getWriter();
		AdminService adminservice = new AdminService();
		DAO dao = new DatabaseDAO();
		
		int choice = Integer.parseInt(request.getParameter("menu"));
		String vehicle = request.getParameter("vehicle");
		String nameOfParkingArea = request.getParameter("parkingarea");
		dao.initializeParkingMap(nameOfParkingArea);

		switch (choice) {
		case 1:
			ParkingService parking = new ParkingService();
			try {
				System.out.println("ParkingService servlet");
				int slotNumber = parking.parkVehicle(vehicle, dao);
				
			} catch (ParkingSlotEmptyException e) {
				
			} catch (InvalidVehicleIdException e) {
				e.printStackTrace();
			}
			request.setAttribute("message", "Parked");
			break;
		case 2:
			UnParkingService unpark = new UnParkingService();
			int vehicleSlot = unpark.unParkingService(vehicle, dao);
			request.setAttribute("message", "unparked");
			break;
		}
		

	}


	/** in turn calls doGet().
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
