package com.amdocs.training.feedback;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.amdocs.training.Util.DBUtil;

public class FeedbackDAOImpl implements FeedbackDAO {
	Connection conn=DBUtil.getConnection();

	@Override
	public List<Feedback> findAll() {
		List<Feedback> feedbackk=new ArrayList<Feedback>();
		String sql ="select * from feedback";
		try {
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(sql);
			
			while(rs.next())
			{
				int user_id=rs.getInt("user_id");
				String name=rs.getString("name");
				String email=rs.getString("email");
				int f_id=rs.getInt("f_id");
				String feed=rs.getString("feedback");
				
				Feedback feeds=new Feedback(user_id, name, email, f_id, feed);
				feedbackk.add(feeds);
			}
			return feedbackk;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public boolean addFeedback(Feedback feedback) {
		String query = "insert into feedback values(?,?,?,?,?)";
		try {

			
			PreparedStatement pst=conn.prepareStatement(query);
			
			pst.setInt(1, feedback.getUser_id());
			pst.setString(2, feedback.getName());
			pst.setString(3, feedback.getEmail());
			pst.setInt(4,feedback.getF_id());
			pst.setString(5,feedback.getFeedback() );
		
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
	public Feedback getFeedbackById(int id) {
		try {
			String query = "select * from feedback where user_id= ?";
			
			
			PreparedStatement stat = conn.prepareStatement(query);
			stat.setInt(1,id);
			ResultSet rs = stat.executeQuery();
				rs.next();
				int idd=rs.getInt("user_id");
				String name=rs.getString("name");
				String email=rs.getString("email");
				int f_id=rs.getInt("f_id");
				String feeds=rs.getString("feedback");
				Feedback feed=new Feedback(idd, name,email,f_id,feeds);
				
				return feed;
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
	public boolean deleteFeedback(int id) {
		try {

			String query= "delete from feedback where user_id=?";
			
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
	public boolean updateFeedback(int id) {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		try {

			System.out.print("Enter the new name ");
			String c_new=br.readLine();
			String query= "Update feedback set name =? where user_id = ? ";
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setString(1, c_new);
			ps.setInt(2, id);
			int row=ps.executeUpdate();
			if(row>0)
				return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
		
		
	}

}
