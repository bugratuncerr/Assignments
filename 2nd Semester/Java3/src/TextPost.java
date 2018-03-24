
/**
 * @author Rookie
 *
 */
public class TextPost extends Post {
	private String filePath;
	private double longitude;
	private double latitude;
	
	private String tagged;
	
	
	/**
	 * @param textContent Whenever a new text post is created,constructor set the text Content of the Post.
	 * @param longitude Whenever a new text post is created,constructor set the longitude of the Post.
	 * @param latitude Whenever a new text post is created,constructor set latitude of the Post.
	 * @param tagged Whenever a new text post is created,constructor sets the tagged users of the Post.
	 */
	public TextPost(String textContent, double longitude, double latitude,String tagged) {
		super(textContent);
		this.longitude = longitude;
		this.latitude = latitude;
		this.tagged = tagged;
	}

	
	
	/**
	 * @return The file path of the image and video posts.
	 */
	public String getFilePath() {
		return filePath;
	}
	/**
	 * @param filePath Sets the new path of the image and video posts.
	 */
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public void showTaggedUsers(){
		
	}
	
	public void showPostLocation(){
		
	}
}
