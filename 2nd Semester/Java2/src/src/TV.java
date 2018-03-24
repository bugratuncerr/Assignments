
/**
 * @author Rookie
 *
 */
public class TV extends Electronic{
	protected String screenSize;
	private int itemID;
	
	
	/**
	 * @param cost Gets the value of item.txt's second element and assign to TV's cost,whenever a new object of TV is created.
	 * @param manufacturer Gets the value of item.txt's third element and assign to TV's manufacturer,whenever a new object of TV is created.
	 * @param brand Gets the value of item.txt's fourth element and assign to TV's brand,whenever a new object of TV is created.
	 * @param maxVolt Gets the value of item.txt's fifth element and assign to TV's maximum Voltage,whenever a new object of TV is created.
	 * @param maxWatt Gets the value of item.txt's sixth element and assign to TV's maximum Watt,whenever a new object of TV is created.
	 * @param screenSize Gets the value of item.txt's seventh element and assign to TV's screen size,whenever a new object of TV is created.
	 */
	public TV(String cost, String manufacturer, String brand, String maxVolt, String maxWatt, String screenSize) {
		this.itemID = Book.valueCounter++;
		this.cost = cost;
		this.manufacturer = manufacturer;
		this.brand = brand;
		this.maxVolt = maxVolt;
		this.maxWatt = maxWatt;
		this.screenSize = screenSize;
	}
	public String toString() {
		return ("-----------------------\n"+
				"Type: TV\n"+
				"Item ID: "+this.itemID+"\n"+
				"Price: "+this.cost+" $\n"+
				"Manufacturer: "+this.manufacturer+"\n"+
				"Brand: "+this.brand+"\n"+
				"Max Volt: "+this.maxVolt+"\n"+
				"Max Watt: "+this.maxWatt+"\n"+
				"Screen Size: "+this.screenSize+"\n"+
				"-----------------------\n");
	}
}
