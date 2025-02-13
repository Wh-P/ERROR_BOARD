package com.web.mes021.z01_vo;

import java.util.Date;

public class FileExp1 {
	// ${no} ${fname} ${regdte} ${type} ${etc}
	private int no;
	private String fname;
	private Date regdte;
	private String type;
	private String etc;
	public FileExp1() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public FileExp1(String fname, String type, String etc) {
		this.fname = fname;
		this.type = type;
		this.etc = etc;
	}

	public FileExp1(int no, String fname, Date regdte, String type, String etc) {
		this.no = no;
		this.fname = fname;
		this.regdte = regdte;
		this.type = type;
		this.etc = etc;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public Date getRegdte() {
		return regdte;
	}

	public void setRegdte(Date regdte) {
		this.regdte = regdte;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getEtc() {
		return etc;
	}

	public void setEtc(String etc) {
		this.etc = etc;
	}
	
}
