import java.io.File;
import java.io.FileNotFoundException;

import java.util.ArrayList;

import java.util.Collections;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * @author Rookie
 *
 */
public class Main {

	/**
	 * @param args Classical main arguments.
	 * @throws FileNotFoundException If the file does not exists,throws an exception.
	 */
	public static void main(String[] args) throws FileNotFoundException {
		
		List<String> users = new ArrayList<String>();
		List<Admin> admins = new ArrayList<Admin>();
		List<Customer> customers = new ArrayList<Customer>();
		List<Technician> technicians = new ArrayList<Technician>();
		List<Items> itemAllList = new ArrayList<Items>();
		{	
		Scanner file = new Scanner(new File(args[0]));
		while(file.hasNextLine()){
			String line = file.nextLine();
			users.add(line);
		}
		String userThings[];
		for(int i=0;i<users.size();i++){			
			userThings = users.get(i).split("\t");
			if(userThings[0].equals("CUSTOMER")){			
				customers.add(new Customer(userThings[1],userThings[2],userThings[3],userThings[4],userThings[5]));
			}
			if(userThings[0].equals("TECH")){
				
				technicians.add(new Technician(userThings[1],userThings[2],userThings[3],userThings[4],userThings[5]));
			}
			if(userThings[0].equals("ADMIN")){
				admins.add(new Admin(userThings[1],userThings[2],userThings[3],userThings[4],userThings[5]));
			}
			file.close();
		}
		}
		{
			
			
		List<String> items = new ArrayList<String>();
		Scanner file = new Scanner(new File(args[1]));
		while(file.hasNextLine()){
			String line = file.nextLine();
			items.add(line);
		}
		String itemThings[];
		for(int i=0;i<items.size();i++){			
			itemThings = items.get(i).split("\t");	
			if(itemThings[0].equals("BOOK")){
				itemAllList.add(new Book(itemThings[1],itemThings[2],itemThings[3],itemThings[4],itemThings[5], itemThings[6]));	
			}
			else if(itemThings[0].equals("CDDVD")){
				itemAllList.add(new CDDVD(itemThings[1],itemThings[2],itemThings[3],itemThings[4],itemThings[5]));
			}
			else if(itemThings[0].equals("DESKTOP")){
				itemAllList.add(new Desktop(itemThings[1],itemThings[2],itemThings[3],itemThings[4],itemThings[5],itemThings[6],itemThings[7],itemThings[8],itemThings[9],itemThings[10]));
			}
			else if(itemThings[0].equals("LAPTOP")){
				itemAllList.add(new Laptop(itemThings[1],itemThings[2],itemThings[3],itemThings[4],itemThings[5],itemThings[6],itemThings[7],itemThings[8],itemThings[9],itemThings[10]));
			}
			else if(itemThings[0].equals("TABLET")){
				itemAllList.add(new Tablet(itemThings[1],itemThings[2],itemThings[3],itemThings[4],itemThings[5],itemThings[6],itemThings[7],itemThings[8],itemThings[9],itemThings[10]));
			}
			else if(itemThings[0].equals("TV")){
				itemAllList.add(new TV(itemThings[1],itemThings[2],itemThings[3],itemThings[4],itemThings[5],itemThings[6]));
			}
			else if(itemThings[0].equals("SMARTPHONE")){
				itemAllList.add(new SmartPhone(itemThings[1],itemThings[2],itemThings[3],itemThings[4],itemThings[5],itemThings[6]));
			}
			else if(itemThings[0].equals("HAIRCARE")){
				itemAllList.add(new Hair(itemThings[1],itemThings[2],itemThings[3],itemThings[4],itemThings[5],itemThings[6],itemThings[7]));
			}
			else if(itemThings[0].equals("PERFUME")){
				itemAllList.add(new Perfume(itemThings[1],itemThings[2],itemThings[3],itemThings[4],itemThings[5],itemThings[6],itemThings[7]));
			}
			else if(itemThings[0].equals("SKINCARE")){
				itemAllList.add(new Skin(itemThings[1],itemThings[2],itemThings[3],itemThings[4],itemThings[5],itemThings[6],itemThings[7]));
			}
			
			file.close();	
		}
		}
		{
		List<String> commands = new ArrayList<String>();
		Scanner file = new Scanner(new File(args[2]));
		while(file.hasNextLine()){
			String line = file.nextLine();
			commands.add(line);
		}
		String commandThings[];
			for(int i=0;i<commands.size();i++){		
				commandThings = commands.get(i).split("\t");	
				Method(commandThings,admins,customers,commandThings[0],commands.get(i),technicians,itemAllList);
			}
			file.close();
	}
		}
	
