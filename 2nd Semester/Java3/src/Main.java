import java.io.*;
import java.util.*;


/**
 * @author Rookie
 *
 */
public class Main {
	
	
	static List<User> signedUser = new ArrayList<User>();
	/**
	 * @param args String arguments.
	 * @throws FileNotFoundException Throw an exception.
	 */
	public static void main(String[] args) throws FileNotFoundException {
		List<String> commands = new ArrayList<String>();
		Scanner file = new Scanner(new File(args[0]));
		List<String> userString = new ArrayList<String>();
		while(file.hasNextLine()){
			String line = file.nextLine();
			userString.add(line);
		}
		file.close();
		String userThings[];
		for(int i=0 ; i<userString.size(); i++){
			userThings = userString.get(i).split("\t");
			UserCollection.addUser(userThings[0],userThings[1],userThings[2],userThings[3],userThings[4]);
		}
		
		Scanner filex = new Scanner(new File(args[1]));
		while(filex.hasNextLine()){
			String linex = filex.nextLine();
			commands.add(linex);
		}	
		filex.close();
		String commandsThings[];
		String commandLine;
		for(int i=0;i<commands.size();i++){
			
			commandLine = commands.get(i);
			commandsThings =  commands.get(i).split("\t");
			if(commandsThings[0].equals("ADDUSER")){
				System.out.println("\n-----------------------\n"+"\n"+ "COMMAND TEXT:"+commandLine+"\n");
				System.out.println(commandsThings[0]+" has been succesfully added.");
				UserCollection.addUser(commandsThings[1], commandsThings[2], commandsThings[3],commandsThings[4],commandsThings[5]);
				
			}
			else if(commandsThings[0].equals("REMOVEUSER")){
				System.out.println("\n-----------------------\n"+"\n"+ "COMMAND TEXT:"+commandLine+"\n");
				try{
					if(UserCollection.users.contains(UserCollection.users.get(Integer.parseInt(commandsThings[1])-1))){
						UserCollection.removeUser(commandsThings[1]);
						System.out.println("User has been successfully removed.");
				}}
				catch(IndexOutOfBoundsException ex){
					System.out.println("No such user!");
				}
				
				
			}
			
			else if(commandsThings[0].equals("SHOWPOSTS")){
				int k=0;
				System.out.println("\n-----------------------\n"+"\n"+ "COMMAND TEXT:"+commandLine+"\n");
				for(User o : UserCollection.users){
					if(o.getUserName().equals(commandsThings[1])){
						k+=1;
					}
					}
				if(k==0){
					System.out.println("No such user!");
				}
			}

			else if(commandsThings[0].equals("SIGNIN")){
				int k=0;
				System.out.println("\n-----------------------\n"+"\n"+ "COMMAND TEXT:"+commandLine+"\n");
				for(User o : UserCollection.users){	
						if(o.getUserName().equals(commandsThings[1])){
							if(o.getPassword().equals(commandsThings[2])){
								UserCollection.userSignIn(commandsThings[1], commandsThings[2]);
								signedUser.add(o);
							}
							else if(! o.getPassword().equals(commandsThings[2])){
								System.out.println("Invalid username or password! Please try again.");
							}
						}
						if(o.getUserName().equals(commandsThings[1])){
							k+=1;
						}
					}
				if(k==0){
					System.out.println("No such user!");
				}
				}
			
			else if(commandsThings[0].equals("SIGNOUT")){
				System.out.println("\n-----------------------\n"+"\n"+ "COMMAND TEXT:"+commandLine+"\n");
				signedUser.remove(0);
				System.out.println("You have succesfully signed out");
				
			}
			
			else if(commandsThings[0].equals("UPDATEPROFILE")){
				System.out.println("\n-----------------------\n"+"\n"+ "COMMAND TEXT:"+commandLine+"\n");
				for(User o : UserCollection.users){	
					if(o.getName().equals(commandsThings[1])){
						if(signedUser.get(0).getName().equals(commandsThings[1])){
							o.setGraduatedSchool(commandsThings[3]);
							System.out.println("Your user profile has been succesfully updated.");
						}
						else{
							System.out.println("Error : Please sign in and try again."+"\n");
						}
					}
				}
			}
			
			else if(commandsThings[0].equals("CHPASS")){
				System.out.println("\n-----------------------\n"+"\n"+ "COMMAND TEXT:"+commandLine+"\n");
				if(!signedUser.get(0).getPassword().equals(commandsThings[1])){
					System.out.println("Password mismatch! Please, try again.");
				}
				for(User o : UserCollection.users){	
					if(o.getPassword().equals(commandsThings[1])){
						if(signedUser.get(0).getPassword().equals(commandsThings[1])){
							o.setPassword(commandsThings[2]);
						}
						else{
							System.out.println("Error : Please sign in and try again.");
						}
					}
				}
			}
			
			else if(commandsThings[0].equals("ADDFRIEND")){
				System.out.println("\n-----------------------\n"+"\n"+ "COMMAND TEXT:"+commandLine+"\n");
				User.addFriends(commandsThings[1]);
		}
		
			else if(commandsThings[0].equals("REMOVEFRIEND")){
				System.out.println("\n-----------------------\n"+"\n"+ "COMMAND TEXT:"+commandLine+"\n");
				User.removeFriends(commandsThings[1]);
			}
			
			else if(commandsThings[0].equals("BLOCK")){
				System.out.println("\n-----------------------\n"+"\n"+ "COMMAND TEXT:"+commandLine+"\n");
				User.blockUser(commandsThings[1]);
			}
			
			else if(commandsThings[0].equals("UNBLOCK")){
				System.out.println("\n-----------------------\n"+"\n"+ "COMMAND TEXT:"+commandLine+"\n");
				User.unblockUser(commandsThings[1]);
			}
			
			else if(commandsThings[0].equals("LISTFRIENDS")){
				System.out.println("\n-----------------------\n"+"\n"+ "COMMAND TEXT:"+commandLine+"\n");
				if(signedUser.size()==0){
					System.out.println("Error: Please sign in and try again."+"\n");
				}
				if(User.friends.size()==0){
					System.out.println("You  haven't added any friends yet!");
				}
				for(User friend : User.friends){
					System.out.println(friend.toString()+"\n------------------------\n");
				}
			}
			
			else if(commandsThings[0].equals("LISTUSERS")){
				System.out.println("\n-----------------------\n"+"\n"+ "COMMAND TEXT:"+commandLine+"\n");
				if(signedUser.size()==0){
					System.out.println("Error: Please sign in and try again."+"\n");
				}
				for(User users : User.users){
					System.out.println(users.toString()+"\n-------------------------");
				}
			}
			
			else if(commandsThings[0].equals("SHOWBLOCKEDFRIENDS")){
				System.out.println("\n-----------------------\n"+"\n"+ "COMMAND TEXT:"+commandLine+"\n");
				if(signedUser.size()==0){
					System.out.println("Error: Please sign in and try again."+"\n");
				}
				if(User.blockedUsers.size()==0){
					System.out.println("You haven't blocked any users yet!"+"\n");
				}
				for(User blocked : User.friends){
					if(User.blockedUsers.contains(blocked)){
						System.out.println(blocked.toString()+"\n----------------------");
					}
				}
				if(!User.friends.containsAll(User.blockedUsers)){
					System.out.println("You haven't blocked any friends yet"+"\n");
				}
			}
			
			else if(commandsThings[0].equals("SHOWBLOCKEDUSERS")){
				System.out.println("\n-----------------------\n"+"\n"+ "COMMAND TEXT:"+commandLine+"\n");
				if(signedUser.size()==0){
					System.out.println("Error: Please sign in and try again."+"\n");
				}
				if(User.blockedUsers.size()==0){
					System.out.println("You haven't blocked any users yet!"+"\n");
				}
				for(User blocked : User.blockedUsers){
					System.out.println(blocked.toString()+"\n----------------------");
				}
			}
			else if(commandsThings[0].equals("ADDPOST-TEXT")){
				System.out.println("\n-----------------------\n"+"\n"+ "COMMAND TEXT:"+commandLine);
			}
			else if(commandsThings[0].equals("ADDPOST-IMAGE")){
				System.out.println("\n-----------------------\n"+"\n"+ "COMMAND TEXT:"+commandLine);
			}
			else if(commandsThings[0].equals("ADDPOST-VIDEO")){
				System.out.println("\n-----------------------\n"+"\n"+ "COMMAND TEXT:"+commandLine);
			}
			else if(commandsThings[0].equals("REMOVELASTPOST")){
				System.out.println("\n-----------------------\n"+"\n"+ "COMMAND TEXT:"+commandLine);
				if(signedUser.size()==0){
					System.out.println("Error: Please sign in and try again."+"\n");
				}
			}
			
			
}}}
