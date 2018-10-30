/*Patrick Cole
 * 10/18/18
 * Average Gross Pay Calculator
 */
package GrossPayCalculator.common;
import java.text.DecimalFormat;
import java.util.Scanner;
public class CalculateGrossPay
{
	
	private double federalTax = 0.22; //This shouldn't be constant, based off of what income bracket user is located in
	private double grossPay;
	private double netPay;
	private double hourlyWage;
	private double numHours;
	private double stateTax;
	private double tmp;
	private String paySchedule;
	private Scanner input = new Scanner(System.in); //Keyboard Input
	private DecimalFormat f = new DecimalFormat("##.00");
	
	//Object Constructors
	public CalculateGrossPay() 
	{
		
	}
	public CalculateGrossPay(double pay, double hours, double statetax, String paymentSchedule) 
	{
		hourlyWage = pay;
		numHours = hours;
		stateTax = statetax;
		paySchedule = paymentSchedule;
	}
	//Setters and Getters
	public double getHourlyWage() 
	{
		return hourlyWage;
	}
	public void setHourlyWage(double hourlyWage) 
	{
		this.hourlyWage = hourlyWage;
	}
	public double getNumHours() 
	{
		return numHours;
	}
	public void setNumHours(double numHours) 
	{
		this.numHours = numHours;
	}
	public double getStateTax() 
	{
		return stateTax;
	}
	public void setStateTax(double stateTax) 
	{
		this.stateTax = stateTax;
	}
	public String getPaySchedule() 
	{
		return paySchedule;
	}
	public void setPaySchedule(String paySchedule) 
	{
		this.paySchedule = paySchedule;
	}
	//Calculates gross pay and net pay and returns them as an array with 2 elements
	//Gross Pay Equation = hourly wage * number of hours per week * how many weeks between payments * number of times payed per year
	//Net Pay Equation = (hourly wage * number of hours per week * how many weeks between payments - (pay of 1 paycheck * Federal Tax) - (pay of 1 check after federal tax * State Tax)) * number of times payed per year
	public double[] calcPay() 
	{
		grossPay = getHourlyWage() * getNumHours();
		
		switch(paySchedule) 
		{
			case "1":
				netPay = grossPay;
				grossPay *= 52;
				netPay -= netPay * federalTax;
				netPay -= netPay * stateTax;
				netPay *= 52;
				break;
			case "2":
				grossPay = grossPay * 2;
				netPay = grossPay;
				grossPay *= 26;
				netPay -= netPay * federalTax;
				netPay -= netPay * stateTax;
				netPay *= 26;
				break;
			case "3":
				grossPay = grossPay * 3;
				netPay = grossPay;
				grossPay *= 17;
				netPay -= netPay * federalTax;
				netPay -= netPay * stateTax;
				netPay *= 17;
				break;
			case "4":
				grossPay = grossPay * 4;
				netPay = grossPay;
				grossPay *= 12;
				netPay -= netPay * federalTax;
				netPay -= netPay * stateTax;
				netPay *= 12;
				break;
			default: //If it wasn't one of the cases, it was an invalid input, we ask for it again
				//Only used from main not GUI
				System.out.println("That wasn't one of the correct payment schedules.");
				System.out.println("Please enter the number corresponding to your payment plan. (1 : weekly, 2 : bi-weekly, 3 : tri-weekly, 4 : monthly)");
				setPaySchedule(input.nextLine());
				
		}
		return new double[] {grossPay, netPay};
	}
	//Check if the user enters a 'q' to quit or anything with a q in it
	//Only used from main not GUI
	public void checkQuit(String s) 
	{
		if(s.contains("q") || s.contains("Q") || s.contains("exit") || s.contains("Exit"))
		{
			System.out.println("Thank you for using Average Yearly Gross Pay Calculator!");
			System.exit(0);
		}
	}
	
	public double validInput(String s) 
	{
		try
		{
			tmp = Double.parseDouble(s);
		}
		catch(Exception e)//Catch exception if an invalid input and asks for another input
		{ 
			return 0;
		}
		return tmp;
	}
	
	public double validInput(String s, String name) {
		try
		{
			s = input.nextLine();
			checkQuit(s);
			tmp = Double.parseDouble(s);
		}
		catch(Exception e)
		{
			System.out.println("Invalid Input! Please enter your " + name + ".");
			return validInput(s, name);
		}
		return tmp;
	}
	
	@Override //toString overload
	public String toString() 
	{
		return "Based on your information entered: federalTax = " + federalTax 
				+ ", hourlyWage = " + hourlyWage + ", numHours = " + numHours + ", stateTax = " + stateTax + ", paySchedule = " + paySchedule
				+ "\nYour gross pay is: $" + f.format(grossPay) + "\nYour net pay is: $" + f.format(netPay);
	}
	
}
