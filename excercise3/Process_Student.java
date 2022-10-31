package excercise3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class Process_Student implements IStudent {
    private static Connection cn;
    @Override
	public Connection getCon() {
    	Connection cn = null;
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
	@Override
	public boolean delStudent(String ID) {
		  Connection cn = getCon();
		  String sql = "delete from tbstudent2 where id = ?";
		  try
		  {
			  PreparedStatement ps = (PreparedStatement) cn.prepareStatement(sql);
			  ps.setString(1,ID);
			  ps.executeUpdate();
			  cn.close();
			  return true;
		  }
	      catch (Exception e){
		  return false;
		  }
	}
	@Override
	public ArrayList<Student> getListStudent() {
		 Connection cn = getCon();
		  String sql="select * from tbstudent2";
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
	              st.setGender(rs.getBoolean("gender"));
	              st.setMark(rs.getDouble("mark"));
	              lsstudent.add(st);
			  } cn.close();
		  }catch (SQLException e){}
		  return lsstudent; 
	}
	@Override
	public ArrayList<Student> getStudent_byClass(String ClassID) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ArrayList<Student> getStudent_byClass_Gender(String ClassID, boolean Gender) {
		  Connection cn = getCon();
		  ArrayList<Student> lsstudent = new ArrayList<>();
		  String sql="Select * from tbstudent2 where classid = ? and gender = ?";
		  try {
			  PreparedStatement ps = (PreparedStatement) cn.prepareStatement(sql);
			  ps.setString(1, ClassID);
			  ps.setBoolean(2, Gender);
			  ResultSet rs = ps.executeQuery();
			  while(rs.next())
			  {
				  Student st = new Student();
				  st.setID(rs.getString("id"));
				  st.setName(rs.getString("name"));
	              st.setClassID(rs.getString("classid"));
	              st.setGender(rs.getBoolean("gender"));
	              st.setMark(rs.getDouble("mark"));
	              lsstudent.add(st);
			  }cn.close();
		  }catch (SQLException e){}
		  return lsstudent; 
	}
	@Override
	public Student getStudent_byID(String ID) {
		Connection cn = getCon();
		Student st = new Student();
		  String sql="Select * from tbstudent2 where id = ?";
		  try {
			  PreparedStatement ps = (PreparedStatement) cn.prepareStatement(sql);
			  ps.setString(1, ID);
			  ResultSet rs = ps.executeQuery();
			  while(rs.next())
			  {
				  st.setID(rs.getString("id"));
				  st.setName(rs.getString("name"));
	              st.setClassID(rs.getString("classid"));
	              st.setGender(rs.getBoolean("gender"));
	              st.setMark(rs.getDouble("mark"));
			  }cn.close();
		  }catch (SQLException e){}
		  return st; 
	}
	@Override
	public boolean insertStudent(String ID, String Name, boolean Gender, String ClassID, Double Mark) {
		 Connection cn = getCon();
		  String sql="insert into tbstudent2(ID,Name,Gender,ClassID,Mark)" + "values(?,?,?,?,?)";
		  try {
			  PreparedStatement ps = (PreparedStatement) cn.prepareStatement(sql);
			  ps.setString(1, ID);
			  ps.setString(2, Name);
			  ps.setBoolean(3, Gender);
			  ps.setString(4, ClassID);
			  ps.setDouble(5, Mark);
			  ps.executeUpdate();
			  cn.close();
			  return true;
		  }catch (SQLException e){}
		  return false;
	}
	@Override
	public boolean DeleteStudent(String ID) {

		  Connection cn = getCon();
		  String sql = "delete from tbstudent2 where id = ?";
		  try
		  {
			  PreparedStatement ps = (PreparedStatement) cn.prepareStatement(sql);
			  ps.setString(1,ID);
			  ps.executeUpdate();
			  cn.close();
			  return true;
		  }
	      catch (Exception e){
		  return false;
		  }
	}
	@Override
	public boolean updateStudent(String ID, String Name, boolean Gender, String ClassID, Double Mark) {
		  Connection cn = getCon();
		  String sql="update tbstudent2 set name = ?, classid = ?, gender = ?, mark = ? where id = ? ";
		  try {
			  PreparedStatement ps = (PreparedStatement) cn.prepareStatement(sql);
			  ps.setString(5, ID);
			  ps.setString(1, Name);
			  ps.setString(2, ClassID);
			  ps.setBoolean(3, Gender);
			  ps.setDouble(4, Mark);
			  ps.executeUpdate();
			  cn.close();
			  return true;
		  }catch (SQLException e){}
		  return false;
	}

}
