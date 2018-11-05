package autoparkingwebappplusdatabase.presentation;

import java.util.Scanner;

import autoparkingusingdao.exceptions.InvalidVehicleIdException;
import autoparkingusingdao.exceptions.ParkingSlotEmptyException;
import autoparkingwebappplusdatabase.bean.ParkingMap;
import autoparkingwebappplusdatabase.dao.DAO;
import autoparkingwebappplusdatabase.dao.FileDAO;
import autoparkingwebappplusdatabase.service.AdminService;
import autoparkingwebappplusdatabase.service.ParkingService;
import autoparkingwebappplusdatabase.service.UnParkingService;

/**
 * main class for basic console application
 * @author Sowmya_Surampalli
 *
 */
public class MainClass {

	/**
	 * calls display menu
	 * takes choice from user
	 * calls appropriate methods.
	 * @param args no arguments.
	 */
	public static void main(String[] args) {
		AdminService adminservice = new AdminService();
		Scanner readInput = new Scanner(System.in);
		DAO dao = new FileDAO();
		String nameOfParkingArea = "";

		System.out.println("ADMIN ID:");
		String adminId = readInput.next();
		System.out.println("PASSWORD:");
		String password = readInput.next();
		System.out.println("Enter name of parking area");
		nameOfParkingArea = readInput.next();
		dao.initializeParkingMap(nameOfParkingArea);
		boolean isAdminValid = false;
		isAdminValid = adminservice.adminLogin(adminId, password);
		while (isAdminValid) {
			int choice = getParkingMenuChoice();
			switch (choice) {
			case 1:
				System.out.println("Enter vehicle Id");
				String vehicle = readInput.next();
				ParkingService parking = new ParkingService();
				int slotNumber=-1;
				try {
					slotNumber = parking.parkVehicle(vehicle, dao);
				} catch (ParkingSlotEmptyException e) {
					System.out.println("PARKING SLOT FULL");
				} catch (InvalidVehicleIdException e) {
					System.out.println("PLEASE ENTER CORRECT VEHICLE ID");
				}
				System.out.println("Vehicle successfully parked in "+slotNumber);
				break;
			case 2:
				System.out.println("Enter vehicle Id");
				String vehicleToUnpark = readInput.next();
				UnParkingService unpark = new UnParkingService();
				int vehicleSlot = unpark.unParkingService(vehicleToUnpark, dao);
				System.out.println("Vehicle successfully unparked from "+vehicleSlot);
				break;
			case 3:
				System.out.println(ParkingMap.getParkingMap().toString());
				break;
			case 4:
				
			}
		}
		if (!isAdminValid) {
			// exception to be raised
		}
	}

	private static int getParkingMenuChoice() {
		System.out.println("Menu:");
		System.out.println("1. Park the vehicle");
		System.out.println("2. Unpark the vehicle");
		System.out.println("3. Display Parking Map");
		System.out.println("4. Display log");
		System.out.println("Enter your choice:");
		Scanner getInput = new Scanner(System.in);
		int choice = getInput.nextInt();
		return choice;

	}
}
