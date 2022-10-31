package Room;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.EtchedBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;

public class GUI_Room extends JFrame {

	private JPanel contentPane;
	private JTextField txtRoomID;
	private JTextField txtPrice;
	private JComboBox cbType;
	private JTable JTableRoom;
	DefaultTableModel Model = new DefaultTableModel();
	Vector<String> columns = new Vector<String>();
	Vector<Vector<Object>> rows = new Vector<>();
	Process_Room pr = new Process_Room();
	
	public void getAllRoom()
	{
		ArrayList<Room> lr = pr.get_ListRoom();
		for(int i =0;i<lr.size();i++)
		{
			Room r = (Room) lr.get(i);
			Vector<Object> tbRow = new Vector<>();
			tbRow.add(r.getRoomID());
			tbRow.add(r.getRoomType());
			tbRow.add(r.getPrice());
			if(r.isStatus()==true)
			{
				tbRow.add("CÒN PHÒNG");
			}
			else
			{
				tbRow.add("KHÔNG CÒN PHÒNG");
			}
			rows.add(tbRow);
		}
		Model.setDataVector(rows, columns);
		JTableRoom.setModel(Model);
	}
	public void getRoombyRoomType(String roomType)
	{
		Model.setRowCount(0);
		ArrayList<Room> lr = pr. get_ListRoombyRoomType(roomType);
		for(int i =0;i<lr.size();i++)
		{
			Room r = (Room) lr.get(i);
			Vector<Object> tbRow = new Vector<>();
			tbRow.add(r.getRoomID());
			tbRow.add(r.getRoomType());
			tbRow.add(r.getPrice());
			if(r.isStatus()==true)
			{
				tbRow.add("CÒN PHÒNG");
			}
			else
			{
				tbRow.add("KHÔNG CÒN PHÒNG");
			}
			rows.add(tbRow);
		}
		Model.setDataVector(rows, columns);
		JTableRoom.setModel(Model);
	}
	public void addRoom(String roomID, String roomType,double price,boolean status)
	{
		if(pr.add_Room(roomID, roomType, price, status)==true)
		{
			Model.setRowCount(0);
			ArrayList<Room> lr = pr.get_ListRoom();
			for(int i =0;i<lr.size();i++)
			{
				Room r = (Room) lr.get(i);
				Vector<Object> tbRow = new Vector<>();
				tbRow.add(r.getRoomID());
				tbRow.add(r.getRoomType());
				tbRow.add(r.getPrice());
				if(r.isStatus()==true)
				{
					tbRow.add("CÒN PHÒNG");
				}
				else
				{
					tbRow.add("KHÔNG CÒN PHÒNG");
				}
				rows.add(tbRow);
			}
			Model.setDataVector(rows, columns);
			JTableRoom.setModel(Model);
		}
	}
	public void updateRoom(String roomID, String roomType,double price,boolean status)
	{
		if(pr.update_Room(roomID, roomType, price, status)==true)
		{
			Model.setRowCount(0);
			ArrayList<Room> lr = pr.get_ListRoom();
			for(int i =0;i<lr.size();i++)
			{
				Room r = (Room) lr.get(i);
				Vector<Object> tbRow = new Vector<>();
				tbRow.add(r.getRoomID());
				tbRow.add(r.getRoomType());
				tbRow.add(r.getPrice());
				if(r.isStatus()==true)
				{
					tbRow.add("CÒN PHÒNG");
				}
				else
				{
					tbRow.add("KHÔNG CÒN PHÒNG");
				}
				rows.add(tbRow);
			}
			Model.setDataVector(rows, columns);
			JTableRoom.setModel(Model);
		}
	}
	public void deleteRoom(String roomID)
	{
		if(pr.delete_Room(roomID)==true)
		{
			ArrayList<Room> lr = pr.get_ListRoom();
			for(int i =0;i<lr.size();i++)
			{
				Room r = (Room) lr.get(i);
				rows.clear();
			}
			Model.setDataVector(rows, columns);
			JTableRoom.setModel(Model);
		}
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_Room frame = new GUI_Room();
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
	public GUI_Room() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1244, 752);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 240, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(426, 10, 280, 84);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("QUẢN LÝ PHÒNG");
		lblNewLabel.setBounds(43, 10, 176, 68);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 23));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(255, 255, 255), new Color(160, 160, 160)), "Th\u00F4ng tin ph\u00F2ng", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(33, 127, 386, 539);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Mã phòng");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(29, 34, 81, 13);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Giá phòng");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(29, 157, 81, 13);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Loại phòng");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(29, 94, 81, 22);
		panel_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Tình trạng");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(29, 234, 81, 22);
		panel_1.add(lblNewLabel_5);
		
		txtRoomID = new JTextField();
		txtRoomID.setBounds(126, 33, 131, 19);
		panel_1.add(txtRoomID);
		txtRoomID.setColumns(10);
		
		txtPrice = new JTextField();
		txtPrice.setBounds(128, 156, 129, 19);
		panel_1.add(txtPrice);
		txtPrice.setColumns(10);
		
		JComboBox cbType = new JComboBox();
		cbType.setModel(new DefaultComboBoxModel(new String[] {"", "Normal", "VIP", "Pair room", "Family room"}));
		cbType.setBounds(128, 97, 129, 21);
		panel_1.add(cbType);
		
		JRadioButton rbHave = new JRadioButton("CÒN PHÒNG");
		rbHave.setBounds(118, 237, 103, 21);
		panel_1.add(rbHave);
		
		JRadioButton rbEmpty = new JRadioButton("KHÔNG CÒN PHÒNG");
		rbEmpty.setBounds(228, 237, 136, 21);
		panel_1.add(rbEmpty);
		
		JButton btnAdd = new JButton("Thêm");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtRoomID.getText().equals("")||cbType.getSelectedItem().equals("")||txtPrice.getText().equals(""))
				{
					if( rbEmpty.isSelected()==false && rbHave.isSelected()==false)
					showMessageDialog(null,"Please enter full information");
				}else {
					ArrayList<Room>  arr =pr.get_ListRoom();
					boolean checkSame = false;
					for(int i =0;i<arr.size();i++) {
						Room r = (Room) arr.get(i);
						if(txtRoomID.getText().equals(r.getRoomID())) {
							checkSame = true;
						}
					}
					if(checkSame) {
						showMessageDialog(null,"ID already exists");
					} else {
						if(rbHave.isSelected()==true)
						{
							addRoom(txtRoomID.getText(),(String)cbType.getSelectedItem(),Double.parseDouble(txtPrice.getText()),true);
							txtRoomID.setText(null);
							txtPrice.setText(null);
							rbEmpty.setSelected(false);
							rbHave.setSelected(false);
							cbType.setSelectedIndex(0);
							showMessageDialog(null,"Insert successs");
						}
						if(rbEmpty.isSelected()==true)
						{
							addRoom(txtRoomID.getText(),(String)cbType.getSelectedItem(),Double.parseDouble(txtPrice.getText()),false);
							txtRoomID.setText(null);
							txtPrice.setText(null);
							rbEmpty.setSelected(false);
							rbHave.setSelected(false);
							cbType.setSelectedIndex(0);
							showMessageDialog(null,"Insert successs");
						}
					}
				}
			}
		});
		btnAdd.setBounds(25, 322, 85, 21);
		panel_1.add(btnAdd);
		
		JButton btnUpdate = new JButton("Sửa");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rbHave.isSelected()==true)
				{
					updateRoom(txtRoomID.getText(),(String)cbType.getSelectedItem(),Double.parseDouble(txtPrice.getText()),true);
					showMessageDialog(null,"Update successs");
				}
				if(rbEmpty.isSelected()==true)
				{
					updateRoom(txtRoomID.getText(),(String)cbType.getSelectedItem(),Double.parseDouble(txtPrice.getText()),false);
					showMessageDialog(null,"Update successs");
				}
			}
		});
		btnUpdate.setBounds(128, 322, 85, 21);
		panel_1.add(btnUpdate);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtRoomID.setText(null);
				txtPrice.setText(null);
				rbEmpty.setSelected(false);
				rbHave.setSelected(false);
				cbType.setSelectedIndex(0);
			}
		});
		btnClear.setBounds(253, 322, 85, 21);
		panel_1.add(btnClear);
		
		JButton btnDel = new JButton("Xoá");
		btnDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(contentPane,"Do you want to delete this room ?","Delete",
						JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE);
				if(result == JOptionPane.YES_OPTION) {
					deleteRoom(txtRoomID.getText());
					txtRoomID.setText(null);
					txtPrice.setText(null);
					cbType.setSelectedIndex(0);
					rbEmpty.setSelected(false);
					rbHave.setSelected(false);
					getAllRoom();
				}
			}
		});
		btnDel.setBounds(25, 371, 85, 21);
		panel_1.add(btnDel);
		
		JButton btnExit = new JButton("Thoát");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnExit.setBounds(126, 371, 85, 21);
		panel_1.add(btnExit);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "B\u1EA3ng ph\u00F2ng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(482, 167, 707, 440);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 40, 687, 390);
		panel_3.add(scrollPane);
		
		JTableRoom = new JTable();
		scrollPane.setViewportView(JTableRoom);
		
		JLabel lblNewLabel_1 = new JLabel("Loại phòng");
		lblNewLabel_1.setBounds(613, 127, 66, 13);
		contentPane.add(lblNewLabel_1);
		
		JComboBox cbFindType = new JComboBox();
		cbFindType.setModel(new DefaultComboBoxModel(new String[] {"Normal", "VIP", "Pair room", "Family room"}));
		cbFindType.setBounds(678, 123, 136, 21);
		contentPane.add(cbFindType);
		
		JButton btnSearch = new JButton("Tìm kiếm");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getRoombyRoomType((String)cbFindType.getSelectedItem());
			}
		});
		btnSearch.setBounds(824, 123, 85, 21);
		contentPane.add(btnSearch);
		
		JButton btnRefesh = new JButton("Hiện tất cả");
		btnRefesh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Model.setRowCount(0);
				getAllRoom();
			}
		});
		btnRefesh.setBounds(957, 123, 107, 21);
		contentPane.add(btnRefesh);
		JTableRoom.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = JTableRoom.getSelectedRow();
				txtRoomID.setText((String)(Model.getValueAt(index,0)));
				cbType.setSelectedItem((String)(Model.getValueAt(index,1)));
				txtPrice.setText(String.valueOf(Model.getValueAt(index, 2)));
				if(((String)Model.getValueAt(index, 3)).equals("CÒN PHÒNG"))
				{
				   rbHave.setSelected(true);
				   rbEmpty.setSelected(false);
				}
				else
				{
					rbHave.setSelected(false);
					rbEmpty.setSelected(true);
				}
			}
		});
		columns.add("Mã phòng");
		columns.add("Loại phòng");
		columns.add("Giá phòng");
		columns.add("Tình trạng");
		getAllRoom();
	}
}
