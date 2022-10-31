package excersie1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.Vector;
import java.util.ArrayList;

import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI_Update extends JFrame {

	private JPanel contentPane;
	private JTextField txtID;
	private JTextField txtName;
	private JTextField txtMark;
	DefaultTableModel Model = new DefaultTableModel();
	Vector<String> columns = new Vector<String>();
	Vector<Vector<Object>> rows = new Vector<>();
    Process_Student ps = new Process_Student();
     
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_Update frame = new GUI_Update();
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
	public GUI_Update() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 899, 565);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mã sinh viên");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(106, 97, 101, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Họ tên");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(106, 172, 81, 31);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Lớp");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(108, 213, 79, 21);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Giới tính");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(105, 271, 82, 13);
		contentPane.add(lblNewLabel_3);
		
		JRadioButton rbMale = new JRadioButton("Nam");
		rbMale.setBounds(221, 270, 103, 21);
		contentPane.add(rbMale);
		
		JRadioButton rbFemale = new JRadioButton("Nữ");
		rbFemale.setBounds(395, 270, 103, 21);
		contentPane.add(rbFemale);
		
		txtID = new JTextField();
		txtID.setBounds(217, 97, 202, 19);
		contentPane.add(txtID);
		txtID.setColumns(10);
		
		txtName = new JTextField();
		txtName.setBounds(228, 181, 191, 19);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		JComboBox cbClass = new JComboBox();
		cbClass.setModel(new DefaultComboBoxModel(new String[] {"62TH1", "62TH2", "62TH3", "62TH4", "62TH5"}));
		cbClass.setBounds(221, 216, 198, 21);
		contentPane.add(cbClass);
		
		JLabel lblNewLabel_4 = new JLabel("Điểm");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(106, 325, 45, 21);
		contentPane.add(lblNewLabel_4);
		
		txtMark = new JTextField();
		txtMark.setBounds(228, 329, 191, 19);
		contentPane.add(txtMark);
		txtMark.setColumns(10);
		
		JButton btnSearch = new JButton("Tìm kiếm");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Student> ls = ps.getListStudent_byID(txtID.getText());
				for(int i =0;i<ls.size();i++) {
					Student st = (Student) ls.get(i);
					if(st.getID().equals(txtID.getText())){
						txtName.setText(st.getName());
						for(int j =0;j<cbClass.getItemCount();j++) {
							if(((String) cbClass.getItemAt(j)).equals(st.getClassID())) {
								cbClass.setSelectedIndex(j);
							}
						  }
                         if(st.getGender().equals("Nam")) {
                             rbMale.setSelected(true);      	 
                         }
                         if(st.getGender().equals("Nữ")) {
                             rbFemale.setSelected(true);      	 
                         }	
                         txtMark.setText(String.valueOf(st.getMark()));
						}
					}
				}
		});
		btnSearch.setBounds(616, 96, 85, 21);
		contentPane.add(btnSearch);
		
		JButton btnUpdate = new JButton("Cập nhật");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rbMale.isSelected()==true)
				{
					Process_Student.updateStudent(txtID.getText(),txtName.getText(),(String)cbClass.getSelectedItem(),"Nam",Double.parseDouble(txtMark.getText()));
				}
				if(rbFemale.isSelected()==true)
				{
					Process_Student.updateStudent(txtID.getText(),txtName.getText(),(String)cbClass.getSelectedItem(),"Nữ",Double.parseDouble(txtMark.getText()));
				}
			}
		});
		btnUpdate.setBounds(616, 258, 85, 21);
		contentPane.add(btnUpdate);
	}
}
