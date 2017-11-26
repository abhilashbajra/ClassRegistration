import java.util.*;
import java.io.*;
public class TestClass {
		
	public static void main (String[] args) throws FileNotFoundException  {
		ShoppingCart mycart = new ShoppingCart();
		Scanner input = new Scanner (System.in);
		System.out.println("This application will allow you to sign up for classes for the coming Spring 2017 semester");
		System.out.println("You are allowed to sign up for only 5 classes, you can add a class, swap a class with another class or remove a class");
		System.out.println("Lets get started, sign up for your first class");
		mycart.appendcart();
		do 
		{
			System.out.println("Would you like to add another class(type add), swap a class for another(type swap), or remove a class(type remove)");
			System.out.println("If you would like to exit the application please type exit");
			String answer = input.next();
			 if (answer.equals("add"))
				 mycart.appendcart();
			 else if (answer.equals("swap"))
			 {
				 mycart.removecart();
				 System.out.println("Now to replace that class with another");
				 mycart.appendcart();
			 }
			 else if (answer.equals("remove"))
			 {
				 mycart.removecart();
			 }
			 else if (answer.equals("exit"))
			 {
				 System.out.println("You are signed up for " + mycart.getcart().size() + " classes");
				 for (int i = 0;i< mycart.getcart().size();i++)
				 {
					 System.out.println(mycart.getcart().get(i).toString());
				 }
				 System.out.println("Thank you and good luck with the new semester!");
				 return;
			 }
		}while(true);
	}
}
