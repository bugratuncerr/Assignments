
/**
 * @author Rookie
 *
 */
public class VideoPost extends TextPost {
	private int duration;
	private String filePath;

	/**
	 * @param textContent Whenever a new video post is created,constructor set the text content of the Post.
	 * @param longitude Whenever a new video post is created,constructor set the longitude of the Post.
	 * @param latitude Whenever a new video post is created,constructor set the latitude of the Post.
	 * @param tagged Whenever a new video post is created,constructor set the tagged users of the Post.
	 * @param filePath Whenever a new video post is created,constructor set the path of file of the Post.
	 * @param duration Whenever a new video post is created,constructor set the duration of the Post.
	 */
	public VideoPost(String textContent, double longitude, double latitude, String tagged,String filePath, int duration) {
		super(textContent, longitude, latitude, tagged);
		this.duration = duration;
		this.filePath = filePath;
	}
	/**
	 * @return The value of max duration of the Videos.
	 */
	public int getDuration() {
		return duration;
	}
	/**
	 * @param duration Sets the new duration of the Videos.
	 */
	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	
}
