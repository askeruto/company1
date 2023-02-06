package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.member;

public class implMember implements memberDao{

	public static void main(String[] args) {
//            member m=new member("ABC","red","000","台北","44","123");
//		
//		    new implMember().add(m);
//		System.out.println(new implMember().queryAll1());
//		System.out.println(new implMember().queryAll2());
//		List<member> l = new implMember().queryAll2();
////		for(member o:l)
//		{
//			System.out.println(o.getId()+"\t"+o.getName());
//		}
//		
//		System.out.println(l.size());*/
//	}
//		System.out.println(new implMember().queryId(1));
		
//		member m= new implMember().queryId(5);
//           m.setPassword("456456");
//           new implMember().update(m);
		//刪除會員  編號7
//		new implMember().delete(7);
		//查詢會員
//		System.out.println(new implMember().queryUser("abc"));
//		
//		
           }
	@Override
	public void add(member m) {
		 Connection conn = DbConnection.getDB();
		 String sql= "insert into member(name,username,password,address,mobile,phone)"+
		             "value(?,?,?,?,?,?)";
		try {
			PreparedStatement ps =conn.prepareStatement(sql);
			ps.setString(1, m.getName());
			ps.setString(2, m.getUsername());
			ps.setString(3, m.getPassword());
			ps.setString(4, m.getAddress());
			ps.setString(5, m.getMobile());
			ps.setString(6, m.getPhone());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public String queryAll1() {
		Connection conn = DbConnection.getDB();
		String SQL ="select * from member";
		String show="";
		try {
			PreparedStatement ps =conn.prepareStatement(SQL);
			ResultSet rs =ps.executeQuery();
			while(rs.next())
			{
				show =show+"id:"+rs.getInt("id")+
						"\t名字"+rs.getString("name")+
						"\t暱稱"+rs.getString("username")+
						"\t密碼"+rs.getString("password")+
						"\t住址"+rs.getString("address")+
						"\t行動"+rs.getString("mobile")+
						"\t電話"+rs.getString("phone")+"\n";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return show;
	}

	@Override
	public List<member> queryAll2() {
		Connection conn = DbConnection.getDB();
		String sql = "select * from member";
		List<member> l = new ArrayList();
		try {
			PreparedStatement ps =conn.prepareStatement(sql);
			ResultSet rs =ps.executeQuery();
			while(rs.next())
			{
				member m = new member();
				m.setId(rs.getInt("id"));
				m.setName(rs.getString("name"));
				m.setUsername(rs.getString("username"));
				m.setPassword(rs.getString("password"));
				m.setAddress(rs.getString("address"));
				m.setMobile(rs.getString("mobile"));
				m.setPhone(rs.getString("phone"));
				l.add(m);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}

	@Override
	public member queryId(int id) {
		/*
		 * 1.連線
		 * 2.SQL String=where id 只搜尋id  ;
		 * 3.PreparedStatement 方法串接
		 * 4.result 代入結果
		 * 5.if(next())如果有的話就抓資料
		 * 6.true如果有的話就會回傳
		 * 7.false如果沒有的話就回傳null
		 */
		Connection conn= DbConnection.getDB();
		String sql = "select * from member where id=?";
		member m =null;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,id);
			ResultSet rs= ps.executeQuery();
			if(rs.next())
			{
				m= new member();
				m.setId(rs.getInt("id"));
				m.setName(rs.getString("name"));
				m.setUsername(rs.getString("username"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return m;
	}

	@Override
	public member queryUsername(String username, String password) {
		/*
		 * 1.連線到資料庫
		 * 2.sql string 設定方法 where username password
		 * 3.preparedstatement
		 * 4.result
		 * 5.if(next)
		 * 6.true--->回傳值
		 * 7.fasle--->回傳null
		 * 
		 */
		Connection conn=DbConnection.getDB();
		String SQL="select * from member where username=? and password=?";
		member m=null;
		
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1,username);
			ps.setString(2,password);
			ResultSet rs=ps.executeQuery();
			
			if(rs.next())
			{
				 	m=new member();
					m.setId(rs.getInt("id"));
					m.setName(rs.getString("name"));
					m.setUsername(rs.getString("username"));
					m.setPassword(rs.getString("password"));
					m.setAddress(rs.getString("address"));
					m.setMobile(rs.getString("mobile"));
					m.setPhone(rs.getString("phone"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		return m;
	}
	@Override
	public void update(member m) {
		/*
		 * 1.先連線
		 * 2.設定sql方法 update 全部 where id?
		 * 3.執行
		 */
	    Connection conn  = DbConnection.getDB();
	    String sql ="update set name=?, username=?,password=?, address=?, mobile=?,phone=?"
	    		   +"where id=?";
	    try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,m.getName());
			ps.setString(2, m.getUsername());
			ps.setString(3,m.getPassword());
			ps.setString(4, m.getAddress());
			ps.setString(5, m.getMobile());
			ps.setString(6, m.getPhone());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	public void delete(int id) {
		/*1.先執行連線
		 * 2.設定sql
		 * 3.執行
		 */
		Connection conn = DbConnection.getDB();
		String sql ="delete from member where id=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	public boolean queryUser(String username) {
		Connection conn=DbConnection.getDB();
		String SQL="select * from member where username=?";
		boolean m=false;
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(SQL);
			ps.setString(1, username);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) m=true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return m;
	}

}
