import java.util.ArrayList;
import java.util.List;

/**
 * @author Rookie
 *
 */
public class UserCollection {
	
	static List<User> users = new ArrayList<User>();
	
	/**
	 * @param name name is the simply name of the Users,and assign to Users' name with this method.
	 * We got this value from users.txt's first element.
	 * @param userName username is the simply user name of the Users,and assign to Users' user name with this method.
	 * We got this value from users.txt's second element.
	 * @param password password is the simply password of the Users,and assign to Users' password with this method.
	 * We got this value from users.txt's third element.
	 * @param dateOfBirth date of Birth is the simply birth date of the Users,and assign to Users' birth date with this method.
	 * We got this value from users.txt's fourth element.
	 * @param graduatedSchool graduatedSchool is the simply graduated school of the Users,and assign to Users' graduated school with this method.
	 * We got this value from users.txt's fifth element.
	 */
	public static void addUser(String name,String userName,String password,String dateOfBirth,String graduatedSchool){
		users.add(new User(name,userName,password,dateOfBirth,graduatedSchool));
	}
	
	/**
	 * @param userID userID is the simply id of the Users.In this method,we delete the user if id exists.
	 */
	public static void removeUser(String userID){
		users.remove(UserCollection.users.get(Integer.parseInt(userID)-1));
	}
	
	/**
	 * @param userName In this method we will create a login system it will get the value of user name.And go through the password.
	 * @param password If user is exists,it will check the password,true or false.
	 */
	public static void userSignIn(String userName,String password){
		System.out.println("You have succesfully signed in.");
	}
		
	
}
