package Controller.sample2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Dao.implMember;
import Model.member;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class addMember extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField username;
	private JTextField password;
	private JTextField address;
	private JTextField mobile;
	private JTextField phone;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addMember frame = new addMember();
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
	public addMember() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 128, 0));
		panel.setBounds(10, 10, 414, 241);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("姓名");
		lblNewLabel.setBounds(105, 23, 46, 15);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("帳號");
		lblNewLabel_1.setBounds(105, 52, 46, 15);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("密碼");
		lblNewLabel_2.setBounds(105, 85, 46, 15);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("地址");
		lblNewLabel_3.setBounds(105, 114, 46, 15);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("行動");
		lblNewLabel_4.setBounds(105, 146, 33, 15);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("電話");
		lblNewLabel_5.setBounds(105, 176, 46, 15);
		panel.add(lblNewLabel_5);
		
		name = new JTextField();
		name.setBounds(142, 17, 96, 21);
		panel.add(name);
		name.setColumns(10);
		
		username = new JTextField();
		username.setColumns(10);
		username.setBounds(142, 48, 96, 21);
		panel.add(username);
		
		password = new JTextField();
		password.setColumns(10);
		password.setBounds(142, 79, 96, 21);
		panel.add(password);
		
		address = new JTextField();
		address.setColumns(10);
		address.setBounds(142, 107, 96, 21);
		panel.add(address);
		
		mobile = new JTextField();
		mobile.setColumns(10);
		mobile.setBounds(142, 139, 96, 21);
		panel.add(mobile);
		
		phone = new JTextField();
		phone.setColumns(10);
		phone.setBounds(142, 170, 96, 21);
		panel.add(phone);
		
		JButton btnNewButton = new JButton("創建");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String Username = username.getText();
				if(new implMember().queryUser(Username))
				{
					adderror l = new adderror();
					l.show();
					dispose();
				}
				else
				{
					String Name = name.getText();
				    String Password =password.getText(); 
				    String Address = address.getText();
				    String Mobile = mobile.getText();
				    String Phone = phone.getText();
				    
				    member m = new member(Name,Username,Password,Address,Mobile,Phone);
				    new implMember().add(m);
				    
				    addsuccess l = new addsuccess();
				    l.show();
				    dispose();
				    		
				    
				}
			}
		});
		btnNewButton.setBounds(151, 208, 87, 23);
		panel.add(btnNewButton);
	}

}
