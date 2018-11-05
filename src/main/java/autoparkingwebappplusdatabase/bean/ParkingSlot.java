package autoparkingwebappplusdatabase.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * can be hibernated.
 * contains fields: slot number and vehicle
 * @author Sowmya_Surampalli
 *
 */

@Entity
public class ParkingSlot {

	@Id
	String vehicle;
	int slotNumber;
	String parkingarea;
	
	/**
	 * name of the parking area.
	 * eg. parking area of epam, synchrony, etc.	
	 * @return name of parking area
	 */
	public String getParkingarea() {
		return parkingarea;
	}
	
	/**
	 * set parking area.
	 * @param parkingarea name of the parking area.
	 */
	public void setParkingarea(String parkingarea) {
		this.parkingarea = parkingarea;
	}
	
	/**
	 * slot number that vehicle is parked in.
	 * @return slotnumber
	 */
	public int getSlotNumber() {
		return slotNumber;
	}
	
	/**
	 * set slotnumber of the slot where vehicle is parked.
	 * @param slotNumber slot number.
	 */
	public void setSlotNumber(int slotNumber) {
		this.slotNumber = slotNumber;
	}
	
	/**
	 * unique id of the vehicle.
	 * @return vehicleId.
	 */
	public String getVehicle() {
		return vehicle;
	}
	
	/**
	 * set id of the vehicle.
	 * @param vehicle vehicle id.
	 */
	public void setVehicle(String vehicle) {
		this.vehicle = vehicle;
	}
	
	
}
