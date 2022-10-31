package excercise3;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import javax.swing.JLabel;
import java.awt.Font;
import java.util.Vector;

import javax.swing.JTextField;
import javax.swing.JRadioButton;
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
	private JComboBox cbClass;
	private JRadioButton rbNam;
	private JRadioButton rbNu;
	private JLabel lbName;
	private Student st;
	DefaultTableModel Model = new DefaultTableModel();
	Vector<String> columns = new Vector<String>();
	Vector<Vector<Object>> rows = new Vector<>();
    Process_Student ps = new Process_Student();
    private JLabel lbID;
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
     public void getStudentInfor(String ID)
     {
    	 if(txtID.equals(""))
	    	{
	         lbID.setText("ID is empty");
	    	}
	    	else
	    	{
	    		st =(Student) ps.getStudent_byID(ID);
	    		if(st==null)
	    		{
	    			lbID.setText("Not found");
	    		}
	    		else {
	    			txtName.setText(st.getName());
	                cbClass.setSelectedItem(st.getClassID());
	                if(st.isGender())
	                {
	                	rbNam.setSelected(true);
	                	rbNu.setSelected(false);
	                }
	                else 
	                {
	                	rbNu.setSelected(true);
	                	rbNam.setSelected(false);
	                }
	                	
	                txtMark.setText(Double.toString(st.getMark()));
	    		}
	    	}
     }
	/**
	 * Create the frame.
	 */
	public GUI_Update() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 967, 656);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mã sinh viên");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(123, 32, 107, 34);
		contentPane.add(lblNewLabel);
		
		txtID = new JTextField();
		txtID.setBounds(271, 43, 185, 19);
		contentPane.add(txtID);
		txtID.setColumns(10);
		
	    lbName = new JLabel("Họ tên");
		lbName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbName.setBounds(123, 129, 72, 19);
		contentPane.add(lbName);
		
		JLabel lblNewLabel_2 = new JLabel("Lớp");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(123, 200, 72, 19);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Giới tính");
		lblNewLabel_3.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(123, 274, 72, 34);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Điểm");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(123, 370, 54, 25);
		contentPane.add(lblNewLabel_4);
		
	    rbNam = new JRadioButton("Nam");
		rbNam.setBounds(242, 284, 103, 21);
		contentPane.add(rbNam);
		
	    rbNu = new JRadioButton("Nữ");
		rbNu.setBounds(428, 284, 103, 21);
		contentPane.add(rbNu);
		
		txtName = new JTextField();
		txtName.setBounds(271, 129, 185, 19);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		txtMark = new JTextField();
		txtMark.setBounds(269, 376, 185, 19);
		contentPane.add(txtMark);
		txtMark.setColumns(10);
		
		JButton btnTim = new JButton("Tìm kiếm");
		btnTim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ID = (String) txtID.getText();
				getStudentInfor(ID);
			}
		});
		btnTim.setBounds(641, 77, 85, 21);
		contentPane.add(btnTim);
		
		JButton btnUpdate = new JButton("Cập nhật");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rbNam.isSelected()==true)
				{
					ps.updateStudent(txtID.getText(),txtName.getText(),true,(String)cbClass.getSelectedItem(),Double.parseDouble(txtMark.getText()));
				}
				if(rbNu.isSelected()==true)
				{
					ps.updateStudent(txtID.getText(),txtName.getText(),false,(String)cbClass.getSelectedItem(),Double.parseDouble(txtMark.getText()));
				}
			}
		});
		btnUpdate.setBounds(641, 375, 85, 21);
		contentPane.add(btnUpdate);
		
	    cbClass = new JComboBox();
	    cbClass.setModel(new DefaultComboBoxModel(new String[] {"62TH1", "62TH2", "62TH3", "62TH4", "62TH5"}));
	    cbClass.setBounds(271, 202, 185, 21);
		contentPane.add(cbClass);
		
		lbID = new JLabel("");
		lbID.setBounds(497, 46, 45, 13);
		contentPane.add(lbID);
	}
}
