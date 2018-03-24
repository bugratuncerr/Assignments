
/**
 * @author Rookie
 *
 */
public class Desktop extends Computer{
	protected String boxColor;
	private int itemID;
	
	
	
	/**
	 * @param cost Gets the value of item.txt's second element and assign to Desktop's cost,whenever a new object of Desktop is created.
	 * @param manufacturer Gets the value of item.txt's third element and assign to Desktop's manufacturer,whenever a new object of Desktop is created.
	 * @param brand Gets the value of item.txt's fourth element and assign to Desktop's brand,whenever a new object of Desktop is created.
	 * @param maxVolt Gets the value of item.txt's fifth element and assign to Desktop's max Volt,whenever a new object of Desktop is created.
	 * @param maxWatt Gets the value of item.txt's sixth element and assign to Desktop's max Watt,whenever a new object of Desktop is created.
	 * @param operatingSystem Gets the value of item.txt's seventh element and assign to Desktop's operating system,whenever a new object of Desktop is created.
	 * @param CPUType Gets the value of item.txt's eighth element and assign to Desktop's CPU Type,whenever a new object of Desktop is created.
	 * @param ramCapacity Gets the value of item.txt's ninth element and assign to Desktop's ram capacity,whenever a new object of Desktop is created.
	 * @param HDDCapacity Gets the value of item.txt's tenth element and assign to Desktop's HDD capacity,whenever a new object of Desktop is created.
	 * @param boxColor Gets the value of item.txt's eleventh element and assign to Desktop's box color,whenever a new object of Desktop is created.
	 */
	public Desktop(String cost, String manufacturer, String brand, String maxVolt, String maxWatt,
			String operatingSystem, String CPUType, String ramCapacity, String HDDCapacity, String boxColor) {
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
		this.boxColor = boxColor;
		
	}
	public String toString() {
		return ("-----------------------\n"+
				"Type: Desktop\n"+
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
				"Box Color: "+this.boxColor+"\n"+
				"-----------------------\n");
	}
	
	
}
