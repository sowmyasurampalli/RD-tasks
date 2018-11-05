package autoparkingwebappplusdatabase.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "admintable")
public class AdminBean {

	private String adminId;
	private String password;
	private String type;
	
	
	/**
	 * get adminId.
	 * @return adminId
	 */
	@Id
	public String getAdminId() {
		return adminId;
	}
	
	/**
	 * set AdminId.
	 * @param adminId adminId
	 */
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	
	/**
	 * get password.
	 * @return password.
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * set password.
	 * @param password password.
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * get type of admin: parking/unparking/display.
	 * @return type of admin
	 */
	public String getType() {
		return type;
	}
	
	/**
	 * set type of admin: parking/unparking/display.
	 * @param type type of admin
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	
	
}
