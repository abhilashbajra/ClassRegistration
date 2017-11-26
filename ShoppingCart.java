import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ShoppingCart{
	
	private static ArrayList <Course> cart= new ArrayList <Course>();
	private static ArrayList <schedule> myschedule = new ArrayList <schedule>();
	
	public ShoppingCart(){
		//nothing in here because java automatically initializes ArrayList
	}
		
	public ArrayList <Course> getcart()
	{
		return cart;
	}
	
	private static void classselection (String key, Course mycourse) throws FileNotFoundException   {
		File data = new File ("class_data.txt");
		Scanner fileinput = new Scanner (data);
		String [] subject = new String [6];
		String [] course = new String [24];
		String [] teacher = new String [48];
		String [] time = new String [96]; 
		int [] number = new int [96];
		for (int i = 0; i < 96; i++)
		{
			subject[i/16] = fileinput.next();
			course [i/4] = fileinput.next();
			teacher [i/2] = fileinput.next();
			time [i] = fileinput.next();
			number [i] = fileinput.nextInt();
		}
		if (key.equals(subject[0]))
		{
			System.out.println("Courses that can be taken are: calculus, linear_algebra, differential_equations, probability");
		}
		else if (key.equals(subject[1]))
		{
			System.out.println("Courses that can be taken are: electical_analysis, digital_systems, computer_architecture, data_structures");
		}
		else if (key.equals(subject[2]))
		{
			System.out.println("Courses that can be taken are: anatomy, genetics, biotechnology, medicine");
		}
		else if (key.equals(subject[3]))
		{
			System.out.println("Courses that can be taken are: generic_chemistry, organic_chemistry, analytical_chemistry, physical_chemistry");
		}
		else if (key.equals(subject[4]))
		{
			System.out.println("Courses that can be taken are: critical_reading, shakespeare, chaucer, science_fiction");
		}
		else if (key.equals(subject[5]))
		{
			System.out.println("Courses that can be taken are: management, accounting_analysis, corporate_finance, marketing");
		}
		else
		{
			System.out.println("There has been an error!");
		}
		Scanner input = new Scanner (System.in);
		String courseinput, teacherinput;
		System.out.println("Enter a course you want to take: ");
		courseinput = input.next();
		boolean correct = false;
		do{
			for (int i = 0; i < 24 ; i++)
			{
				if (courseinput.equals(course[i]))
				{
					mycourse.set_name(course[i]);
					System.out.println("The professors availiable for " + course[i] + " are " + teacher [2*i] + " and " + teacher [2*i+1]);
					System.out.println("Which professor do you want to take?");
					System.out.println("If you want to check the professor's rating please type 'rate'");
					String torate = input.next();
					if (torate.equals("rate"))
					{
						Scanner rateinput = new Scanner (System.in);
						do{
						System.out.println("Enter the professor you want see rated: ");
						torate = rateinput.next();
						ratemyteacher(torate);
						System.out.println("Do you want to rate another professor? (yes or no)");
						}
						while (rateinput.next().equals("yes"));
						System.out.println("Which professor do you want to take?");
						teacherinput = rateinput.next();
					}
					else	
						teacherinput= torate;
					do
					{
						if (!teacherinput.equals(teacher [2*i]) && !teacherinput.equals(teacher [2*i+1]))
						{
							System.out.println("Please correctly retype the professor's name. example: M_Robert");
							teacherinput = input.next();
							correct = false;
						}
						else
							correct = true;
					}while(correct == false);
							if (teacherinput.equals(teacher [2*i]))
							{
								mycourse.set_teacher(teacher[2*i]);
								System.out.println("MWF stands for Monday/Wednesday/Friday class for one hour, TTR stands for Tuesday/Thursday class for one and a half hour");
								System.out.println("The times availiable are : " + time [4*i] + " and " + time[4*i +1]);
								System.out.println("Which time do you want to take the class?");
								String timeinput;
								do {
								timeinput = input.next();	
								if (timeinput.equals(time [4*i]))
								{
									mycourse.set_time(time [4*i]);
									mycourse.set_number(number[4*i]);
								}
								else if (timeinput.equals(time [4*i+1]))
								{
									mycourse.set_time(time [4*i+1]);
									mycourse.set_number(number[4*i+1]);
								}
								else
									System.out.println("Please enter a valid time. example: MWF_11:00");
								} while (!timeinput.equals(time [4*i]) && !timeinput.equals(time [4*i+1]));
								correct = true;
								return;
							}
							else
							{
								mycourse.set_teacher(teacher[2*i+1]);
								System.out.println("MWF stands for Monday/Wednesday/Friday class for one hour, TTR stands for Tuesday/Thursday class for one and a half hour");
								System.out.println("The times availiable are : " + time [4*i+3] + " and " + time[4*i +4]);
								System.out.println("Which time do you want to take the class?");
								String timeinput;
								do {
									timeinput = input.next();
								if (timeinput.equals(time [4*i+3]))
								{
									mycourse.set_time(time [4*i+3]);
									mycourse.set_number(number[4*i+3]);
								}
								else if (timeinput.equals(time [4*i+4]))
								{
									mycourse.set_time(time [4*i+4]);
									mycourse.set_number(number[4*i+4]);
								}
								else
									System.out.println("Please enter a valid time. example: MWF_11:00");
								} while (!timeinput.equals(time [4*i+3]) && !timeinput.equals(time [4*i+4]));
								correct = true;
								return;
							}
				}
				else
					correct = false;
			}
		if (correct == false)
		{
			System.out.println("Please retype the course name: ");
			courseinput = input.next();
		}
		}while(correct == false);
	}
	
	private static void ratemyteacher (String key) throws FileNotFoundException
	{
		File ratings = new File ("teacher_ratings.txt");
		Scanner fileinput = new Scanner (ratings);
		String [] teacher = new String [48];
		double [] difficulty = new double [48];
		String [] quality = new String [48];
		String [] curvetype = new String [48];
		for (int i = 0; i < 48; i++)
		{
			teacher [i] = fileinput.next();
			difficulty [i] = fileinput.nextDouble();
			quality [i] = fileinput.next();
			curvetype [i] = fileinput.next();
			if (key.equals(teacher[i]))
			{
				System.out.println("The difficulty rating of " + teacher [i] + " is " + difficulty[i] + " out of 10");
				System.out.println("Students have rated the professor's teaching method as " + quality[i]);
				System.out.println("The professor is known to have a " + curvetype[i] + " curve policy");
				break;
			}
		}
		fileinput.close();
	}
	
	public void appendcart () throws FileNotFoundException{
		if (cart.size() == 5)
		{
			System.out.println("You have the max amount of classes to be signed up for, please swap or remove a class to sign up for a new class");
			return;
		}
		Scanner input = new Scanner (System.in);
		String subject;
		System.out.println("Enter Your Subject (math, engineering, biology, chemistry, literature, or business: ");
		subject = input.next();
		Course newcourse = new Course();
		classselection (subject , newcourse);
		schedule check = new schedule(newcourse.get_time());
		for (int i = 0; i<myschedule.size(); i++)
		{
			if (check.compareTo(myschedule.get(i)) == 0)
			{
				System.out.println("There already is a class in that time slot.");
				return;
			}
		}
		System.out.println("Are you sure you want to add the " + subject + " class " + newcourse);
		String reply = input.next();
		do{
			if (reply.equals("yes") || reply.equals("Yes"))
			{
				System.out.println("Class added");
				cart.add(newcourse);
				myschedule.add(check);
			}
			else if (reply.equals("no") || reply.equals("No")){
				return;
			}
			else
				System.out.println("Please answer yes or no");
		}while(!reply.equals("yes") && !reply.equals("Yes"));
	}
	public void removecart (){
		if (cart.isEmpty())
		{
			System.out.println("There are no classes to remove");
			return;
		}
		Scanner input = new Scanner (System.in);
		System.out.println("These are the following classes with respective classnumber in your shopping cart");
		for (int i = 0; i< cart.size(); i++)
		{
			System.out.println(i+1 + ": " + cart.get(i).get_name() + "   " + cart.get(i).get_classnumber());
		}
		System.out.println("Enter the class number of the class you want to remove");
		int key;
		do {
			
			key = input.nextInt();
			for (int i = 0; i< cart.size(); i++)
			{
				if (key == cart.get(i).get_classnumber())
				{
					System.out.println("Are you sure you want to remove this class?");
					String reply = input.next();
					do{
					if (reply.equals("yes"))
					{
						cart.remove(i);
						myschedule.remove(i);
						System.out.println("Class removed");
						return;
					}
					else if (reply.equals("no"))
					{
						return;
					}
					else
						System.out.println("Reply yes or no");
					}while(true);
				}
			}
			System.out.println("Enter a valid class number of the class you want to remove");
		}while (true);
	}
}
