package excercise3;

public class Student {
	  public String Name,ClassID,ID;
	  public double Mark;
	  public boolean Gender;
	  public Student(String ID, String Name, boolean Gender, double Mark)
	  {
		  this.ID = ID;this.Name = Name;
		  this.Gender = Gender; this.Mark = Mark;
	  }
	  public Student() {}
	public boolean isGender() {
		return Gender;
	}
	public void setGender(boolean Gender) {
		this.Gender = Gender;
	}
	public String getName() {
		return Name;
	}
	public void setName(String Name) {
		this.Name = Name;
	}
	public String getClassID() {
		return ClassID;
	}
	public void setClassID(String ClassID) {
		this.ClassID = ClassID;
	}
	public String getID() {
		return ID;
	}
	public void setID(String ID) {
		this.ID = ID;
}
	public double getMark() {
		return Mark;
	}
	public void setMark(double Mark) {
		this.Mark = Mark;
	}
	public String Rank()
	{
		String s ="";
		if(this.Mark>=9.0)
		{
			s="Xuất xắc";
		}
		else if(this.Mark>=8.0 && this.Mark<9.0)
		{
			s="Giỏi";
		}
		else if(this.Mark>=6.5 && this.Mark<8.0)
		{
			s="Khá";
		}
		else
			s="Trung bình";
	    return s;
	}
	
	}
	

