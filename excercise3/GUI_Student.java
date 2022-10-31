package excercise3;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;



import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class GUI_Student extends JFrame {

	private JPanel contentPane;
	private JTextField txtID;
	private JTextField txtName;
	private JTextField txtMark;
	private JTable JTableStudent;
	DefaultTableModel Model = new DefaultTableModel();
	Vector<String> columns = new Vector<String>();
	Vector<Vector<Object>> rows = new Vector<>();
    Process_Student ps = new Process_Student();
	public void getAllStudent()
	{
		 ArrayList<Student> ls = ps.getListStudent();
		 for(int i=0;i<ls.size();i++)
		 {
			 Student s = (Student) ls.get(i);
			 Vector<Object> tbRow = new Vector<>();
			 tbRow.add(s.getID());
			 tbRow.add(s.getName());
			 tbRow.add(s.getClassID());
			 if(s.isGender()==true)
			 {
				 tbRow.add("Nam");
			 }
			 else
			 {
				 tbRow.add("Nữ");
			 }
			 
			 tbRow.add(s.getMark());
			 tbRow.add(s.Rank());
			 rows.add(tbRow);
		 }
		 Model.setDataVector(rows, columns);
		 JTableStudent.setModel(Model);
	}
	public void addStudent(String ID, String Name,String ClassID, boolean Gender,double Mark)
	{
		if(ps.insertStudent(ID, Name, Gender, ClassID, Mark)==true)
		{
			Model.setRowCount(0);
			ArrayList<Student> ls =ps.getListStudent();
			 for(int i=0;i<ls.size();i++)
			 {
				 Student s = (Student) ls.get(i);
				 Vector<Object> tbRow = new Vector<>();
				 tbRow.add(s.getID());
				 tbRow.add(s.getName());
				 tbRow.add(s.getClassID());
				 if(s.isGender()==true)
				 {
					 tbRow.add("Nam");
				 }
				 else
				 {
					 tbRow.add("Nữ");
				 }
				 tbRow.add(s.getMark());
				 tbRow.add(s.Rank());
				 rows.add(tbRow);
			 }
			 Model.setDataVector(rows, columns);
			 JTableStudent.setModel(Model);
		}
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_Student frame = new GUI_Student();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI_Student() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1102, 613);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mã sinh viên");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(90, 62, 149, 35);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Họ tên");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(92, 112, 78, 35);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Lớp");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(92, 171, 45, 25);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Giới tính");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(92, 221, 107, 25);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Điểm");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(92, 284, 45, 25);
		contentPane.add(lblNewLabel_4);
		
		txtID = new JTextField();
		txtID.setBounds(224, 73, 258, 25);
		contentPane.add(txtID);
		txtID.setColumns(10);
		
		txtName = new JTextField();
		txtName.setBounds(222, 123, 260, 25);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		JComboBox cbClass = new JComboBox();
		cbClass.setModel(new DefaultComboBoxModel(new String[] {"62TH1", "62TH2", "62TH3", "62TH4", "62TH5"}));
		cbClass.setBounds(224, 176, 266, 25);
		contentPane.add(cbClass);
		
		JRadioButton rbNam = new JRadioButton("Nam");
		rbNam.setBounds(216, 226, 103, 21);
		contentPane.add(rbNam);
		
		JRadioButton rbNu = new JRadioButton("Nữ");
		rbNu.setBounds(363, 226, 103, 21);
		contentPane.add(rbNu);
		
		txtMark = new JTextField();
		txtMark.setBounds(223, 290, 259, 19);
		contentPane.add(txtMark);
		txtMark.setColumns(10);
		
		JTableStudent = new JTable();
		JTableStudent.setBounds(90, 373, 853, 193);
		contentPane.add(JTableStudent);
		
		JButton btnAdd = new JButton("Thêm sinh viên");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rbNam.isSelected()==true)
				{
					addStudent(txtID.getText(),txtName.getText(),(String)cbClass.getSelectedItem(),true,Double.parseDouble(txtMark.getText()));
				}
				if(rbNu.isSelected()==true)
				{
					addStudent(txtID.getText(),txtName.getText(),(String)cbClass.getSelectedItem(),false,Double.parseDouble(txtMark.getText()));
				}
			}
		});
		btnAdd.setBounds(397, 329, 120, 21);
		contentPane.add(btnAdd);
		columns.add("Mã sinh viên");
		columns.add("Họ tên");
		columns.add("Lớp");
		columns.add("Giới tính");
		columns.add("Điểm");
		columns.add("Xếp loại");
		getAllStudent();
	}
}
