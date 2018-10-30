/*Patrick Cole
 * 10/18/18
 * Average Gross Pay Calculator
 */
package GrossPayCalculator.common;
import java.text.DecimalFormat;
import java.util.Scanner;

public class mainhello 
{
	public static void main(String[] args) 
	{
		//Variables for inputs
		String hourlyWage = "";
		String hours = "";
		String sTax = "";
		String paySchedule = "";
	
		//The instance of the object
		CalculateGrossPay grossPay = new CalculateGrossPay();
		
		//Scanner for keyboard input and a format for dollar amounts
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		DecimalFormat f = new DecimalFormat("##.00");
		
		//Program Intro
		System.out.println("Hello, Welcome to Average Yearly Gross Pay Calculator!");
		System.out.println("Enter 'q' at any time during the program to close it.\n");
		System.out.println("Please enter your hourly wage.");
		grossPay.setHourlyWage(grossPay.validInput(hourlyWage, "hourly wage"));
		System.out.println("Please enter the average number of hours you work per week.");
		grossPay.setNumHours(grossPay.validInput(hours, "average number of hours worked per week"));
		System.out.println("Please enter your state's tax in decimal form. (5% : 0.05)");
		grossPay.setStateTax(grossPay.validInput(sTax, "state's tax in decimal form. (5% : 0.05)"));
		System.out.println("Please enter the number corresponding to your payment plan. (1 : weekly, 2 : bi-weekly, 3 : tri-weekly, 4 : monthly)");
		paySchedule = input.nextLine();
		grossPay.checkQuit(paySchedule);
		grossPay.setPaySchedule(paySchedule);
		System.out.println();
	
		//End output of gross pay and net pay
		System.out.println("Your average gross pay for one year is: $" + f.format((grossPay.calcPay()[0])));
		System.out.println("Your average net pay for one year is: $" + f.format((grossPay.calcPay()[1])));
		System.out.println("Thank you for using Average Yearly Gross Pay Calculator, press enter to exit!");
		input.nextLine();
		System.exit(0);
	}

}



