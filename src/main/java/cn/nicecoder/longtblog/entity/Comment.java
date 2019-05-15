package cn.nicecoder.longtblog.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * @Author: longt
 * @Date: 2019/5/13 15:39
 * @Description:
 */
@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String type;

    private Long discussid;

    private String userid;

    private String touserid;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;

    private int agree;

    private String status;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(name="content", columnDefinition="BLOB", nullable=true)
    private String content;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getDiscussid() {
        return discussid;
    }

    public void setDiscussid(Long discussid) {
        this.discussid = discussid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getTouserid() {
        return touserid;
    }

    public void setTouserid(String touserid) {
        this.touserid = touserid;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getAgree() {
        return agree;
    }

    public void setAgree(int agree) {
        this.agree = agree;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Comment() {
    }

    public Comment(String type, Long discussid, String userid, String touserid, Date createTime, int agree, String status, String content) {
        this.type = type;
        this.discussid = discussid;
        this.userid = userid;
        this.touserid = touserid;
        this.createTime = createTime;
        this.agree = agree;
        this.status = status;
        this.content = content;
    }
}


