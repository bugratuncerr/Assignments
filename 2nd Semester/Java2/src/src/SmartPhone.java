
/**
 * @author Rookie
 *
 */
public class SmartPhone extends Electronic{
	protected String screenType;
	private int itemID;
	
	
	
	/**
	 * @param cost Gets the value of item.txt's second element and assign to Smartphone's cost,whenever a new object is created.
	 * @param manufacturer Gets the value of item.txt's third element and assign to Smartphone's manufacturer,whenever a new object is created.
	 * @param brand Gets the value of item.txt's fourth element and assign to Smarphone's brand,whenever a new object is created.
	 * @param maxVolt Gets the value of item.txt's fifth element and assign to Smartphone's maximum Voltage,whenever a new object is created.
	 * @param maxWatt Gets the value of item.txt's sixth element and assign to Smartphone's maximum Watt,whenever a new object is created.
	 * @param screenType Gets the value of item.txt's seventh element and assign to Smartphone's screen type,whenever a new object is created.
	 */
	public SmartPhone(String cost, String manufacturer, String brand, String maxVolt, String maxWatt,
			String screenType) {
		this.itemID = Book.valueCounter++;
		this.cost = cost;
		this.manufacturer = manufacturer;
		this.brand = brand;
		this.maxVolt = maxVolt;
		this.maxWatt = maxWatt;
		this.screenType = screenType;
	}
	public String toString() {
		return ("-----------------------\n"+
				"Type: SmartPhone\n"+
				"Item ID: "+this.itemID+"\n"+
				"Price: "+this.cost+" $\n"+
				"Manufacturer: "+this.manufacturer+"\n"+
				"Brand: "+this.brand+"\n"+
				"Max Volt: "+this.maxVolt+"\n"+
				"Max Watt: "+this.maxWatt+"\n"+
				"Screen Type: "+this.screenType+"\n"+
				"-----------------------\n");
	}
}
