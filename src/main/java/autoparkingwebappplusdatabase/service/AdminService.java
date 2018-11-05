package autoparkingwebappplusdatabase.service;

public class AdminService {
	
/**
 * Validates AdminID and Password.
 * @param adminId adminId entered by user.
 * @param password password entered by user.
 * @return
 */
public boolean adminLogin(String adminId, String password) {
	boolean isAdminValid = false;
	if(adminId.equals("hello") && password.equals("world")) {
		isAdminValid = true;
	} else {
		isAdminValid = false;
	}
	return isAdminValid;
}
}
