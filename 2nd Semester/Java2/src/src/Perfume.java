
/**
 * @author Rookie
 *
 */
public class Perfume extends Cosmetic{
	protected String lastingDuration;
	private int itemID;
	
	/**
	 * @param cost Gets the value of item.txt's second elements and assign to Perfume's cost whenever a new object of Perfume is created.
	 * @param manufacturer Gets the value of item.txt's third elements and assign to Perfume's manufacturer whenever a new object of Perfume is created.
	 * @param brand Gets the value of item.txt's fourth elements and assign to Perfume's brand whenever a new object of Perfume is created.
	 * @param isOrganic Gets the value of item.txt's fifth elements and assign to Perfume is organic or not whenever a new object of Perfume is created.
	 * Also in this constructor,we will determine Perfume is organic or not.
	 * @param expirationYear Gets the value of item.txt's sixth elements and assign to Perfume's expiration date whenever a new object of Perfume is created.
	 * @param weight Gets the value of item.txt's seventh elements and assign to Perfume's weight whenever a new object of Perfume is created.
	 * @param lastingDuration Gets the value of item.txt's eighth  elements and assign to Perfume's lasting duration whenever a new object of Perfume is created.
	 */
	public Perfume(String cost, String manufacturer, String brand, String isOrganic, String expirationYear,
			String weight, String lastingDuration) {
		this.itemID = Book.valueCounter++;
		this.cost = cost;
		this.manufacturer = manufacturer;
		this.brand = brand;
		if(isOrganic.equals("1")){
			this.isOrganic="Yes";
		}
		else{
			this.isOrganic="No";
		}
		this.expirationYear = expirationYear;
		this.weight = weight;
		this.lastingDuration = lastingDuration;
	}
	public String toString() {
		
		return ("-----------------------\n"+
				"Type: Perfume\n"+
				"Item ID: "+this.itemID+"\n"+
				"Price: "+this.cost+" $\n"+
				"Manufacturer: "+this.manufacturer+"\n"+
				"Brand: "+this.brand+"\n"+
				"Organic: "+this.isOrganic+"\n"+
				"Expiration Date: "+this.expirationYear+"\n"+
				"Weight: "+this.weight+"\n"+
				"Lasting Duration: "+this.lastingDuration+"\n"+
				"-----------------------\n");
	}
}
