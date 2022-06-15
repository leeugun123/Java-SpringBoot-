package com.example.demo.model;

public class UserProfile {
	
	private String id;
	private String name;
	private String phone;
	private String address;
	//서버를 개발할때는 멤버 변수를 모두 private
	//변수에 접근하기 위해 메소드를 사용하여 접근
	
	public UserProfile(String id, String name, String phone, String address) {
		super();
		
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.address = address;
		
	}//생성자

	public UserProfile(Object object) {
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
	
	
}
