import java.util.UUID;

/**
 * @author Rookie
 *
 */
public interface PostInterface {
	
	/**
	 * @param setText Sets the new texts of the Posts.
	 */
	void setText(String setText);
	
	/**
	 * @param getText Is the text of Post.
	 * @return The texts of the Post.
	 */
	String getText(String getText);
	
	/**
	 * @return The random created id of the Posts.
	 */
	UUID getID();

	
	/**
	 * Gets the upload dates of the posts.
	 */
	void getDate();
	
}
