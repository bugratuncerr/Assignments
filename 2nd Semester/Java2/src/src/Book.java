
/**
 * @author Rookie
 *
 */
public class Book extends OfficeSupplies{
	protected String publisherName;
	protected String author;
	protected String pageNumber;
	protected static int valueCounter=1;
	private int itemID;

	/**
	 * @param cost Gets the value of item.txt's second element and assign to Book's name,whenever a new object of Book is created.
	 * @param releaseDate Gets the value of item.txt's third element and assign to Book's release date,whenever a new object of Book is created.
	 * @param coverTitle Gets the value of item.txt's fourth element and assign to Book's cover title,whenever a new object of Book is created.
	 * @param publisherName Gets the value of item.txt's fifth element and assign to Book's publisher name,whenever a new object of Book is created.
	 * @param author Gets the value of item.txt's second sixth and assign to Book's author,whenever a new object of Book is created.
	 * @param pageNumber Gets the value of item.txt's seventh element and and assign to Book's number of pages,whenever a new object of Book is created.
	 */
	protected Book(String cost, String releaseDate, String coverTitle, String publisherName, String author,
			String pageNumber) {
		this.itemID = valueCounter++;
		this.cost = cost;
		this.releaseDate = releaseDate;
		this.coverTitle = coverTitle;
		this.publisherName = publisherName;
		this.author = author;
		this.pageNumber = pageNumber;
	}
	
	/**
	 * @return the value of a Book's itemID using getter
	 */
	public int getItemID() {
		return itemID;
	}

	/**
	 * @param itemID sets the value of  new itemID using setter
	 */
	public void setItemID(int itemID) {
		this.itemID = itemID;
	}

	public String toString() {
		return ("-----------------------\n"+
				"Type: Book\n"+
				"Item ID: "+this.itemID+"\n"+
				"Price: "+this.cost+" $\n"+
				"Release Date: "+this.releaseDate+"\n"+
				"Title: "+this.coverTitle+"\n"+
				"Publisher: "+this.publisherName+"\n"+
				"Author: "+this.author+"\n"+
				"Page: "+this.pageNumber+"\n"+
				"-----------------------\n");
	}
	
	
	
}
