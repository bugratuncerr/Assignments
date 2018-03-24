
/**
 * @author Rookie
 *
 */
public class Laptop extends Computer{
	protected String HDMISupport;
	private int itemID;
	
	/**
	 * @param cost Gets the value of item.txt's second element and assign to Laptop's cost,whenever a new object of Laptop is created.
	 * @param manufacturer Gets the value of item.txt's third element and assign to Laptop's manufacturer,whenever a new object of Laptop is created.
	 * @param brand Gets the value of item.txt's fourth element and assign to Laptop's brand,whenever a new object of Laptop is created.
	 * @param maxVolt Gets the value of item.txt's fifth element and assign to Laptop's max Voltage,whenever a new object of Laptop is created.
	 * @param maxWatt Gets the value of item.txt's sixth element and assign to Laptop's max Watt,whenever a new object of Laptop is created.
	 * @param operatingSystem Gets the value of item.txt's seventh element and assign to Laptop's operating system,whenever a new object of Laptop is created.
	 * @param CPUType Gets the value of item.txt's eighth element and assign to Laptop's CPU Type,whenever a new object of Laptop is created.
	 * @param ramCapacity Gets the value of item.txt's ninth element and assign to Laptop's ram capacity,whenever a new object of Laptop is created.
	 * @param HDDCapacity Gets the value of item.txt's tenth element and assign to Laptop's HDD capacity,whenever a new object of Laptop is created.
	 * @param HDMISupport Gets the value of item.txt's eleventh element and assign to Laptop's HDMI support,whenever a new object of Laptop is created.
	 * This will also determine,laptop has hdmi support or not.
	 */
	public Laptop(String cost, String manufacturer, String brand, String maxVolt, String maxWatt,
			String operatingSystem, String CPUType, String ramCapacity, String HDDCapacity,String HDMISupport) {
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
		if(HDMISupport.equals("1")){
			this.HDMISupport="Yes";
		}
		else{
			this.HDMISupport="No";
		}
	}
	public String toString() {
				return ("-----------------------\n"+
						"Type: Laptop\n"+
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
						"HDMI Support: "+this.HDMISupport+"\n"+
						"-----------------------\n");
			}
	}

