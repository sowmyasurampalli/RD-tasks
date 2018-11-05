package autoparkingwebappplusdatabase.bean;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * bean class for exit log.
 * @author Sowmya_Surampalli
 *
 */
@Entity
public class ExitLog {

	private int exitlogid;
	private int slot;
	private String vehicle;
	private LocalDateTime outTime;

	/**
	 * get exit log id
	 * auto incremented.
	 * @return exitlogId
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getExitlogid() {
		return exitlogid;
	}

	/**
	 * set exitlogId.
	 * @param exitlogid exitlogId
	 */
	public void setExitlogid(int exitlogid) {
		this.exitlogid = exitlogid;
	}

	/**
	 * get slot number.
	 * @return slot number.
	 */
	public int getSlot() {
		return slot;
	}
	
	/**
	 * set slot number.
	 * @param slot slot number.
	 */
	public void setSlot(int slot) {
		this.slot = slot;
	}
	
	/**
	 * get vehicle number.
	 * @return vehicle id
	 */
	public String getVehicle() {
		return vehicle;
	}
	
	/**
	 * set vehicle number.
	 * @param vehicle vehicle id
	 */
	public void setVehicle(String vehicle) {
		this.vehicle = vehicle;
	}
	
	/**
	 * get out time of the vehicle.
	 * @return outTime.
	 */
	public LocalDateTime getOutTime() {
		return outTime;
	}
	
	/**
	 * set out time of the vehicle.
	 * @param outTime in time of the vehicle.
	 */
	public void setOutTime(LocalDateTime inTime) {
		this.outTime = inTime;
	}
	
}
