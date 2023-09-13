package hmac;

public class Payload{
	private String email = "fsea@fd.com";
	private String name = "Tom";
	private String role = "employee";
	private String surName = "Smit";
	private String type = "client";
	private boolean isSystemOperation = false;

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setRole(String role){
		this.role = role;
	}

	public String getRole(){
		return role;
	}

	public void setSurName(String surName){
		this.surName = surName;
	}

	public String getSurName(){
		return surName;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	public void setIsSystemOperation(boolean isSystemOperation){
		this.isSystemOperation = isSystemOperation;
	}

	public boolean isIsSystemOperation(){
		return isSystemOperation;
	}

}