	/**
	 * @param x X is a String value of a name.The parameter takes the name as string and check,name exists in Admin array list or not.
	 * @param list List has the storage of the all admins in users.txt and adding with methods.
	 * @return the value of a boolean value.It means when you check a name is admins or not it will give you 2 simple outputs.True or False.
	 * Then you can determine,is the name is Admin or not?
	 */
	public static boolean isAdmin(String x,List<Admin> list){
		boolean result = false;
		for(int i=0;i<list.size();i++){
			if(list.get(i).getName().equals(x))
				result = true;
		}
		return result;
	}
	
	/**
	 * @param x X is a String value of a name.The parameter takes the name as string and check,name exists in Technician array list or not.
	 * @param list List has the storage of the all technicians in users.txt and adding with methods.
	 * @return the value of a boolean value.It means when you check a name is technician or not it will give you 2 simple outputs.True or False.
	 * Then you can determine,is the name is Technician or not?
	 */
	public static boolean isTechnician(String x,List<Technician> list){
		//gets a name and detect if it is Technician or not
		boolean result = false;
		for(int i=0;i<list.size();i++){
			if(list.get(i).getName().equals(x))
				result = true;
		}
		return result;
	}
	
	
	/**
	 * This method is a all-in-one method.If i explain this,i implement all my methods inside of this method.It will find the commands.txt's first element.
	 * And using the first element it will go through the inner method.There are several methods which is only usable with Admin-Technician permissions.So i implement a
	 * simple methods.
	 * @param commandList String[] commandList is simply an array.Which has splitted value of commands.txt line.
	 * @param array array is an array list of Admins objects.When i read the users.txt,i add Users,Technicians,Admins in to an array list.
	 * @param liste liste is an array list of Customers objects.
	 * @param line String line is the first element of commandList in an iteration.So it has some values like("ADDCUSTOMER","ADDITEMS","CREATECAMPAIGN" etc.)
	 * @param completeLine Complete line stored the lines of commands.txt.Then when we go through our methods,it will find the true line and print to the console.
	 * @param arrayTech arrayTech is an array list which stored the technicians objects.
	 * @param arrayItems arrayItems is an array list of all the items in the items.txt.I use this array for controlling the item exists or not.
	 */
	public static void Method(String[] commandList,List<Admin> array,List<Customer> liste,String line,String completeLine,List<Technician> arrayTech,List<Items> arrayItems){
		List<Items> ShoppingCart = new ArrayList<Items>();
		if(line.equals("ADDCUSTOMER")){
			if(isAdmin(commandList[1],array)==true){
				System.out.println("COMMAND TEXT: "+"<"+completeLine+">\n");
				liste.add(new Customer(commandList[2],commandList[3],commandList[4],commandList[5],commandList[6]));
			}	
			else{
				System.out.println("COMMAND TEXT: "+"<"+completeLine+">\n");
				System.out.println("No admin person named "+commandList[1]+" exists!\n");
			}
		}
		else if(line.equals("SHOWCUSTOMER")){
			if(isAdmin(commandList[1],array)==true){
				System.out.println("COMMAND TEXT: "+"<"+completeLine+">\n");
				System.out.println(liste.get(Integer.parseInt(commandList[2])-1)+"\n");
			}
			else{
				System.out.println("COMMAND TEXT: "+"<"+completeLine+">\n");
				System.out.println("No admin person named "+commandList[1]+" exists!\n");
			}}
		else if(line.equals("SHOWCUSTOMERS")){
			if(isAdmin(commandList[1],array)==false){
				System.out.println("COMMAND TEXT: "+"<"+completeLine+">\n");
				System.out.println("No admin person named "+commandList[1]+" exists!\n");
			}
			else{
				System.out.println("COMMAND TEXT: "+"<"+completeLine+">\n");
				System.out.println(liste.toString().replace("[", "").replace("]", "").replace(",","")+"\n");
			}
		}
		else if(line.equals("SHOWADMININFO")){
			if(isAdmin(commandList[1],array)==true){
				System.out.println("COMMAND TEXT: "+"<"+completeLine+">\n");
				for(int i=0;i<array.size();i++){
					int x;
					if(array.get(i).getName().equals(commandList[1])){
						x=i;
						System.out.println(array.get(x).toString().replace("[", "").replace("]", "").replace(",","")+"\n");
					}	
				}		
			}
			else{
				System.out.println("COMMAND TEXT: "+"<"+completeLine+">\n");
				System.out.println("No admin person named "+commandList[1]+" exists!\n");
			}
		}
		else if(line.equals("CREATECAMPAIGN")){
			if(isAdmin(commandList[1],array)==true && Integer.parseInt(commandList[5])<=50){
				System.out.println("COMMAND TEXT: "+"<"+completeLine+">\n");
				Campaigns campaign = new Campaigns(commandList[2],commandList[3],commandList[4],commandList[5]);
				}
			else if(isAdmin(commandList[1],array)==false){
					System.out.println("COMMAND TEXT: "+"<"+completeLine+">\n");
					System.out.println("No admin person named "+commandList[1]+" exists!\n");
				}
			else{
				System.out.println("COMMAND TEXT: "+"<"+completeLine+">\n");
				System.out.println("Campaign was not created. Discount rate exceeds maximum rate of 50%.\n");
				}	
			}
		else if(line.equals("ADDTECH")){
			if(isAdmin(commandList[1],array)==true){
				System.out.println("COMMAND TEXT: "+"<"+completeLine+">\n");
				Technician tech = new Technician(commandList[2],commandList[3],commandList[4],commandList[5],commandList[6]);
			}
			else{
				System.out.println("COMMAND TEXT: "+"<"+completeLine+">\n");
				System.out.println("No admin person named "+commandList[1]+" exists!\n");
			}
		}
		else if(line.equals("ADDADMIN")){
			if(isAdmin(commandList[1],array)==true){
				System.out.println("COMMAND TEXT: "+"<"+completeLine+">\n");
				Admin adminx = new Admin(commandList[2],commandList[3],commandList[4],commandList[5],commandList[6]);
			}
			else{
				System.out.println("COMMAND TEXT: "+"<"+completeLine+">\n");
				System.out.println("No admin person named "+commandList[1]+" exists!\n");
			}
		}
		else if(line.equals("LISTITEM")){
			if(isAdmin(commandList[1],array)==true || isTechnician(commandList[1],arrayTech)==true){
				System.out.println("COMMAND TEXT: "+"<"+completeLine+">\n");
				System.out.println(arrayItems.toString().replace("[", "").replace("]", "").replace(",","")+"\n");
			}
			else{
				System.out.println("COMMAND TEXT: "+"<"+completeLine+">\n");
				System.out.println("No admin or technician person named "+commandList[1]+" exists!\n");
			}

		}
		else if(line.equals("SHOWITEMSLOWONSTOCK")){
			if(isAdmin(commandList[1],array)==true || isTechnician(commandList[1],arrayTech)==true){
				System.out.println("COMMAND TEXT: "+"<"+completeLine+">\n");
				ArrayList<String> allItems = new ArrayList<String>();
				for(Items o : arrayItems){
					allItems.add(o.getClass().getName());
				}
				Set<String> setItems = new HashSet<String>(allItems);
				List<String> sortedItems = new ArrayList<String>(setItems);
				Collections.sort(sortedItems);
				for(String x : sortedItems){
					if(Collections.frequency(allItems, x)<Integer.parseInt(commandList[2])){
						System.out.println(x+": "+Collections.frequency(allItems, x));
					}
				}
				System.out.println();
			}
			else{
				System.out.println("COMMAND TEXT: "+"<"+completeLine+">\n");
				System.out.println("No admin or technician person named "+commandList[1]+" exists!\n");
			}
		}
		else if(line.equals("SHOWVIP")){
			if(isAdmin(commandList[1],array)==true || isTechnician(commandList[1],arrayTech)==true){
				System.out.println("COMMAND TEXT: "+"<"+completeLine+">\n");
				
				
				
				///pass
		}
			else{
				System.out.println("COMMAND TEXT: "+"<"+completeLine+">\n");
				System.out.println("No admin or technician person named "+commandList[1]+" exists!\n");
			}
		}
		
		else if(line.equals("DISPITEMSOF")){
			if(isTechnician(commandList[1],arrayTech)==true){
				System.out.println("COMMAND TEXT: "+"<"+completeLine+">\n");
				for(String s : commandList[2].split(":")){
					if(s.equals("BOOK")){

					}
					
				}
			}
			else{
				System.out.println("COMMAND TEXT: "+"<"+completeLine+">\n");
				System.out.println("No technician person named "+commandList[1]+" exists!\n");
			}
			
		}
		
		else if(line.equals("ADDITEM")){
			if(isTechnician(commandList[1],arrayTech)==true){
				System.out.println("COMMAND TEXT: "+"<"+completeLine+">\n");
				///pass
			}
			else{
				System.out.println("COMMAND TEXT: "+"<"+completeLine+">\n");
				System.out.println("No technician person named "+commandList[1]+" exists!\n");
			}
		}
		
		else if(line.equals("SHOWORDERS")){
			if(isTechnician(commandList[1],arrayTech)==true){
				System.out.println("COMMAND TEXT: "+"<"+completeLine+">\n");
				///pass
			}
			else{
				System.out.println("COMMAND TEXT: "+"<"+completeLine+">\n");
				System.out.println("No technician person named "+commandList[1]+" exists!\n");
			}
		}
		
		else if(line.equals("CHPASS")){
			System.out.println("COMMAND TEXT: "+"<"+completeLine+">\n");
			if(Integer.parseInt(commandList[1])>=liste.size()){
				System.out.println("No customer with ID number "+commandList[1]+" exists!"+"\n");
			
			}
			for(Customer o : liste){	
				if(commandList[2].equals(o.getPassword())){
					o.setPassword(commandList[3]);
					System.out.println("The password has been successfully changed."+"\n");
					
				}
	
		}
			}
		
		else if(line.equals("DEPOSITMONEY")){	
			System.out.println("COMMAND TEXT: "+"<"+completeLine+">\n");
			for(Customer o : liste){
				if((Integer.parseInt(commandList[1])!=(o.getCustomerID()))){
					o.setBalance(o.getBalance()+(Double.parseDouble(commandList[2])));
				}
			}
		}

		else if(line.equals("SHOWCAMPAIGNS")){
			System.out.println("COMMAND TEXT: "+"<"+completeLine+">\n");
			for(Customer o : liste){
				if(!(commandList[1]).equals(o.getCustomerID())){
					
					System.out.println("No customer with ID number "+commandList[1]+" exists!"+"\n");
					break;
		}
				
				//PASS
			}
			}
		
		
		
		else if(line.equals("ADDTOCART")){//baksana
			System.out.println("COMMAND TEXT: "+"<"+completeLine+">\n");
			for(Customer o : liste){
				if(Integer.parseInt(commandList[1])==(o.getCustomerID())){
					if(Integer.parseInt(commandList[2])>=arrayItems.size()){
						System.out.println("Invalid item ID"+"\n");
			}
					else{
						ShoppingCart.add(arrayItems.get(Integer.parseInt(commandList[2])-1));
						System.out.println("The item "+arrayItems.get(Integer.parseInt(commandList[2])-1).getClass()+" has been successfully added to your cart."+"\n");
				}
				}
			}	
		}
		
		else if(line.equals("EMPTYCART")){
			System.out.println("COMMAND TEXT: "+"<"+completeLine+">\n");
		}
		
		else if(line.equals("ORDER")){
			System.out.println("COMMAND TEXT: "+"<"+completeLine+">\n");
		}
		
		}
		
	
	

	
	}
		

