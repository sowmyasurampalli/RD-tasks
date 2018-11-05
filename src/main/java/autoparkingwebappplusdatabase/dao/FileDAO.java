package autoparkingwebappplusdatabase.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

import autoparkingwebappplusdatabase.bean.ParkingMap;

/**
 * Contains methods for data dealing from files. implements DAO.
 * 
 * @author Sowmya Surampalli
 *
 */
public class FileDAO implements DAO {

	public final static int defaultParkingSlotSize = 30;
	/**
	 * initializes parkingMap HashMap from data in the file.
	 * 
	 * @return status of initialization.
	 */
	public boolean initializeParkingMap(String nameOfParkingArea) {
		boolean isParkingMapInitialized = false;
		for (int indexOnParkingMap = 0; indexOnParkingMap < defaultParkingSlotSize; indexOnParkingMap++) {
			ParkingMap.getParkingMap().parkingMap.put(indexOnParkingMap, "");
		}
		try {
			FileReader fileInput = new FileReader("src\\main\\resources\\transactions1.csv");
			Scanner fileScanner = new Scanner(fileInput);
			while (fileScanner.hasNext()) {
				String inputFromFile = fileScanner.nextLine();
				if (inputFromFile.equals("") || inputFromFile == null) {

				} else {
					String[] words = new String[2];
					words = inputFromFile.split(",");
					int slot = Integer.parseInt(words[0]);
					String vehicle = words[1].trim();
					ParkingMap.getParkingMap().parkingMap.put(slot, vehicle);
				}

			}
			isParkingMapInitialized = true;
		} catch (FileNotFoundException e) {

		}
		return isParkingMapInitialized;
	}

	/**
	 * writes into transaction file.
	 */
	public void writeTransaction(int slotNumber, String Vehicle, String typeOftransaction) {
		Iterator<Integer> it = ParkingMap.getParkingMap().parkingMap.keySet().iterator();
		try {
			FileWriter fileOut = new FileWriter("src\\main\\resources\\transactions1.csv");
			while (it.hasNext()) {
				int slot = it.next();
				String vehicle = ParkingMap.getParkingMap().parkingMap.get(slot);
				if (!vehicle.equals("")) {
					fileOut.append(slot+","+vehicle+"\n");
				}
			}
			fileOut.close();
		} catch (IOException e) {

		}

	}
	
	/**
	 * writes into log file.
	 */
	public void writeLog() {
		
	}

	/**
	 * gets type of admin.
	 * functionality not introduced at the time of files.
	 */
	public String getTypeOfAdmin(String adminId, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * writes into log file.
	 */
	@Override
	public void writeEntryLog(int slot, String vehicle, LocalDateTime inTime) {
		try {
			FileWriter fout = new FileWriter("src\\main\\resources\\Entrylog.csv",true);
			fout.write(slot+","+vehicle+","+inTime.toString());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * writes exit log.
	 */
	@Override
	public void writeExitLog(int slot, String vehicle, LocalDateTime outTime) {
		try {
			FileWriter fout = new FileWriter("src\\main\\resources\\Entrylog.csv",true);
			fout.write(slot+","+vehicle+","+outTime.toString());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
