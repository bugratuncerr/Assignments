import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class HelloJava {
	
	//Factorial method by the help of using recursive function
	public static int factorialFunc(int x){ 
		if(x==0 || x==1)
			return 1;
		return factorialFunc(x-1)*x;
	}
	
	//Func1 implementation
	public static double fnc1(double x){
		return (x*x)-x+3;
	}
	
	//Func2 implementation
	public static double fnc2(double x){ 
		return Math.pow((3*Math.sin(x)-4), 2);
	}
	
	//Func3 and Arcsinhx calculation implementation,also this method writed by the rules of McLaurin series
	public static double fnc3(double x){ 
		double result=0.0;
		for(int i=0;i<30;i++){
			result += ((Math.pow(-1, i)*factorialFunc(2*i))/(Math.pow(4, i)*factorialFunc(i)*factorialFunc(i)*(2*i+1)))*Math.pow(x, 2*i+1);
		}
		return result;
	}
	
	//This method doing Riemann middle sum with calling the functions above
	public static double functionSolve(String function,double value1,double value2,double partition){ 
		double deltaX = ((value2-value1)/partition);
		double total = 0.0;
		for(int i=0;i<partition;i++){	
			double x = value1 + (deltaX/2);
			x += (i*deltaX);
			if(function.equals("Func1")){
				total += fnc1(x);
			}
			else if(function.equals("Func2")){
				total += fnc2(x);
			}
			else if(function.equals("Func3")){
				total += fnc3(x);
			}
		}
		return total * deltaX;
	}
	
	//Finding Armstrong number with entered digit number
	public static String armstrongNumbers(int digit){
		ArrayList<Integer> armstrongList = new ArrayList<Integer>();
		String Armstrong ="0 1 ";
		while(digit!=0){
		for (int n=2;n<Math.pow(10, digit);n++){
			int sum = 0;
			int value = n;
			for (int i = 1; i <= digit; i++){
				int number = value % 10;
				value = value / 10;			
				sum = sum + (int) Math.pow(number, digit);
		}
		if(sum == n) {
			armstrongList.add(sum);
			}
		}
		digit--;
		}
		Collections.sort(armstrongList);
		for (Integer numbers:armstrongList){
			Armstrong+= numbers+" ";
		}
		return Armstrong;
	}
	
	//Reads input file with Scanner method and print the output with calling the methods
	public static void main(String[] args) throws IOException 
	{
		List<String> lines = new ArrayList<String>();
		Scanner file = new Scanner(new File(args[0]));
		while(file.hasNextLine()){
			String line = file.nextLine();
			lines.add(line);
		}
		String inputThings[];
		for(int i=0;i<lines.size();i++){
			inputThings = lines.get(i).split(" ");
		ArrayList<String> arrayInput = new ArrayList<String>(Arrays.asList(inputThings));
		if(arrayInput.get(0).equals("IntegrateReimann")){
			System.out.println("IntegrateReimann "+arrayInput.get(1)+" "+arrayInput.get(2)+" "+arrayInput.get(3)+" "+arrayInput.get(4)
			+" Result: "+functionSolve(arrayInput.get(1),Double.parseDouble(arrayInput.get(2)),Double.parseDouble(arrayInput.get(3)),Double.parseDouble(arrayInput.get(4))));
		}
		else if(arrayInput.get(0).equals("Arcsinh")){
			System.out.println("Arcsinh "+arrayInput.get(1)+" Result: "+fnc3(Double.parseDouble(arrayInput.get(1))));
		}
		else if(arrayInput.get(0).equals("Armstrong")){
			System.out.println("Armstrong "+arrayInput.get(1)+" Result: "+armstrongNumbers(Integer.parseInt(arrayInput.get(1))));
		}
	file.close();
	}
}
	}