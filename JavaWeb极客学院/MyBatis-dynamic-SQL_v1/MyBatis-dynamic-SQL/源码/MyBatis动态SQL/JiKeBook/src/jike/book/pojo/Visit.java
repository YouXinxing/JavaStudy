package jike.book.pojo;

import java.util.Date;
/**
 * 用户访问表
 */
public class Visit {
	private Integer visitID;
	private JiKeUser jikeUser;
	private Date visitDate;
	private String visitIP;
	public Integer getVisitID() {
		return visitID;
	}
	public void setVisitID(Integer visitID) {
		this.visitID = visitID;
	}
	public JiKeUser getJikeUser() {
		return jikeUser;
	}
	public void setJikeUser(JiKeUser jikeUser) {
		this.jikeUser = jikeUser;
	}
	public Date getVisitDate() {
		return visitDate;
	}
	public void setVisitDate(Date visitDate) {
		this.visitDate = visitDate;
	}
	public String getVisitIP() {
		return visitIP;
	}
	public void setVisitIP(String visitIP) {
		this.visitIP = visitIP;
	}
	
}
