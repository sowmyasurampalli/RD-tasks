package autoparkingwebappplusdatabase.service;

import java.time.LocalDateTime;
import java.util.Iterator;

import autoparkingwebappplusdatabase.bean.ParkingMap;
import autoparkingwebappplusdatabase.dao.DAO;

public class UnParkingService {
	public int unParkingService(String vehicle, DAO dao) {
		int vehicleSlot = searchForVehicle(vehicle);
		if(vehicleSlot == -1) {
			//exception to be raised
		} else {
			ParkingMap.getParkingMap().parkingMap.put(vehicleSlot, "");
			dao.writeTransaction(vehicleSlot,vehicle,"unparking");
			LocalDateTime outTime = LocalDateTime.now();
			dao.writeExitLog(vehicleSlot, vehicle, outTime);
		}
		return vehicleSlot;
	}

	private int searchForVehicle(String vehicle) {
		int vehicleSlot = -1;
		Iterator<Integer> it = ParkingMap.getParkingMap().parkingMap.keySet().iterator();
		while(it.hasNext()) {
			int slot = it.next();
			if(ParkingMap.getParkingMap().parkingMap.get(slot).equals(vehicle)) {
				vehicleSlot = slot;
				break;
			}
		}
		return vehicleSlot;
	}
}
