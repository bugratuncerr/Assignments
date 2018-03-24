
/**
 * @author Rookie
 *
 */
public class Tablet extends Computer{
	protected String dimension;
	private int itemID;
	
	/**
	 * @param cost Gets the value of item.txt's second element and assign to Tablet's cost,whenever a new object of Table is created.
	 * @param manufacturer Gets the value of item.txt's third element and assign to Tablet's manufacturer,whenever a new object of Table is created.
	 * @param brand Gets the value of item.txt's fourth element and assign to Tablet's brand,whenever a new object of Table is created.
	 * @param maxVolt Gets the value of item.txt's fifth element and assign to Tablet's maximum Voltage,whenever a new object of Table is created.
	 * @param maxWatt Gets the value of item.txt's sixth element and assign to Tablet's maximum Watt,whenever a new object of Table is created.
	 * @param operatingSystem Gets the value of item.txt's seventh element and assign to Tablet's operating system,whenever a new object of Table is created.
	 * @param CPUType Gets the value of item.txt's eighth element and assign to Tablet's CPU type,whenever a new object of Table is created.
	 * @param ramCapacity Gets the value of item.txt's ninth element and assign to Tablet's RAM capacity,whenever a new object of Table is created.
	 * @param HDDCapacity Gets the value of item.txt's tenth element and assign to Tablet's HDD capacity,whenever a new object of Table is created.
	 * @param dimension Gets the value of item.txt's eleventh element and assign to Tablet's dimension,whenever a new object of Table is created.
	 */
	public Tablet(String cost, String manufacturer, String brand, String maxVolt, String maxWatt,
			String operatingSystem, String CPUType, String ramCapacity, String HDDCapacity, String dimension) {
		this.itemID = Book.valueCounter++;
		this.cost = cost;
		this.manufacturer = manufacturer;
		this.brand = brand;
		this.maxVolt = maxVolt;
		this.maxWatt = maxWatt;
		this.operatingSystem = operatingSystem;
		this.CPUType = CPUType;
		this.ramCapacity = ramCapacity;
		this.HDDCapacity = HDDCapacity;
		this.dimension = dimension;
	}
	public String toString() {
		return ("-----------------------\n"+
				"Type: Tablet\n"+
				"Item ID: "+this.itemID+"\n"+
				"Price: "+this.cost+" $\n"+
				"Manufacturer: "+this.manufacturer+"\n"+
				"Brand: "+this.brand+"\n"+
				"Max Volt: "+this.maxVolt+"\n"+
				"Max Watt: "+this.maxWatt+"\n"+
				"Operating System: "+this.operatingSystem+"\n"+
				"CPU Type: "+this.CPUType+"\n"+
				"RAM Capacity: "+this.ramCapacity+"\n"+
				"HDD Capacity: "+this.HDDCapacity+"\n"+
				"Dimension: "+this.dimension+"\n"+
				"-----------------------\n");
	}
}
