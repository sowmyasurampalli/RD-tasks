package autoparkingwebappplusdatabase.dao;

import java.sql.Connection;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import autoparkingwebappplusdatabase.bean.AdminBean;
import autoparkingwebappplusdatabase.bean.EntryLog;
import autoparkingwebappplusdatabase.bean.ExitLog;
import autoparkingwebappplusdatabase.bean.ParkingMap;
import autoparkingwebappplusdatabase.bean.ParkingSlot;

public class DatabaseDAO implements DAO {
	
	/**
	 * name of the parking area;
	 */
	private static String parkingArea;
	
	/**
	 * initializes parking slot with values from database and empty values in the
	 * empty slots.
	 */
	public boolean initializeParkingMap(String nameOfParkingArea) {
		int defaultParkingSize = 30;
		for (int i = 0; i < defaultParkingSize; i++) {
			ParkingMap.getParkingMap().parkingMap.put(i, "");
		}
		this.parkingArea = nameOfParkingArea;
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("LogForEntry");
		EntityManager entityManager = factory.createEntityManager();
		entityManager.getTransaction().begin();
		String hql = "select ps from ParkingSlot ps where parkingarea = :nameOfParkingArea";
		Query query = entityManager.createQuery(hql);
		query.setParameter("nameOfParkingArea", nameOfParkingArea);
		List<ParkingSlot> list = query.getResultList();
		int slot = 0;
		String vehicle = "";
		for (int indexOnList = 0; indexOnList < list.size(); indexOnList++) {
			slot = list.get(indexOnList).getSlotNumber();
			vehicle = list.get(indexOnList).getVehicle();
			ParkingMap.getParkingMap().parkingMap.put(slot, vehicle);
		}
		return true;
	}


	/**
	 * writes into parkingmap table.
	 * 
	 * @param slotNumber slotNumber of the vehicle.
	 * @param vehicle vehicle number
	 * @param typeOfTransaction entry/exit
	 * 
	 */
	public void writeTransaction(int slotNumber, String vehicle, String typeOfTransaction) {
		String sql = "";
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("LogForEntry");
		EntityManager entityManager = factory.createEntityManager();
		entityManager.getTransaction().begin();
		if (typeOfTransaction.equals("parking")) {
			ParkingSlot slotObject = new ParkingSlot();
			slotObject.setSlotNumber(slotNumber);
			slotObject.setVehicle(vehicle);
			slotObject.setParkingarea(parkingArea);
			entityManager.persist(slotObject);
		} else {
			String hql = "DELETE FROM ParkingSlot " + "WHERE vehicle = :vehicle";
			Query query = entityManager.createQuery(hql);
			query.setParameter("vehicle", vehicle);
			int result = query.executeUpdate();
			System.out.println(result);
		}
		entityManager.getTransaction().commit();
		entityManager.close();
		factory.close();

	}

	/**
	 * Gets the type of admin: parking admin / unparking admin / display admin. and
	 * also validates the admin based on admin id and password of the user in the
	 * database.
	 * 
	 * @param adminId  admin id of the user
	 * @param password password of the user
	 * @return typeOfadmin on valid user and empty string on invalid user.
	 */
	public String getTypeOfAdmin(String adminId, String password) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("LogForEntry");
		EntityManager entityManager = factory.createEntityManager();
		entityManager.getTransaction().begin();
		String hql = "SELECT admin FROM AdminBean admin " + "WHERE adminId = :adminId and password = :password";
		Query query = entityManager.createQuery(hql);
		query.setParameter("adminId", adminId);
		query.setParameter("password", password);
		List<AdminBean> adminbeanList = query.getResultList();
		String typeOfAdmin = adminbeanList.get(0).getType();	//exception to be caught	
		return typeOfAdmin;
	}

	/**
	 * writes into log table.
	 * 
	 * @param slot    slot number of the vehicle
	 * @param vehicle vehicle Id
	 * @param inTime  in time of the vehicle
	 * @param outTime out time of the vehicle
	 */
	@Override
	public void writeEntryLog(int slot, String vehicle, LocalDateTime inTime) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("LogForEntry");
		EntityManager entityManager = factory.createEntityManager();
		entityManager.getTransaction().begin();
		EntryLog logbean = new EntryLog();
		logbean.setSlot(slot);
		logbean.setVehicle(vehicle);
		logbean.setInTime(inTime);
		entityManager.persist(logbean);
		entityManager.getTransaction().commit();
		entityManager.close();
		factory.close();
	}

	/**
	 * writes log records of exit.
	 */
	@Override
	public void writeExitLog(int slot, String vehicle, LocalDateTime outTime) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("LogForEntry");
		EntityManager entityManager = factory.createEntityManager();
		entityManager.getTransaction().begin();
		ExitLog logbean = new ExitLog();
		logbean.setSlot(slot);
		logbean.setVehicle(vehicle);
		logbean.setOutTime(outTime);
		entityManager.persist(logbean);
		entityManager.getTransaction().commit();
		entityManager.close();
		factory.close();

	}

}
