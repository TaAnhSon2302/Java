package excersie1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI_Delete extends JFrame {

	private JPanel contentPane;
	private JTextField txtID;

	Process_Student ps = new Process_Student();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_Delete frame = new GUI_Delete();
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
	public GUI_Delete() {
		setTitle("Xoá sinh viên theo mã sinh viên");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 915, 312);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mã sinh viên");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(124, 104, 121, 22);
		contentPane.add(lblNewLabel);
		
		txtID = new JTextField();
		txtID.setBounds(294, 109, 176, 19);
		contentPane.add(txtID);
		txtID.setColumns(10);
		
		JButton btnNewButton = new JButton("Xoá sinh viên");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ps.delStudent(txtID.getText())==true)
				{
					ps.delStudent(txtID.getText());
					JOptionPane.showMessageDialog(btnNewButton,
							"Xoá thành công",
							"Xoá sinh viên",
							JOptionPane.PLAIN_MESSAGE);
				}
				if(!ps.delStudent(txtID.getText()))
				{
					ps.delStudent(txtID.getText());
					JOptionPane.showMessageDialog(btnNewButton,
							"Xoá không thành công",
							"Xoá sinh viên",
							JOptionPane.PLAIN_MESSAGE);
				}
			}
		});
		btnNewButton.setBounds(570, 108, 121, 20);
		contentPane.add(btnNewButton);
	}
}
