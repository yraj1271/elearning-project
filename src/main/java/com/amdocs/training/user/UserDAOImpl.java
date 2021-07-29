package com.amdocs.training.user;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.amdocs.training.Util.DBUtil;

public class UserDAOImpl implements UserDAO {
	
	Connection conn=DBUtil.getConnection();

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		// this is for the printing of all the entry in the user . 
		
		List<User> users=new ArrayList<User>();
		String sql ="select * from user";
		try {
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(sql);
			
			while(rs.next())
			{
				int user_id=rs.getInt("user_id");
				String name=rs.getString("name");
				String phone_no=rs.getString("phone_no");
				String email=rs.getString("email");
				String address=rs.getString("address");
				String reg_date=rs.getString("reg_date");
				String password=rs.getString("password");
				String upload_photo=rs.getString("upload_photo");
				
				User user=new User(user_id, name,phone_no,email,address,reg_date,password,upload_photo);
				users.add(user);
			}
			return users;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addUser(User user) {
		// TODO Auto-generated method stub	
		String query = "insert into user values(?,?,?,?,?,?,?,?)";
		try {

			
			PreparedStatement pst=conn.prepareStatement(query);
			
			pst.setInt(1, user.getUser_id());
			pst.setString(2, user.getName());
			pst.setString(3, user.getPhone_no());
			pst.setString(4,user.getEmail());
			pst.setString(5, user.getAddress() );
			pst.setString(6, user.getReg_date());
			pst.setString(7,user.getPassword());
			pst.setString(8, user.getUpload_photo());
			int row=pst.executeUpdate();
			if(row>0)
			{
				return true;
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean deleteUser(int id) {
		// TODO Auto-generated method stub
	
		try {

			String query= "delete from user where user_id=?";
			
			PreparedStatement ps=conn.prepareStatement(query);
			
			ps.setInt(1, id);
			int row=ps.executeUpdate();
			if(row>0)
				return true;
			
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	
	@Override
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		try {
			String query = "select * from user where user_id= ?";
			
			
			PreparedStatement stat = conn.prepareStatement(query);
			stat.setInt(1,id);
			ResultSet rs = stat.executeQuery();
				rs.next();
				int idd=rs.getInt("user_id");
				String name=rs.getString("name");
				String phone_no=rs.getString("phone_no");
				String email=rs.getString("email");
				String address=rs.getString("address");
				String reg_date=rs.getString("reg_date");
				String password=rs.getString("password");
				String upload_photo=rs.getString("upload_photo");
				
				User user=new User(idd, name,phone_no,email,address,reg_date,password,upload_photo);
				
				return user;
				
			
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return null;
	}

@Override
public boolean updateUser(User user) throws SQLException {
	
	
	
	String query="update user set name=? ,phone_no=?,email=?,address=?,password=? where user_id=?";
	

		PreparedStatement ps=conn.prepareStatement(query);
		ps.setString(1,user.getName());
		ps.setString(2,user.getPhone_no());
		ps.setString(3,user.getEmail());
		ps.setString(4, user.getAddress());
		ps.setString(5, user.getPassword());
		ps.setInt(6, user.getUser_id());
		int row=ps.executeUpdate();
		if(row>0)
			return true;

    return false;
}



}
