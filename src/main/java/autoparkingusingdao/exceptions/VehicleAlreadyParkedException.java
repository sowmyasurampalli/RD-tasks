package autoparkingusingdao.exceptions;

public class VehicleAlreadyParkedException extends Exception{
public String toString() {
	return "Vehicle already parked in the parking slot";
}
}
