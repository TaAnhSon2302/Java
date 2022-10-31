package excersie1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Process_Student {
   public static Connection cn;
   public static Connection getCon() {
   	try
   	{
   		Class.forName("com.mysql.cj.jdbc.Driver");
   		cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbstudent","root","1234");
   	}
   	catch(ClassNotFoundException  | SQLException e)
   	{

   	}
   	return cn;
   }
  public ArrayList<Student> getListStudent()
  {
	  Connection cn = getCon();
	  String sql="select * from tbstudent";
	  ArrayList<Student> lsstudent = new ArrayList<>();
	  try {
		  PreparedStatement ps = (PreparedStatement) cn.prepareStatement(sql);
		  ResultSet rs = ps.executeQuery();
		  while(rs.next())
		  {
			  Student st = new Student();
			  st.setID(rs.getString("id"));
			  st.setName(rs.getString("name"));
              st.setClassID(rs.getString("classid"));
              st.setGender(rs.getString("gender"));
              st.setMark(rs.getDouble("mark"));
              lsstudent.add(st);
		  } cn.close();
	  }catch (SQLException e){}
	  return lsstudent; 
  }  
  public ArrayList<Student> getListStudent_byClass(String ClassID)
  {
	  Connection cn = getCon();
	  ArrayList<Student> lsstudent = new ArrayList<>();
	  String sql="Select * from tbstudent where classid= ?";
	  try {
		  PreparedStatement ps = (PreparedStatement) cn.prepareStatement(sql);
		  ps.setString(1, ClassID);
		  ResultSet rs = ps.executeQuery();
		  while(rs.next())
		  {
			  Student st = new Student();
			  st.setID(rs.getString("id"));
			  st.setName(rs.getString("name"));
              st.setClassID(rs.getString("classid"));
              st.setGender(rs.getString("gender"));
              st.setMark(rs.getDouble("mark"));
              lsstudent.add(st);
		  }
	  }catch (SQLException e){}
	  return lsstudent; 
  }  
  public ArrayList<Student> getListStudent_byID(String ID)
  {
	  Connection cn = getCon();
	  ArrayList<Student> lsstudent = new ArrayList<>();
	  String sql="Select * from tbstudent where id= ?";
	  try {
		  PreparedStatement ps = (PreparedStatement) cn.prepareStatement(sql);
		  ps.setString(1,ID);
		  ResultSet rs = ps.executeQuery();
		  while(rs.next())
		  {
			  Student st = new Student();
			  st.setID(rs.getString("id"));
			  st.setName(rs.getString("name"));
              st.setClassID(rs.getString("classid"));
              st.setGender(rs.getString("gender"));
              st.setMark(rs.getDouble("mark"));
              lsstudent.add(st);
		  }
	  }catch (SQLException e){}
	  return lsstudent; 
  }
  public ArrayList<Student> getListStudent_byClassgGender(String ClassID, String Gender)
  {
	  Connection cn = getCon();
	  String sql="Select * from tbstudent where ClassID=? Gender=?";
	  ArrayList<Student> lsstudent = new ArrayList<>();
	  try {
		  PreparedStatement ps = (PreparedStatement) cn.prepareStatement(sql);
		  ps.setString(1, ClassID);
		  ps.setString(2, Gender);
		  ResultSet rs = ps.executeQuery();
		  while(rs.next())
		  {
			  Student st = new Student();
			  st.setID(rs.getString("id"));
			  st.setName(rs.getString("name"));
              st.setClassID(rs.getString("classid"));
              st.setGender(rs.getString("gender"));
              st.setMark(rs.getDouble("mark"));
              lsstudent.add(st);
		  }cn.close();
	  }catch (SQLException e){}
	  return lsstudent; 
  }  
   public static boolean insertStudent(String ID, String Name, String Gender,String ClassID, double Mark)
   {
	      Connection cn = getCon();
		  String sql="insert into tbstudent(ID,Name,Gender,ClassID,Mark)" + "values(?,?,?,?,?)";
		  try {
			  PreparedStatement ps = (PreparedStatement) cn.prepareStatement(sql);
			  ps.setString(1, ID);
			  ps.setString(2, Name);
			  ps.setString(3, Gender);
			  ps.setString(4, ClassID);
			  ps.setDouble(5, Mark);
			  ps.executeUpdate();
			  cn.close();
			  return true;
		  }catch (SQLException e){}
		  return false;
   }
   public static boolean delStudent(String ID)
   {
	   Connection cn = getCon();
	   String sql = "delete from tbstudent where id = ?";
	   try {
		   PreparedStatement ps = (PreparedStatement) cn.prepareStatement(sql);
		   ps.setString(1, ID);
		   ps.executeUpdate();
		   cn.close();
		   return true;
	   }catch(Exception e)
	   {
		   return false;
	   }
   }
   public static boolean updateStudent(String ID, String Name, String Gender,String ClassID, double Mark)
   {
	      Connection cn = getCon();
		  String sql="update tbstudent set name = ?, classid = ?, gender = ?, mark = ? where id = ? ";
		  try {
			  PreparedStatement ps = (PreparedStatement) cn.prepareStatement(sql);
			  ps.setString(5, ID);
			  ps.setString(1, Name);
			  ps.setString(2, Gender);
			  ps.setString(3, ClassID);
			  ps.setDouble(4, Mark);
			  ps.executeUpdate();
			  cn.close();
			  return true;
		  }catch (SQLException e){}
		  return false;
   }
  public static void main(String[] args) throws SQLException
  {
	  getCon();
  }
}
