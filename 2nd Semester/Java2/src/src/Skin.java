
/**
 * @author Rookie
 *
 */
public class Skin extends Cosmetic{
	
	protected String babySensitive;
	private int itemID;
	
	

	/**
	 * @param cost Gets the value of item.txt's second elements and assign to Skin care product's cost whenever a new object is created.
	 * @param manufacturer Gets the value of item.txt's third elements and assign to Skin care product's manufacturer whenever a new object is created.
	 * @param brand Gets the value of item.txt's fourth elements and assign to Skin care product's brand whenever a new object is created.
	 * @param isOrganic Gets the value of item.txt's fifth elements and assign to Skin care product is organic or not  whenever a new object is created.
	 * Also in this constructor,we will determine product is organic or not.
	 * @param expirationYear Gets the value of item.txt's sixth elements and assign to Skin care product's expiration date whenever a new object is created.
	 * @param weight Gets the value of item.txt's seventh elements and assign to Skin care product's weight whenever a new object is created.
	 * @param babySensitive Gets the value of item.txt's eighth elements and assign to Skin care product is baby sensitive or not whenever a new object is created.
	 * Also in this constructor,we will determine product is baby sensitive or not.
	 */
	public Skin(String cost, String manufacturer, String brand, String isOrganic, String expirationYear, String weight,
			String babySensitive) {
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
		if(babySensitive.equals("1")){
			this.babySensitive="Yes";
		}
		else{
			this.babySensitive="No";
		}
	}
	public String toString() {
		
		return ("-----------------------\n"+
				"Type: SkinCare\n"+
				"Item ID: "+this.itemID+"\n"+
				"Price: "+this.cost+" $\n"+
				"Manufacturer: "+this.manufacturer+"\n"+
				"Brand: "+this.brand+"\n"+
				"Organic: "+this.isOrganic+"\n"+
				"Expiration Date: "+this.expirationYear+"\n"+
				"Weight: "+this.weight+"\n"+
				"Baby Sensitive: "+this.babySensitive+"\n"+
				"-----------------------\n");
	}
	
	
}
