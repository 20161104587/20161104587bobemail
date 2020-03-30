package com.imnu.bobEmail.pojo;

import java.util.Date;

public class Mailinfo {
    private Integer mailid;

    private Integer senderid;

    private String title;

    private Date sendtime;

    private Integer state;

    private String attname;

    private Integer importantflag;

    private String body;
    // 用于接收 收件人、发送箱的email的字段
    private String recvemail;
    
    public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	//用于存放发件人 email的字段
    private String email;
  //收件箱 的阅读标志
    private Integer readfalg;
    public Integer getReadfalg() {
		return readfalg;
	}

	public void setReadfalg(Integer readfalg) {
		this.readfalg = readfalg;
	}

	

    public String getRecvemail() {
		return recvemail;
	}

	public void setRecvemail(String recvemail) {
		this.recvemail = recvemail;
	}

	public Integer getMailid() {
        return mailid;
    }

    public void setMailid(Integer mailid) {
        this.mailid = mailid;
    }

    public Integer getSenderid() {
        return senderid;
    }

    public void setSenderid(Integer senderid) {
        this.senderid = senderid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getSendtime() {
        return sendtime;
    }

    public void setSendtime(Date sendtime) {
        this.sendtime = sendtime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getAttname() {
        return attname;
    }

    public void setAttname(String attname) {
        this.attname = attname;
    }

    public Integer getImportantflag() {
        return importantflag;
    }

    public void setImportantflag(Integer importantflag) {
        this.importantflag = importantflag;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}