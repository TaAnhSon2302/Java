package excercise3;

import java.sql.Connection;
import java.util.ArrayList;

public interface IStudent {
   public Connection getCon();
   public boolean delStudent(String ID);
   public ArrayList<Student> getListStudent();
   public ArrayList<Student> getStudent_byClass(String ClassID);
   public ArrayList<Student> getStudent_byClass_Gender(String ClassID, boolean Gender);
   public Student getStudent_byID(String ID);
   public boolean insertStudent(String ID, String Name, boolean Gender, String Class, Double Mark);
   public boolean DeleteStudent(String ID);
   public boolean updateStudent(String ID, String Name, boolean Gender, String Class, Double Mark);
}
