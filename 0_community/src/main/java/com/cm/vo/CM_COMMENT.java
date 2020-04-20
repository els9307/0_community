package com.cm.vo;

public class CM_COMMENT {
	private String c_num;
	private String c_writer;
	private String c_comment;
	private String c_sysdate;
	private String b_num;
	private String b_writer;
	public String getC_num() {
		return c_num == null ? "" : c_num.trim();
	}
	public String getC_writer() {
		return c_writer == null ? "" : c_writer.trim();
	}
	public String getC_comment() {
		return c_comment == null ? "" : c_comment.trim();
	}
	public String getC_sysdate() {
		return c_sysdate == null ? "" : c_sysdate.trim();
	}
	public String getB_num() {
		return b_num == null ? "" : b_num.trim();
	}
	public String getB_writer() {
		return b_writer == null ? "" : b_writer.trim();
	}
	public void setC_num(String c_num) {
		this.c_num = c_num;
	}
	public void setC_writer(String c_writer) {
		this.c_writer = c_writer;
	}
	public void setC_comment(String c_comment) {
		this.c_comment = c_comment;
	}
	public void setC_sysdate(String c_sysdate) {
		this.c_sysdate = c_sysdate;
	}
	public void setB_num(String b_num) {
		this.b_num = b_num;
	}
	public void setB_writer(String b_writer) {
		this.b_writer = b_writer;
	}

	
}
