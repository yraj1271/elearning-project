package com.amdocs.training.course;

public class Course {
	
	private int course_id;
	private String c_name;
	private String c_desp;
	private String c_fees;
	@Override
	public String toString() {
		return "Course [course_id=" + course_id + ", c_name=" + c_name + ", c_desp=" + c_desp + ", c_fees=" + c_fees
				+ ", c_resources=" + c_resources + "]";
	}
	public int getCourse_id() {
		return course_id;
	}
	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	public String getC_desp() {
		return c_desp;
	}
	public void setC_desp(String c_desp) {
		this.c_desp = c_desp;
	}
	public String getC_fees() {
		return c_fees;
	}
	public void setC_fees(String c_fees) {
		this.c_fees = c_fees;
	}
	public String getC_resources() {
		return c_resources;
	}
	public void setC_resources(String c_resources) {
		this.c_resources = c_resources;
	}
	public Course(int course_id, String c_name, String c_desp, String c_fees, String c_resources) {
		super();
		this.course_id = course_id;
		this.c_name = c_name;
		this.c_desp = c_desp;
		this.c_fees = c_fees;
		this.c_resources = c_resources;
	}
	private String c_resources;
	

}
