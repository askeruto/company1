package Controller.sample1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Dao.implMember;
import Model.member;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class UI extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField username;
	private JTextField password;
	private JTextField address;
	private JTextField mobile;
	private JTextField phone;
	private JTextField nameupdate;
	private JTextField addressupdate;
	private JTextField idupdate;
	private JTextField iddelete;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI frame = new UI();
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
	public UI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100,700, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 128, 64));
		panel.setBounds(10, 20, 244, 500);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel namet = new JLabel("姓名");
		namet.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		namet.setBounds(22, 46, 48, 28);
		panel.add(namet);
		
		JLabel usernamet = new JLabel("暱稱");
		usernamet.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		usernamet.setBounds(22, 102, 48, 28);
		panel.add(usernamet);
		
		JLabel passwordt = new JLabel("密碼");
		passwordt.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		passwordt.setBounds(22, 157, 48, 28);
		panel.add(passwordt);
		
		JLabel addresst = new JLabel("地址");
		addresst.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		addresst.setBounds(22, 213, 48, 28);
		panel.add(addresst);
		
		JLabel mobilet = new JLabel("行動");
		mobilet.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		mobilet.setBounds(22, 264, 48, 28);
		panel.add(mobilet);
		
		JLabel phonet = new JLabel("電話");
		phonet.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		phonet.setBounds(22, 319, 48, 28);
		panel.add(phonet);
		
		name = new JTextField();
		name.setBounds(87, 55, 96, 21);
		panel.add(name);
		name.setColumns(10);
		
		username = new JTextField();
		username.setColumns(10);
		username.setBounds(87, 111, 96, 21);
		panel.add(username);
		
		password = new JTextField();
		password.setColumns(10);
		password.setBounds(87, 166, 96, 21);
		panel.add(password);
		
		address = new JTextField();
		address.setColumns(10);
		address.setBounds(87, 222, 96, 21);
		panel.add(address);
		
		mobile = new JTextField();
		mobile.setColumns(10);
		mobile.setBounds(87, 273, 96, 21);
		panel.add(mobile);
		
		phone = new JTextField();
		phone.setColumns(10);
		phone.setBounds(87, 328, 96, 21);
		panel.add(phone);
		
		JButton addbutton = new JButton("新增");
		addbutton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*
				 * 1.從get抓資料
				 * 2.new 
				 * 3.add
				 */
				String Name =name.getText();
				String Username =username.getText();
				String Password =password.getText();
				String Address =address.getText();
				String Mobile =mobile.getText();
				String Phone =phone.getText();
				member m = new member(Name,Username,Password,Address,Mobile,Phone);
				
				new implMember().add(m);
				
			}
		});
		addbutton.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		addbutton.setBounds(96, 388, 87, 23);
		panel.add(addbutton);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 128, 64));
		panel_1.setBounds(264, 20, 410, 500);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JTextArea show1 = new JTextArea();
		show1.setBounds(18, 234, 375, 226);
		panel_1.add(show1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(18, 475, 46, 15);
		panel_1.add(lblNewLabel);
		
		JButton readbtn = new JButton("查詢");
		readbtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				show1.setText(new implMember().queryAll1());
				List<member> l = new implMember().queryAll2();
				lblNewLabel.setText("共"+l.size()+"筆");
			}
		});
		readbtn.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		readbtn.setBounds(18, 201, 87, 23);
		panel_1.add(readbtn);
		
		
		
		
		
		
		
		
		JLabel name_1 = new JLabel("姓名");
		name_1.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		name_1.setBounds(111, 63, 35, 23);
		panel_1.add(name_1);
		
		JLabel address_1 = new JLabel("地址");
		address_1.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		address_1.setBounds(111, 96, 35, 28);
		panel_1.add(address_1);
		
		JLabel f = new JLabel("id");
		f.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		f.setBounds(111, 145, 35, 28);
		panel_1.add(f);
		
		nameupdate = new JTextField();
		nameupdate.setColumns(10);
		nameupdate.setBounds(156, 66, 96, 21);
		panel_1.add(nameupdate);
		
		addressupdate = new JTextField();
		addressupdate.setColumns(10);
		addressupdate.setBounds(156, 102, 96, 21);
		panel_1.add(addressupdate);
		
		idupdate = new JTextField();
		idupdate.setColumns(10);
		idupdate.setBounds(156, 151, 96, 21);
		panel_1.add(idupdate);
		
		iddelete = new JTextField();
		iddelete.setColumns(10);
		iddelete.setBounds(297, 151, 96, 21);
		panel_1.add(iddelete);
		
		JLabel f_1 = new JLabel("id");
		f_1.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		f_1.setBounds(262, 145, 35, 28);
		panel_1.add(f_1);
		
		JButton updatebtn = new JButton("更新");
		updatebtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*
				 * /*先取得資料
				 * 1.nameUpdate,addressUpdate ,updateId-->getText
				 * 2.updateId-->轉成int--->queryId(id)-->member m
				 * 3.m.setName(),m.setAddress()
				 * 4.update(m)
				 */
				
				 String Name =nameupdate.getText();
				 String Address = addressupdate.getText();
				 int Id =Integer.parseInt(idupdate.getText());
				  member m= new implMember().queryId(Id);
				  m.setName(Name);
				  m.setAddress(Address);
				    new implMember().update(m);
			}
		});
		updatebtn.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		updatebtn.setBounds(165, 201, 87, 23);
		panel_1.add(updatebtn);
		
		JButton deletebtn = new JButton("刪除");
		deletebtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*
				 * 1.get要刪除的id
				 * 2.執行
				 */
			   int Iddelete =Integer.parseInt(iddelete.getText());
			   
			    new implMember().delete(Iddelete);
			}
		});
		deletebtn.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		deletebtn.setBounds(306, 201, 87, 23);
		panel_1.add(deletebtn);
		
		
	}
}
