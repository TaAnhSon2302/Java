package Room;

import java.sql.Connection;
import java.util.ArrayList;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Process_Room implements IRoom {
    private static Connection cn;
	@Override
	public Connection get_ConRoom() {
		Connection cn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
	   		cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_room","root","1234");
		}
		catch(ClassNotFoundException | SQLException e)
		{}
		return cn;
	}

	@Override
	public ArrayList<Room> get_ListRoom() {
		Connection cn = get_ConRoom();
		String sql = "select * from tb_room";
		ArrayList<Room> lsroom = new ArrayList<>();
		try
		{
			PreparedStatement ps = (PreparedStatement) cn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				Room r = new Room();
				r.setRoomID(rs.getString("id"));
				r.setRoomType(rs.getString("roomtype"));
				r.setPrice(rs.getDouble("price"));
				r.setStatus(rs.getBoolean("status"));
				lsroom.add(r);
			}
			cn.close();
		}catch(SQLException e) {}
		return lsroom;
	}

	@Override
	public boolean add_Room(String roomID, String roomType, double price, boolean status) {
		Connection cn = get_ConRoom();
		String sql = "insert into tb_room(id,roomtype,price,status) values(?,?,?,?)";
		try {
			PreparedStatement ps = (PreparedStatement) cn.prepareStatement(sql);
			ps.setString(1,roomID);
			ps.setString(2,roomType);
	        ps.setDouble(3, price);
	        ps.setBoolean(4, status);
	        ps.executeUpdate();
	        cn.close();
	        return true;
		} catch(SQLException e) {}
		return false;
	}

	@Override
	public boolean update_Room(String roomID, String roomType, double price, boolean status) {
        Connection cn = get_ConRoom();
        String sql ="update tb_room set roomtype = ?, price = ?, status = ? where id =?";
        try {
        	PreparedStatement ps = (PreparedStatement) cn.prepareStatement(sql);
        	ps.setString(4, roomID);
        	ps.setString(1,roomType);
        	ps.setDouble(2,price);
        	ps.setBoolean(3, status);
        	ps.executeUpdate();
        	cn.close();
        	return true;
        }
        catch(Exception e) {}
		return false;
	}

	@Override
	public boolean delete_Room(String roomID) {
		Connection cn = get_ConRoom();
		  String sql = "delete from tb_room where id = ?";
		  try
		  {
			  PreparedStatement ps = (PreparedStatement) cn.prepareStatement(sql);
			  ps.setString(1,roomID);
			  ps.executeUpdate();
			  cn.close();
			  return true;
		  }
	      catch (Exception e){
		  return false;
		  }

	}
	public ArrayList<String> getRoomid(){
		ArrayList<String> names = new ArrayList<>();
		Connection cn = get_ConRoom();
		String sql = "select distinct id from tb_room order by id";
		 try {
			 PreparedStatement ps = (PreparedStatement) cn.prepareStatement(sql);
			 ResultSet rs = ps.executeQuery();
			 while(rs.next())
			 {
				 names.add(rs.getString("id"));
			 }
		 } catch(SQLException e) {}
		 return names;
	}
	public static void main(String[] args) {
	}

	@Override
	public ArrayList<Room> get_ListRoombyRoomType(String roomType) {
		Connection cn = get_ConRoom();
		String sql = "select * from tb_room where roomtype = ?";
		ArrayList<Room> lsroom = new ArrayList<>();
		try
		{
			PreparedStatement ps = (PreparedStatement) cn.prepareStatement(sql);
			 ps.setString(1,roomType);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				Room r = new Room();
				r.setRoomID(rs.getString("id"));
				r.setRoomType(rs.getString("roomtype"));
				r.setPrice(rs.getDouble("price"));
				r.setStatus(rs.getBoolean("status"));
				lsroom.add(r);
			}
			cn.close();
		}catch(SQLException e) {}
		return lsroom;
	}
}
