
/**
 * @author Rookie
 *
 */
public class Location extends Post{

	/**
	 * @param textContent Whenever a new Post location created,it will set the text content of Post.
	 * @param longitude Whenever a new Post location created,it will set the longitude of Post.
	 * @param latitude Whenever a new Post location created,it will set the latitude of Post.
	 */
	public Location(String textContent, double longitude, double latitude) {
		super(textContent);
		this.longitude = longitude;
		this.latitude = latitude;
	}
	private double longitude;
	private double latitude;
	
	/**
	 * @return The value of latitude of Posts'.
	 */
	public double getLatitude() {
		return latitude;
	}
	/**
	 * @param latitude Sets the new value of latitude of Posts'.
	 */
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	/**
	 * @return The value of longitude of Posts'.
	 */
	public double getLongitude() {
		return longitude;
	}
	/**
	 * @param longitude Sets the new value of longitude of Posts's.
	 */
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
	@Override
	public void showTaggedUsers() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void showPostLocation() {
		// TODO Auto-generated method stub
		
	}

	


}
