package com;

public class RegBean {
	
private String uname,email,pwd,rpwd;

public RegBean(){
	System.out.println("inside regbean no arg constructor");
}

public String getUname() {
	return uname;
}

public void setUname(String uname) {
	
	System.out.println("inside setuname()"+uname);
	this.uname = uname;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
	System.out.println("inside setemail()"+email);
}

public String getPwd() {
	return pwd;
}

public void setPwd(String pwd) {
	System.out.println("inside setpwd()"+pwd);
	this.pwd = pwd;
}

public String getRpwd() {
	return rpwd;
}

public void setRpwd(String rpwd) {
	this.rpwd = rpwd;
}	

}
