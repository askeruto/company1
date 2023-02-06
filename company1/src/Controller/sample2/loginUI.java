package Controller.sample2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Dao.implMember;
import Model.member;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Font;

public class loginUI extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField password;
	private JPanel panel;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginUI frame = new loginUI();
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
	public loginUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(new Color(128, 128, 0));
		panel.setBounds(46, 24, 297, 210);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel nametitle = new JLabel("帳號");
		nametitle.setBounds(54, 68, 30, 18);
		panel.add(nametitle);
		
		JLabel pastitle = new JLabel("密碼");
		pastitle.setBounds(54, 101, 52, 15);
		panel.add(pastitle);
		
		name = new JTextField();
		name.setBounds(107, 67, 96, 21);
		panel.add(name);
		name.setColumns(10);
		
		password = new JTextField();
		password.setBounds(107, 98, 96, 21);
		panel.add(password);
		password.setColumns(10);
		
		JButton loginbtn = new JButton("登入");
		loginbtn.setBounds(116, 146, 87, 23);
		panel.add(loginbtn);
		
		lblNewLabel = new JLabel("會員登入系統");
		lblNewLabel.setFont(new Font("新細明體", Font.PLAIN, 20));
		lblNewLabel.setBounds(84, 22, 152, 21);
		panel.add(lblNewLabel);
		loginbtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String Username= name.getText();
				String Password= password.getText();
				
				member m = new implMember().queryUsername(Username, Password);
				if(m!=null)
				{
					loginsuccess l = new loginsuccess();
					l.show();
					dispose();
				}
				else
				{
					loginerror l = new loginerror();
					l.show();
					dispose();
				}
			}
			
		});
	}
}
