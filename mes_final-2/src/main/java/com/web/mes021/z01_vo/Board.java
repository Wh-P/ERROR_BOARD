package com.web.mes021.z01_vo;

import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;


public class Board {
	// 기본 속성선언
	private int cnt;
	private int level;	
	private int no;
	private int refno;
	private int eqnum;
	
	private String subject;
	private String content;
	private String writer;
	private int readcnt;
	private Date regdte;
	private Date uptdte;
	private MultipartFile[] reports;
	private List<String> flist; // 상세화면에서 첨부된 파일 리스트 
	
	
	public Board() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Board(int cnt, int level, int no, int refno, int eqnum, String subject, String content, String writer,
			int readcnt, Date regdte, Date uptdte, MultipartFile[] reports, List<String> flist) {
		super();
		this.cnt = cnt;
		this.level = level;
		this.no = no;
		this.refno = refno;
		this.eqnum = eqnum;
		this.subject = subject;
		this.content = content;
		this.writer = writer;
		this.readcnt = readcnt;
		this.regdte = regdte;
		this.uptdte = uptdte;
		this.reports = reports;
		this.flist = flist;
	}


	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getNo() {
		return no;
	}
	public int getEqnum() {
		return eqnum;
	}
	public void setEqnum(int eqnum) {
		this.eqnum = eqnum;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getRefno() {
		return refno;
	}
	public void setRefno(int refno) {
		this.refno = refno;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public int getReadcnt() {
		return readcnt;
	}
	public void setReadcnt(int readcnt) {
		this.readcnt = readcnt;
	}
	public Date getRegdte() {
		return regdte;
	}
	public void setRegdte(Date regdte) {
		this.regdte = regdte;
	}
	public Date getUptdte() {
		return uptdte;
	}
	public void setUptdte(Date uptdte) {
		this.uptdte = uptdte;
	}
	public MultipartFile[] getReports() {
		return reports;
	}
	public void setReports(MultipartFile[] reports) {
		this.reports = reports;
	}
	public List<String> getFlist() {
		return flist;
	}
	public void setFlist(List<String> flist) {
		this.flist = flist;
	}
	
}
