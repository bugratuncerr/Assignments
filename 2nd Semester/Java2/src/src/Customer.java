
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Rookie
 *
 */
public class Customer extends Person {
	protected static int idCounter=1;
	private double balance;
	private String password;
	private int customerID;

	/**
	 * @return the value of a Customer's balance
	 */
	public double getBalance() {
		return balance;
	}
	/**
	 * @param balance gets the old balance and sets the new value of it using setter
	 */
	public void setBalance(double balance) {
		this.balance = balance;
	}
	/**
	 * @return the value of a Customer's password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password gets the old password and sets the new value of it using setter
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * @param customerID gets the old CustomerId and sets the new value of it using setter
	 */
	public void setCustomerID(int customerID){
		this.customerID = customerID;
	}
	
	/**
	 * @return the value of a Customer's id
	 */
	public int getCustomerID(){
		return this.customerID;
	}
	
	/**
	 * @param name is the simply name of the Customers,and assign to Customer's name whenever a new object of customer is created.We got this value from users.txt's second element.
	 * @param email is the simply e-mail of the Customers,and assign to Customer's e-mail whenever a new object of customer is created.We got this value from users.txt's third element.
	 * @param birthDate is the simply date of birth of the Customers,and assign to Customer's date of birth whenever a new object of customer is created.We got this value from users.txt's fourth element.
	 * This will also convert a string value of birth date to Date type.
	 * @param balance is the simply balance of money of the Customers,and assign to Customer's balance whenever a new object of customer is created.We got this value from users.txt's fifth element.
	 * @param password is the simply password of the Customers,and assign to Customer's password whenever a new object of customer is created.We got this value from users.txt's sixth element.
	 */
	public Customer(String name, String email, String birthDate, String balance, String password) {
		this.setCustomerID(idCounter++);
		this.name = name;
		this.email = email;
		this.setBalance(Double.parseDouble(balance));
		this.setPassword(password);
		
		Date dtReturn = null;
	    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
	    try {
	        dtReturn = simpleDateFormat.parse(birthDate);
	    } catch (ParseException e) {
	        e.printStackTrace();
	    }
	    this.birthDate = dtReturn ;
	}

	



	
	
	
	public String toString() {
		return ("Customer name: "+this.name+"	ID: " + customerID+ "	e-mail: " + this.email + "	Date of Birth: " + (this.birthDate) +"	Status:	"+"CLASSIC\n");
	}



	


	
}
