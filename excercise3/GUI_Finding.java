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

import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class GUI_Finding extends JFrame {

	private JPanel contentPane;
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
		 System.out.print(columns);
		 Model.setDataVector(rows, columns);
		 JTableStudent.setModel(Model);
    }
    public void getAllStudentbyClassAndGender(String ClassID, boolean Gender)
    {
    	Model.setRowCount(0);
		ArrayList<Student> ls = ps.getStudent_byClass_Gender(ClassID, Gender);
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
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_Finding frame = new GUI_Finding();
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
	public GUI_Finding() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1091, 686);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Lớp");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(233, 101, 71, 22);
		contentPane.add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "62TH1", "62TH2", "62TH3", "62TH4", "62TH5"}));
		comboBox.setBounds(296, 105, 290, 22);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_1 = new JLabel("Giới tính");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(233, 195, 71, 27);
		contentPane.add(lblNewLabel_1);
		
		JRadioButton rbNam = new JRadioButton("Nam");
		rbNam.setBounds(333, 201, 103, 21);
		contentPane.add(rbNam);
		
		JRadioButton rbNu = new JRadioButton("Nữ");
		rbNu.setBounds(484, 201, 103, 21);
		contentPane.add(rbNu);
		
		JLabel lblNewLabel_2 = new JLabel("Danh sách sinh viên");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(92, 283, 212, 27);
		contentPane.add(lblNewLabel_2);
		
		JTableStudent = new JTable();
		JTableStudent.setBounds(76, 350, 868, 220);
		contentPane.add(JTableStudent);
		
		JButton btnTim = new JButton("Tìm kiếm");
		btnTim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  
				   if(rbNam.isSelected()==true && comboBox.getSelectedItem().equals(""))
			       {
					 getAllStudentbyClassAndGender((String)comboBox.getSelectedItem(),true);
			       }
			       if(rbNu.isSelected()==true)
			       {
			    	   getAllStudentbyClassAndGender((String)comboBox.getSelectedItem(),false);
			       }				
			}
		});
		btnTim.setBounds(714, 116, 122, 33);
		contentPane.add(btnTim);
		columns.add("Mã sinh viên");
		columns.add("Họ tên");
		columns.add("Lớp");
		columns.add("Giới tính");
		columns.add("Điểm");
		columns.add("Xếp loại");
		getAllStudent();
	}
}
