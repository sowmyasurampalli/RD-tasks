package autoparkingusingdao.exceptions;

/**
 * thrown when parking slot is not vacant.
 * @author Sowmya_Surampalli
 *
 */
public class ParkingSlotEmptyException extends Exception{
	public String toString() {
		return "ParkingSlot full";
	}
}
