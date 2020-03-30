package com.imnu.bobEmail.pojo;

import java.util.Date;

public class Users {
    private Integer id;

    private String truename;

    private String pwd;

    private String sex;

    private String tel;

    private String email;

    private Integer deparmentid;
    //群发邮件的 阅读状态
    private Integer readfalg;
    

    public Integer getReadfalg() {
		return readfalg;
	}

	public void setReadfalg(Integer readfalg) {
		this.readfalg = readfalg;
	}

	private Boolean isadmin;
    //用于 存放好友添加的时间
    private Date addtime;
    //用户存放好友的 部门名称和 职位
    private String depname;
    private String deprole;
    public String getDepname() {
		return depname;
	}

	public void setDepname(String depname) {
		this.depname = depname;
	}

	public String getDeprole() {
		return deprole;
	}

	public void setDeprole(String deprole) {
		this.deprole = deprole;
	}

	public Date getAddtime() {
		return addtime;
	}

	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTruename() {
        return truename;
    }

    public void setTruename(String truename) {
        this.truename = truename;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getDeparmentid() {
        return deparmentid;
    }

    public void setDeparmentid(Integer deparmentid) {
        this.deparmentid = deparmentid;
    }

    public Boolean getIsadmin() {
        return isadmin;
    }

    public void setIsadmin(Boolean isadmin) {
        this.isadmin = isadmin;
    }
}