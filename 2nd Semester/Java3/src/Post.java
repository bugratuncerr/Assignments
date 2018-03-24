import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author Rookie
 *
 */
public abstract class Post implements PostInterface {
	static List<User> posts = new ArrayList<User>();
	static List<User> taggedUsers = new ArrayList<User>();
	private String textContent;
	
	/**
	 * @param textContent Whenever a new Post is created,we set the text content of the Post.
	 */
	public Post(String textContent) {
		this.textContent = textContent;
	}
	
	public void setText(String setText){
		
	}
	public String getText(String getText){
		return textContent;
		
	}
	public UUID getID(){
		return UUID.randomUUID();
	}
	public void getDate(){
		
	}
	/**
	 * Abstract method which does show the tagged users.We will implement this method inside subclasses.
	 */
	public abstract void showTaggedUsers();
	/**
	 * Abstract method which does show the post location.We will implement this method inside subclasses.
	 */
	public abstract void showPostLocation();
		
	}


