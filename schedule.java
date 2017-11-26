
public class schedule implements Comparable<schedule> {
	private int time;
	private String day;
	
	public schedule(String input){
		switch (input.charAt(0))
		{
		case 'M' : day = "Monday/Wednesday/Friday";
		break;
		case 'T' : day = "Tuesday/Thursday";
		break;
		}
		time = Character.getNumericValue(input.charAt(4))*10 + Character.getNumericValue(input.charAt(5));
	}
	public void set_date(String input) {
		switch (input.charAt(0))
		{
		case 'M' : day = "Monday/Wednesday/Friday";
		break;
		case 'T' : day = "Tuesday/Thursday";
		break;
		}
		time = Character.getNumericValue(input.charAt(4))*10 + Character.getNumericValue(input.charAt(5));
		
	}
	
	public int compareTo (schedule other) {
		if (this.time == other.time && this.day.equals(other.day))
		{
			return 0;
		}
		else
		{
			return 1;
		}
	}
}
