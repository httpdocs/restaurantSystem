package object;

import java.io.Serializable;

public class Custom_LogIn_Information implements  Serializable{

	private String name;
	private String passWord;
	private String address;
	private String phone;
		 
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	//这里要改写东西
	public Custom_LogIn_Information(String name,String passWord ){
		 this.name=name;
		 this.passWord=passWord;
	 }
	 
	 public Custom_LogIn_Information(){
		 
	 }
}
