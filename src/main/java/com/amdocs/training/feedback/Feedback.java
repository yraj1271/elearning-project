package com.amdocs.training.feedback;

public class Feedback {
	
	private int user_id;
	private String name;
	private String email;
	private int  f_id;
	private String feedback;
	public Feedback(int user_id, String name, String email, int f_id, String feedback) {
		super();
		this.user_id = user_id;
		this.name = name;
		this.email = email;
		this.f_id = f_id;
		this.feedback = feedback;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getF_id() {
		return f_id;
	}
	public void setF_id(int f_id) {
		this.f_id = f_id;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	@Override
	public String toString() {
		return "Feedback [user_id=" + user_id + ", name=" + name + ", email=" + email + ", f_id=" + f_id + ", feedback="
				+ feedback + "]";
	}
	

}
