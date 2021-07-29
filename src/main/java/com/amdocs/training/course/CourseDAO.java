package com.amdocs.training.course;

import java.util.List;

public interface CourseDAO {

	List<Course> findAll();

	boolean addCourse(Course course);

	Course getCourseById(int id);

	boolean deleteCourse(int id);
	
	boolean updateCourse(int id);
}
