import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Rookie
 *
 */
public class User extends UserCollection {
	protected static int idCounter=1;
	private int userID;
	private String name;
	private String userName;
	private String password;
	private Date dateOfBirth;
	private String graduatedSchool;
	private Date lastLogin;
	
	static List<User> friends = new ArrayList<User>();
	static List<User> blockedUsers = new ArrayList<User>();

	/**
	 * @param nameX nameX is the user name of User.We will get this value from commands.txt.
	 * Firstly method controls,does user exists or not then it control does user signed in or not?
	 * If these situations are provided,method does simply block a user with user name.
	 */
	public static void blockUser(String	nameX){
		int k = 0;
		if(Main.signedUser.size()==0){
			System.out.println("Error: Please sign in and try again."+"\n");
		}
		for(User o : UserCollection.users){	
			if(o.getUserName().equals(nameX)){
				k+=1;
				User.blockedUsers.add(o);
				System.out.println(nameX+" has been successfully blocked.");
			}
		}
		if(k==0){
			System.out.println("No such user!");
		}
	}
	
	/**
	 * @param valueX valueX is the user name of User.We will get this value from commands.txt.
	 * Firstly method controls,does user exists or not then it control does user signed in or not?
	 * Lastly it checks user is blocked or not?If these situations are provided,method does simply unblock a user with user name.
	 */
	public static void unblockUser(String valueX){
		List<User> toRemove = new ArrayList<User>();
		int k=0;
		if(Main.signedUser.size()==0){
			System.out.println("Error: Please sign in and try again."+"\n");
		}	
		for(User blocked : User.blockedUsers){
			if(blocked.getUserName().equals(valueX)){
				k+=1;
				toRemove.add(blocked);
				System.out.println(valueX+" has been successfully unblocked.");
			}
		}
		for (User userlar : toRemove) {
		    User.blockedUsers.remove(userlar);
		}
		if(k==0){
			System.out.println("No such user!");
		}

	}
	
	/**
	 * @param values values is the user name of User.We will get this value from commands.txt.
	 * Firstly method controls,does user exists or not then it control does user signed in or not?
	 * Lastly if the user has not already existed in friends,and the other situations are provided,Method does add users to the friends with user name.
	 */
	public static void addFriends(String values){
		int k=0;
		if(Main.signedUser.size()==0){
			System.out.println("Error: Please sign in and try again."+"\n");
		}
		for(User o : UserCollection.users){	
			if(o.getUserName().equals(values)){
				k+=1;
				if(User.friends.contains(o)){
					System.out.println("This user is already in your friend list!");
				}
				else{
					User.friends.add(o);
					System.out.println(o.getName()+" has been successfully added to your friend list.");
				}	
			}
		}
		if(k==0){
			System.out.println("No such user!");
		}
	}
	
	/**
	 * @param namea namea is the user name of User.We will get this value from commands.txt.
	 * We will get this value from commands.txt.Firstly method controls,does user exists or not then it control does user signed in or not?
	 * Lastly if the situations are provided,Method does remove users to the friends with user name.
	 */
	public static void removeFriends(String namea){
		List<User> toRemove = new ArrayList<User>();
		int k=0;
		if(Main.signedUser.size()==0){
			System.out.println("Error: Please sign in and try again."+"\n");
		}
		
		for(User o : User.friends){
			if(o.getUserName().equals(namea)){
				k+=1;
				toRemove.add(o);
				System.out.println(namea+" has been successfully removed to your friend list.");
			}
			if(!User.friends.contains(o)){
				System.out.println("No such friend!");
			}
		}
		for (User userlar : toRemove) {
		    User.friends.remove(userlar);
		}
		if(k==0){
			System.out.println("No such user!");
		}
		
	}
	
	
	public String toString() {
		return ("Name: "+ name + "\n"+
				"Username: "+ userName + "\n"+
				"Date of Birth: "+ dateOfBirth + "\n"+
				"School: "+ graduatedSchool);
				
				
				
	}
	List<Post> posts = new ArrayList<Post>();
	
	/**
	 * @param name Name of the Users.We will get name value by the help of addUser method.
	 * @param userName User name of the Users.We will get user name value by the help of addUser method.
	 * @param password Password of the Users.We will get user name value by the help of addUser method.
	 * @param dateOfBirth Birth date of the Users.We will get user name value by the help of addUser method.Also,in this constructor we get a String value of birth date,but we will convert it to the Date type. 
	 * @param graduatedSchool Graduated school of the Users.We will get user name value by the help of addUser method.
	 */
	public User(String name, String userName, String password, String dateOfBirth, String graduatedSchool) {
		this.setUserID(idCounter++);
		this.name = name;
		this.userName = userName;
		this.password = password;
		this.graduatedSchool = graduatedSchool;
		Date dtReturn = null;
	    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
	    try {
	        dtReturn = simpleDateFormat.parse(dateOfBirth);
	    } catch (ParseException e) {
	        e.printStackTrace();
	    }
	    this.dateOfBirth = dtReturn ;
	}
	
	/**
	 * @return The userID of the users.
	 */
	public int getUserID() {
		return userID;
		
	}
	/**
	 * @param userID Sets the new userID of users.
	 */
	public void setUserID(int userID) {
		this.userID = userID;
	}
	/**
	 * @return The name of users.
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name Sets the new name of users.
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return The user name of users.
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName Sets the new user name of users.
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return The password of users.
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password Sets the new password of users.
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return The birth date of users with date format.
	 */
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	/**
	 * @param dateOfBirth Sets the new value of Users' birth date.
	 */
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	/**
	 * @return The graduated school of users.
	 */
	public String getGraduatedSchool() {
		return graduatedSchool;
	}
	/**
	 * @param graduatedSchool Sets the new graduated school of users.
	 */
	public void setGraduatedSchool(String graduatedSchool) {
		this.graduatedSchool = graduatedSchool;
	}
	
	
	
	
}
