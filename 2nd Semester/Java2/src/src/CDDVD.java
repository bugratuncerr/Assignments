
/**
 * @author Rookie
 *
 */
public class CDDVD extends OfficeSupplies{
	protected String composerName;
	protected String song;
	private int itemID;
	
	/**
	 * @param cost Gets the value of item.txt's second element,whenever a new object of CDDVD is created.
	 * @param releaseDate Gets the value of item.txt's third element,whenever a new object of CDDVD is created.
	 * @param coverTitle Gets the value of item.txt's fourth element,whenever a new object of CDDVD is created.
	 * @param composerName Gets the value of item.txt's fifth element,whenever a new object of CDDVD is created.
	 * @param song Gets the value of item.txt's sixth element,whenever a new object of CDDVD is created.
	 */
	public CDDVD(String cost, String releaseDate, String coverTitle, String composerName, String song) {
		this.itemID = Book.valueCounter++;
		this.cost = cost;
		this.releaseDate = releaseDate;
		this.coverTitle = coverTitle;
		this.composerName = composerName;
		this.song = song;
	}
	public String toString() {
		return ("-----------------------\n"+
				"Type: CDDVD\n"+
				"Item ID:"+this.itemID+"\n"+
				"Price: "+this.cost+" $\n"+
				"Release Date: "+this.releaseDate+"\n"+
				"Title: "+this.coverTitle+"\n"+
				"Songs: "+this.song+"\n"+
				"Publisher: "+this.composerName+"\n"+
				"-----------------------\n");
	}
}
