package excersie1;

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
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI_Student extends JFrame {

	private JPanel contentPane;
	private JTextField txtID;
	private JTextField txtName;
	private JTextField txtMark;
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
	public void addStudent(String ID, String Name,String ClassID, String Gender,double Mark)
	{
		if(Process_Student.insertStudent(ID, Name, Gender, ClassID, Mark)==true)
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
				 tbRow.add(s.getGender());
				 tbRow.add(s.getMark());
				 tbRow.add(s.Rank());
				 rows.add(tbRow);
			 }
			 Model.setDataVector(rows, columns);
			 JtableStudent.setModel(Model);
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
		setBounds(100, 100, 1146, 762);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("M?? sinh vi??n");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(71, 67, 146, 28);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("H??? t??n");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(71, 121, 118, 28);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("L???p");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(71, 175, 126, 48);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Gi???i t??nh");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel_3.setBounds(61, 239, 136, 40);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("??i???m");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel_4.setBounds(71, 308, 112, 48);
		contentPane.add(lblNewLabel_4);
		
		txtID = new JTextField();
		txtID.setBounds(191, 75, 314, 20);
		contentPane.add(txtID);
		txtID.setColumns(10);
		
		txtName = new JTextField();
		txtName.setBounds(194, 129, 311, 19);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		JComboBox cbClass = new JComboBox();
		cbClass.setModel(new DefaultComboBoxModel(new String[] {"62TH1", "62TH2", "62TH3", "62TH4", "62TH5"}));
		cbClass.setBounds(188, 192, 317, 21);
		contentPane.add(cbClass);
		
		txtMark = new JTextField();
		txtMark.setBounds(204, 327, 301, 19);
		contentPane.add(txtMark);
		txtMark.setColumns(10);
		JtableStudent = new JTable();
		JtableStudent.setBounds(97, 407, 918, 205);
		
		contentPane.add(JtableStudent);
		
		JRadioButton rbMale = new JRadioButton("Nam");
		rbMale.setBounds(174, 253, 103, 21);
		contentPane.add(rbMale);
		
		JRadioButton rbFemale = new JRadioButton("N???");
		rbFemale.setBounds(366, 253, 103, 21);
		contentPane.add(rbFemale);
		
		JButton btnAdd = new JButton("Th??m sinh vi??n");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rbMale.isSelected()==true) {
				   	addStudent(txtID.getText(),txtName.getText(),(String)cbClass.getSelectedItem(),"Nam",Double.parseDouble(txtMark.getText()));
				}
				if(rbFemale.isSelected()==true) {
				   	addStudent(txtID.getText(),txtName.getText(),(String)cbClass.getSelectedItem(),"N???",Double.parseDouble(txtMark.getText()));
				}
			}
		});
		btnAdd.setBounds(384, 376, 184, 21);
		contentPane.add(btnAdd);
		columns.add("M?? sinh vi??n");
		columns.add("H??? t??n");
		columns.add("L???p");
		columns.add("Gi???i t??nh");
		columns.add("??i???m");
		columns.add("X???p lo???i");
		getAllStudent();
	}
}
