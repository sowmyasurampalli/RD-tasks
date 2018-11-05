package autoparkingusingdao.exceptions;

/**
 * thrown when vehicle is not available in the parking slot.
 * @author Sowmya_Surampalli
 *
 */
public class VehicleNotFoundException extends Exception {
	public String toString() {
		return "vehicle not found in parking slot";
	}
}
