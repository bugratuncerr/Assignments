
/**
 * @author Rookie
 *
 */
public class Admin extends Employee {
	private String name;
	private String email;
	private String birthDate;
	private String salary;
	private String password;
	
	/**
	 * @param name Gets the value of users.txt's second elements and assign to Admin's name,whenever a new object of admin is created.
	 * @param email Gets the value of users.txt's third elements and assign to Admin's e-email,whenever a new object of admin is created.
	 * @param birthDate Gets the value of users.txt's fourth elements and assign to Admin's date of birth,whenever a new object of admin is created.
	 * @param salary Gets the value of users.txt's fifth elements and assign to Admin's salary,whenever a new object of admin is created.
	 * @param password Gets the value of users.txt's sixth elements and assign to Admin's password,whenever a new object of admin is created.
	 */
	public Admin(String name, String email, String birthDate, String salary, String password) {
		this.name = name;
		this.email = email;
		this.birthDate = birthDate;
		this.setSalary(salary);
		this.setPassword(password);
	}

	public String toString() {
		return "----------- Admin info -----------\n"+
				"Admin name: " + this.name+"\n"+
				"Admin e-mail: " + this.email+"\n"+
				"Admin date of birth:" + this.birthDate+"\n";
	}
	/**
	 * @return the value of an Admin's email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email gets the value of an Admin's email as parameter and sets the new email value
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the value of an Admin's date of birth
	 */
	public String getBirthDate() {
		return birthDate;
	}
	/**
	 * @param birthDate gets the value of an Admin's date of birth as parameter and and sets the new date of birth value
	 */
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	/**
	 * @return the value of an Admin's name
	 */
	public String getName(){
		return name;
	}
	/**
	 * @param name gets the value of an Admin's name as parameter and and sets the new name value
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the value of an Admin's salary
	 */
	public String getSalary() {
		return salary;
	}
	/**
	 * @param salary gets the value an Admin's of salary as parameter and sets the new salary value
	 */
	public void setSalary(String salary) {
		this.salary = salary;
	}
	/**
	 * @return the value of an Admin's password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password gets the value of an Admin's password and sets the new password value
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	
	
}
