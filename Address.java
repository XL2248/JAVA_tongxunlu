package javaWorkSpace;

import java.io.Serializable;

public class Address implements Serializable{
	private String name;
	private String phone;
	private String mobile;
	private String address;
	private String note;
	
	public Address(){
		
	}
	public Address(String name,String phone,String mobile,String address,String note){
		this.name=name;
		this.phone=phone;
		this.mobile=mobile;
		this.address=address;
		this.note=note;
		
	}
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name=name;
	}
	
	public String getPhone(){
		return phone;
	}
	public void setPhone(String phone){
		this.phone=phone;
	}
	
	public String getMobile(){
		return mobile;
	}
	public void setMobile(String mobile){
		this.mobile=mobile;
	}
	
	public String getAddress(){
		return address;
	}
	public void setAddress(String address){
		this.address=address;
	}
	
	public String getNote(){
		return note;
	}
	public void setNote(String note){
		this.note=note;
	}
}
