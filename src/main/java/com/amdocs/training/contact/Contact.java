package com.amdocs.training.contact;

public class Contact {
	
	private int user_id ;
	private String name;
	private String Email;
	private String Phone_no;
	private String Message;
	private int contact_id ;
	public Contact(int user_id, String name, String email, String phone_no, String message, int contact_id) {
		super();
		this.user_id = user_id;
		this.name = name;
		this.Email = email;
		Phone_no = phone_no;
		Message = message;
		this.contact_id = contact_id;
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
		return Email;
	}
	public void setEmail(String email) {
		this.Email = email;
	}
	public String getPhone_no() {
		return Phone_no;
	}
	public void setPhone_no(String phone_no) {
		Phone_no = phone_no;
	}
	public String getMessage() {
		return Message;
	}
	public void setMessage(String message) {
		Message = message;
	}
	public int getContact_id() {
		return contact_id;
	}
	public void setContact_id(int contact_id) {
		this.contact_id = contact_id;
	}
	@Override
	public String toString() {
		return "Contact [user_id=" + user_id + ", name=" + name + ", email=" + Email + ", Phone_no=" + Phone_no
				+ ", Message=" + Message + ", contact_id=" + contact_id + "]";
	}
	
	

}
