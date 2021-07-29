package com.amdocs.training.contact;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.amdocs.training.Util.DBUtil;

public class ContactDAOImpl implements ContactDAO {
	Connection conn=DBUtil.getConnection();

	@Override
	public List<Contact> findAll() {
		List<Contact> contact=new ArrayList<Contact>();
		String sql ="select * from contact";
		try {
			Statement stat = conn.createStatement();
			
			ResultSet rs = stat.executeQuery(sql);
			
			while(rs.next())
			{
				int user_id=rs.getInt("user_id");
				String name=rs.getString("name");
				String Email=rs.getString("Email");
				String Phone_no=rs.getString("Phone_no");
				String Message=rs.getString("Message");
				int contact_id=rs.getInt("contact_id");
				
				Contact cont=new Contact(user_id, name, Email, Phone_no, Message, contact_id);
				contact.add(cont);
			}
			return contact;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public boolean addContact(Contact contact) {
		String query = "insert into contact values(?,?,?,?,?,?)";
		try {
			
			PreparedStatement pst=conn.prepareStatement(query);
			
			pst.setInt(1, contact.getUser_id());
			pst.setString(2, contact.getName());
			pst.setString(3, contact.getEmail());
			pst.setString(4,contact.getPhone_no());
			pst.setString(5, contact.getMessage() );
			pst.setInt(6, contact.getContact_id());
			int row=pst.executeUpdate();
			if(row>0)
			{
				return true;
			}
			else
				System.out.println("Try again ");
			
			
			
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
	public Contact getContactById(int id) {
		try {
			String query = "select * from contact where user_id= ?";
			
			
			PreparedStatement stat = conn.prepareStatement(query);
			stat.setInt(1,id);
			ResultSet rs = stat.executeQuery();
				rs.next();
				int idd=rs.getInt("user_id");
				String name=rs.getString("name");
				String Email=rs.getString("Email");
				String Phone_no=rs.getString("Phone_no");

				String Message=rs.getString("Message");
				int contact_id=rs.getInt("contact_id");

				
				Contact cont=new Contact(idd, name,Email,Phone_no,Message,contact_id);
				
				return cont;
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
	public boolean deleteContact(int id) {
	try {

		String query= "delete from contact where user_id=?";
		
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
	public boolean updateContact(Contact cont) {
	
	try {

		String query= "Update contact set name=?, Email=?,Phone_no=?,Message=? , contact_id=?  where user_id = ? ";
		PreparedStatement ps=conn.prepareStatement(query);
		ps.setString(1, cont.getName());
		ps.setString(2, cont.getEmail());
		ps.setString(3, cont.getPhone_no());
		ps.setString(4, cont.getMessage());
		ps.setInt(5, cont.getContact_id());
		ps.setInt(6, cont.getUser_id());
		int row=ps.executeUpdate();
		if(row>0)
			return true;
	}  catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return false;
	
	
	
}

}
