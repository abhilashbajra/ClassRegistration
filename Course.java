public class Course {
	
	private String name;
	private String teacher;
	private String time;
	private int classnumber;
	
	public Course()
	{
		name = null;
		teacher = null;
	}
	public String get_time() {
		return time;
	}
	public int get_classnumber() {
		return classnumber;
	}
	public void set_time (String input) {
		time = input;
	}
	
	public void set_number (int input) {
		classnumber = input;
	}
	public Course(String spec_name, String spec_teacher)
	{
		name = spec_name;
		teacher = spec_teacher;
	}
	
	public String get_name() {
		return name;
	}
	public String get_teacher() {
		return teacher;
	}
	public void set_name(String input) {
		name = input;
	}
	
	public void set_teacher(String input) {
		teacher = input;
	}
	
	public String toString() {
		return (name + " with " + teacher + " at time " + time + " class number: " + classnumber);
	}

}