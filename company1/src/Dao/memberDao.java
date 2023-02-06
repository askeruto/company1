package Dao;

import java.util.List;

import Model.member;

public interface memberDao {
	//新增
 //	 void add(String name,String username,String password,String address ,String mobile,String phone);
	 void add(member m); 
	//查詢
	String queryAll1();
	List<member> queryAll2();
	member queryId(int id);
	member queryUsername(String username,String name);
	boolean queryUser(String username);
		
	//更新
	void update(member m); 
	//刪除
    void delete(int id);
}
