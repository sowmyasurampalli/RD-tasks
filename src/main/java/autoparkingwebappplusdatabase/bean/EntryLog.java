package autoparkingwebappplusdatabase.bean;

import java.time.LocalDateTime;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * can be persisted using Hibernate.
 * log bean for entry.
 * @author Sowmya_Surampalli
 *
 */
@Entity
public class EntryLog {



	private int logid;
	private int slot;
	private String vehicle;
	private LocalDateTime inTime;
	
	/**
	 * log id. primary key.
	 * auto incremented.
	 * @return log id.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getLogid() {
		return logid;
	}

	/**
	 * auto incremented.
	 * @param logid log id.
	 */
	public void setLogid(int logid) {
		this.logid = logid;
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
	 * get in time of the vehicle.
	 * @return inTime.
	 */
	public LocalDateTime getInTime() {
		return inTime;
	}
	
	/**
	 * set in time of the vehicle.
	 * @param inTime in time of the vehicle.
	 */
	public void setInTime(LocalDateTime inTime) {
		this.inTime = inTime;
	}
	
	
}
