
/**
 * @author Rookie
 *
 */
public class Technician extends Employee {
	private String name;
	private String email;
	private String birthDate;
	private String salary;
	private String seniorOrNot;
	/**
	 * @param name Gets the value of users.txt's second elements and assign to Technician's name,whenever a new object of technician is created.
	 * @param email Gets the value of users.txt's third elements and assign to Techinican's e-email,whenever a new object of technician is created.
	 * @param birthDate Gets the value of users.txt's fourth elements and assign to Techinican's date of birth,whenever a new object of technician is created.
	 * @param salary Gets the value of users.txt's fifth elements and assign to Techinican's salary,whenever a new object of technician is created.
	 * @param seniorOrNot Gets the value of users.txt's sixth elements and assign to Techinican's senior or not situation,whenever a new object of technician is created.
	 * This will also determine Technician is senior or not.
	 */
	public Technician(String name, String email, String birthDate, String salary, String seniorOrNot) {
		this.name = name;
		this.email = email;
		this.birthDate = birthDate;
		this.setSalary(salary);
		this.seniorOrNot=seniorOrNot;
	}
	/**
	 * @return the value of a Technician's name.
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name gets the value of a Technician's name as parameter and sets the new name value.
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the value of a Technician's e-mail.
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email gets the value of an Technician's e-mail as parameter and sets the new e-mail value
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the value of a Technician's date of birth.
	 */
	public String getBirthDate() {
		return birthDate;
	}
	/**
	 * @param birthDate gets the value of an Technician's date of birth as parameter and sets the new date value
	 */
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	
	/**
	 * @return the value of a Technician's salary
	 */
	public String getSalary() {
		return salary;
	}
	/**
	 * @param salary gets the value of an Technician's salary as parameter and sets the new salary value
	 */
	public void setSalary(String salary) {
		this.salary = salary;
	}
	
	
	
}
