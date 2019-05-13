package cn.nicecoder.longtblog.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @Author: longt
 * @Date: 2019/5/13 15:52
 * @Description:
 */
@Entity
public class Agree {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String type;

    private String agreeid;

    private String userid;

    private String pudate;

    private String ob1;

    private String ob2;

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

    public String getAgreeid() {
        return agreeid;
    }

    public void setAgreeid(String agreeid) {
        this.agreeid = agreeid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPudate() {
        return pudate;
    }

    public void setPudate(String pudate) {
        this.pudate = pudate;
    }

    public String getOb1() {
        return ob1;
    }

    public void setOb1(String ob1) {
        this.ob1 = ob1;
    }

    public String getOb2() {
        return ob2;
    }

    public void setOb2(String ob2) {
        this.ob2 = ob2;
    }

    public Agree(String type) {
        this.type = type;
    }

    public Agree(String type, String agreeid, String userid, String pudate, String ob1, String ob2) {
        this.type = type;
        this.agreeid = agreeid;
        this.userid = userid;
        this.pudate = pudate;
        this.ob1 = ob1;
        this.ob2 = ob2;
    }
}
