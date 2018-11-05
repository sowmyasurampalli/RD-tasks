package autoparkingwebappplusdatabase.bean;

import java.util.HashMap;

/**
 * Singleton class of ParkingMap
 * @author Sowmya Surampalli
 *
 */
public class ParkingMap {
	static ParkingMap parking = new ParkingMap();
	/**
	 * Intensionally making the default constructor numb.
	 * No new operator is allowed to generate
	 * new object of the ParkingMap.
	 */
	ParkingMap(){
		
	}
	/**
	 * static HashMap of parkingMap
	 */
	public static HashMap<Integer,String> parkingMap = new HashMap<Integer, String>();
	
	/**
	 * returns one and only one object
	 * of ParkingMap forever.
	 * @return ParkingMap
	 */
	public static ParkingMap getParkingMap(){
		return parking;
	}
}
