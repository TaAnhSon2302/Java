package excersie1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class GUI_finding extends JFrame {

	private JPanel contentPane;
	private JTable JtableStudent;
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
			 tbRow.add(s.getGender());
			 tbRow.add(s.getMark());
			 tbRow.add(s.Rank());
			 rows.add(tbRow);
		 }
		 Model.setDataVector(rows, columns);
		 JtableStudent.setModel(Model);
	}
	public void getAllStudentbyClass(String ClassID)
	{
		 Model.setRowCount(0);
		 ArrayList<Student> ls = ps.getListStudent_byClass(ClassID);
		 for(int i=0;i<ls.size();i++)
		 {
			 Student s = (Student) ls.get(i);
			 Vector<Object> tbRow = new Vector<>();
			 tbRow.add(s.getID());
			 tbRow.add(s.getName());
			 tbRow.add(s.getClassID());
			 tbRow.add(s.getGender());
			 tbRow.add(s.getMark());
			 tbRow.add(s.Rank());
			 rows.add(tbRow);
		 }
		 Model.setDataVector(rows, columns);
		 JtableStudent.setModel(Model);
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_finding frame = new GUI_finding();
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
	public GUI_finding() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 896, 581);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Lớp");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(192, 68, 89, 35);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Danh sách sinh viên");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(39, 134, 192, 26);
		contentPane.add(lblNewLabel_1);
		
		JtableStudent = new JTable();
		JtableStudent.setBounds(71, 240, 697, 205);
	
		
		contentPane.add(JtableStudent);
		
		JComboBox cbClass = new JComboBox();
		cbClass.setModel(new DefaultComboBoxModel(new String[] {"62TH1", "62TH2", "62TH3", "62TH4"}));
		cbClass.setBounds(255, 77, 184, 26);
		contentPane.add(cbClass);
		
		JButton btnNewButton = new JButton("Tìm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getAllStudentbyClass((String)cbClass.getSelectedItem());
			}
		});
		btnNewButton.setBounds(512, 82, 119, 21);
		contentPane.add(btnNewButton);
		columns.add("Mã sinh viên");
		columns.add("Họ tên");
		columns.add("Lớp");
		columns.add("Giới tính");
		columns.add("Điểm");
		columns.add("Xếp loại");
		getAllStudent();
	}
}
