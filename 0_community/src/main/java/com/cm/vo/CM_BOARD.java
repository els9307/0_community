package com.cm.vo;

public class CM_BOARD {

	
	private String b_num;
	private String user_id;
	private String b_subject;
	private String b_content;
	private String b_category;
	private String b_img;
	private String b_thumbimg;
	private String reg_date;
	private String mod_date;
	private String report;
	private String report_count;
	private String up_count;
	private String down_count;
	public String getUp_count() {
		return up_count == null ? "" : up_count.trim();
	}
	public String getDown_count() {
		return down_count == null ? "" : down_count.trim();
	}
	public String getB_num() {
		return b_num == null ? "" : b_num.trim();
	}
	public String getUser_id() {
		return user_id == null ? "" : user_id.trim();
	}
	public String getB_subject() {
		return b_subject == null ? "" : b_subject.trim();
	}
	public String getB_content() {
		return b_content == null ? "" : b_content.trim();
	}
	public String getB_category() {
		return b_category == null ? "" : b_category.trim();
	} 
	public String getB_img() {
		return b_img == null ? "" : b_img.trim();
	}
	public String getB_thumbimg() {
		return b_thumbimg == null ? "" : b_thumbimg.trim();
	}
	public String getReg_date() {
		return reg_date == null ? "" : reg_date.trim();
	}
	public String getMod_date() {
		return mod_date == null ? "" : mod_date.trim();
	}
	public String getReport_count() {
		return report_count == null ? "" : report_count.trim();
	}
	public void setB_num(String b_num) {
		this.b_num = b_num;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public void setB_subject(String b_subject) {
		this.b_subject = b_subject;
	}
	public void setB_content(String b_content) {
		this.b_content = b_content;
	}
	public void setB_category(String b_category) {
		this.b_category = b_category;
	}
	public void setB_img(String b_img) {
		this.b_img = b_img;
	}
	public void setB_thumbimg(String b_thumbimg) {
		this.b_thumbimg = b_thumbimg;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	public void setMod_date(String mod_date) {
		this.mod_date = mod_date;
	}
	public void setReport_count(String report_count) {
		this.report_count = report_count;
	}
	public String getReport() {
		return report;
	}

	public void setReport(String report) {
		this.report = report;
	}
	public void setUp_count(String up_count) {
		this.up_count = up_count;
	}
	public void setDown_count(String down_count) {
		this.down_count = down_count;
	}
	
	
}
