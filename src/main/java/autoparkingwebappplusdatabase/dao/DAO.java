package autoparkingwebappplusdatabase.dao;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * DAO interface contains methods for interaction with
 * persistance.
 * @author Sowmya_Surampalli
 *
 */
public interface DAO {
/**
 * initializes parking map from the persistence.
 * file or database.
 * @return initialization status: true on successful initialization
 * and false on unsuccessful one.
 */
boolean initializeParkingMap(String nameOfparkingArea);

/**
 * writes the data into parking map.
 * @param slotNumber slot number of the vehicle
 * @param Vehicle vehicle Id
 * @param typeOftransaction entry transaction / exit transaction.
 */
void writeTransaction(int slotNumber, String Vehicle, String typeOftransaction);

/**
 * writes into log table or file.
 * @param slot slot number of the vehicle.
 * @param vehicle vehicle id
 * @param inTime inTime of the vehicle
 * 
 */
void writeEntryLog(int slot, String vehicle, LocalDateTime inTime);

/**
 * gets the type of admin: parking admin / unparking admin / display admin.
 * @param adminId id of the admin.
 * @param password password of the admin.
 * @return type of admin.
 */
String getTypeOfAdmin(String adminId, String password);

/**
 * writes exit logs at the time of unparking.
 * @param slot slot number of the vehicle.
 * @param vehicle vehicle id.
 * @param outTime outtime of the vehicle.
 */
void writeExitLog(int slot, String vehicle, LocalDateTime outTime);
}
