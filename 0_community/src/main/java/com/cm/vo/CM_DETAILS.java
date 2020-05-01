package com.cm.vo;

public class CM_DETAILS {
	private String d_num;
	private String report_count;
	private String up_count;
	private String down_count;
	private String b_num;
	private String c_user_id;
	private String reg_date;
	public String getD_num() {
		return d_num == null ? "" : d_num.trim();
	}
	public String getReport_count() {
		return report_count == null ? "" : report_count.trim();
	}
	public String getUp_count() {
		return up_count == null ? "" : up_count.trim();
	}
	public String getDown_count() {
		return down_count == null ? "" : down_count.trim();
	}
	public String getB_num() {
		return b_num == null ? "" : b_num.trim();
	}
	public String getC_user_id() {
		return c_user_id == null ? "" : c_user_id.trim();
	}
	public String getReg_date() {
		return reg_date == null ? "" : reg_date.trim();
	}
	public void setD_num(String d_num) {
		this.d_num = d_num;
	}
	public void setReport_count(String report_count) {
		this.report_count = report_count;
	}
	public void setUp_count(String up_count) {
		this.up_count = up_count;
	}
	public void setDown_count(String down_count) {
		this.down_count = down_count;
	}
	public void setB_num(String b_num) {
		this.b_num = b_num;
	}
	public void setC_user_id(String c_user_id) {
		this.c_user_id = c_user_id;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}

}
