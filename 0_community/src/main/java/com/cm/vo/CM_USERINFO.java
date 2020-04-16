package com.cm.vo;

public class CM_USERINFO {
	private String user_num;
	private String user_id;
	private String user_pwd;
	private String user_email;
	private String reg_date;
	private String mod_date;
	private String user_img;
	private String user_thumbimg;
	private String user_nickname;
	private String user_name;
	private String check;
	public String getUser_num() {
		return user_num == null ? "" : user_num.trim();
	}
	public String getUser_id() {
		return user_id == null ? "" : user_id.trim();
	}
	public String getUser_pwd() {
		return user_pwd == null ? "" : user_pwd.trim();
	}
	public String getUser_email() {
		return user_email == null ? "" : user_email.trim();
	}
	public String getReg_date() {
		return reg_date == null ? "" : reg_date.trim();
	}
	public String getMod_date() {
		return mod_date == null ? "" : mod_date.trim();
	}
	public String getUser_img() {
		return user_img == null ? "" : user_img.trim();
	}
	public String getUser_thumbimg() {
		return user_thumbimg == null ? "" : user_thumbimg.trim();
	}
	public String getUser_nickname() {
		return user_nickname == null ? "" : user_nickname.trim();
	}
	public String getUser_name() {
		return user_name == null ? "" : user_name.trim();
	}
	public String getCheck() {
		return check == null ? "" : check.trim();
	}
	public void setUser_num(String user_num) {
		this.user_num = user_num;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public void setUser_pwd(String user_pwd) {
		this.user_pwd = user_pwd;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	public void setMod_date(String mod_date) {
		this.mod_date = mod_date;
	}
	public void setUser_img(String user_img) {
		this.user_img = user_img;
	}
	public void setUser_thumbimg(String user_thumbimg) {
		this.user_thumbimg = user_thumbimg;
	}
	public void setUser_nickname(String user_nickname) {
		this.user_nickname = user_nickname;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public void setCheck(String check) {
		this.check = check;
	}
	
}
