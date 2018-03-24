
/**
 * @author Rookie
 *
 */
public class ImagePost extends TextPost {

	private String filePath;
	/**
	 * @param textContent Whenever a new image post is created,constructor set the text Content of the Post.
	 * @param longitude Whenever a new image post is created,constructor set the longitude of the Post.
	 * @param latitude Whenever a new image post is created,constructor set the latitude of the Post.
	 * @param tagged Whenever a new image post is created,constructor set the tagged users of the Post.
	 * @param filePath Whenever a new image post is created,constructor set the file's path of the Post.
	 * @param resolution Whenever a new image post is created,constructor set the resolution of the Post.
	 */
	public ImagePost(String textContent, double longitude, double latitude, String tagged,String filePath,String resolution) {
		super(textContent, longitude, latitude, tagged);
		this.resolution = resolution;
		this.filePath = filePath;
	}
	private String resolution;


	/**
	 * @return The resolution of the Image.
	 */
	public String getResolution() {
		return resolution;
	}
	/**
	 * @param resolution Sets the new resolutuion of the Image.
	 */
	public void setResolution(String resolution) {
		this.resolution = resolution;
	}

	
}
