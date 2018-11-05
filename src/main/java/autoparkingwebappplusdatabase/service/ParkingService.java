package autoparkingwebappplusdatabase.service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Iterator;

import autoparkingusingdao.exceptions.InvalidVehicleIdException;
import autoparkingusingdao.exceptions.ParkingSlotEmptyException;
import autoparkingwebappplusdatabase.bean.ParkingMap;
import autoparkingwebappplusdatabase.dao.DAO;
import autoparkingwebappplusdatabase.dao.FileDAO;

/**
 * Contains methods for parking.
 * 
 * @author Sowmya Surampalli
 *
 */
public class ParkingService {
	
	/**
	 * parking the vehicle in the parking slot.
	 * @throws ParkingSlotEmptyException when parkingMap is full
	 * @throws InvalidVehicleIdException when vehicle id doesn't match the regular
	 * expression as defined.
	 */
	public int parkVehicle(String vehicle, DAO dao) throws ParkingSlotEmptyException, InvalidVehicleIdException {
		System.out.println("parkingService");
		boolean isVehicleValid = validateVehicleId(vehicle);
		int emptySlot = searchForEmptySlot();
		if(emptySlot == -1) {
			System.out.println("parking slot full");
			throw new ParkingSlotEmptyException();
		} else if(!isVehicleValid) {
			System.out.println("vehicle id invalid");
			throw new InvalidVehicleIdException();
		} else {
			ParkingMap.getParkingMap().parkingMap.put(emptySlot, vehicle);
			dao.writeTransaction(emptySlot, vehicle, "parking");
			LocalDateTime inTime = LocalDateTime.now();
			dao.writeEntryLog(emptySlot, vehicle, inTime);
		}
		System.out.println(emptySlot);
		return emptySlot;
	}

	/**
	 * searches for empty slot in the parkingMap.
	 * @return -1 on unsuccessful emptyslot search.
	 */
	private int searchForEmptySlot() {
		int emptySlot = -1;
		Iterator<Integer> it = ParkingMap.getParkingMap().parkingMap.keySet().iterator();
		while(it.hasNext()) {
			int slot = it.next();
			if(ParkingMap.getParkingMap().parkingMap.get(slot).equals("")) {
				System.out.println("in");
				emptySlot = slot;
				break;
			} 
		}
		System.out.println(ParkingMap.getParkingMap().parkingMap);
		return emptySlot;
	}
	
	/**
	 * sees if the vehicle id has two letters +
	 * two numbers +
	 * two letters +
	 * four numbers.
	 * @param vehicleId vehicleId to be validated
	 * @return true if the vehicle id is valid.
	 * false in the else case.
	 */
	public boolean validateVehicleId(final String vehicleId) {
		String regex = "[A-Za-z]{2}[0-9]{2}[A-Za-z]{1,2}[0-9]{4}";
		return vehicleId.matches(regex);
	}
}
