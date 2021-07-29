package com.amdocs.training.course;

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

public class CourseDAOImpl implements CourseDAO{
	Connection conn=DBUtil.getConnection();

	@Override
	public List<Course> findAll() {
		List<Course> course =new ArrayList<Course>();
		String sql ="select * from course";
		try {
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(sql);
			
			while(rs.next())
			{
				int course_id=rs.getInt("course_id");
				String c_name=rs.getString("c_name");
				String c_desp=rs.getString("c_desp");
				String c_fees=rs.getString("c_fees");
				String c_resource=rs.getString("c_resource");
				
				Course cour=new Course(course_id, c_name, c_desp,c_fees,c_resource);
				course.add(cour);
			}
			return course;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public boolean addCourse(Course course) {
		String query = "insert into course values(?,?,?,?,?)";
		try {
			
			PreparedStatement pst=conn.prepareStatement(query);
			
			pst.setInt(1,course.getCourse_id() );
			pst.setString(2, course.getC_name());
			pst.setString(3, course.getC_desp());
			pst.setString(4, course.getC_fees());
			pst.setString(5, course.getC_resources() );
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
	public Course getCourseById(int id) {
		try {
			String query = "select * from course where course_id= ?";
			
			
			PreparedStatement stat = conn.prepareStatement(query);
			stat.setInt(1,id);
			ResultSet rs = stat.executeQuery();
				rs.next();
				int course_id=rs.getInt("course_id");
				String c_name=rs.getString("c_name");
				String c_desp=rs.getString("c_desp");
				String c_fees=rs.getString("c_fees");	
				String c_resource=rs.getString("c_resources");

				
				Course cours=new Course(course_id,c_name,c_desp,c_fees,c_resource);
				return cours;
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
	public boolean deleteCourse(int id) {
		try {

			String query= "delete from course where course_id=?";
			
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
	public boolean updateCourse(int id) {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		try {

			System.out.print("Enter the new course name ");
			String c_new=br.readLine();
			String query= "Update course set c_name =? where course_id = ? ";
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
