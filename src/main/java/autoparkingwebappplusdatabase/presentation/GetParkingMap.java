package autoparkingwebappplusdatabase.presentation;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import autoparkingwebappplusdatabase.bean.ParkingMap;

/**
 * Servlet implementation class GetParkingMap
 */

public class GetParkingMap extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetParkingMap() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**reads the data from hashmap and posts on a servlet.
	 * Jsp reads this data to dynamically display upon diaplay call.
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		JsonArray parkingArea = new JsonArray();
		Iterator<Integer> it = ParkingMap.getParkingMap().parkingMap.keySet().iterator();
		while(it.hasNext()) {
			JsonObject jsonobject = new JsonObject();
			int slotNumber = it.next();
			String vehicle = ParkingMap.getParkingMap().parkingMap.get(slotNumber);
			if(vehicle.equals("")) {
				break;
			}
			jsonobject.addProperty("slotNumber", slotNumber);
			jsonobject.addProperty("vehicle",vehicle );
			parkingArea.add(jsonobject);
		}
		response.setContentType("application/json");
		out.println(parkingArea.toString());
		
	}

	/** inturn calls doGet();
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
