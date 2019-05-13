package cn.nicecoder.longtblog.entity;

import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @Author: longt
 * @Date: 2019/3/29 15:38
 * @Description: 博客系统用户
 */
@Entity
public class User {

    @Id
    @GeneratedValue(generator = "uuid")
    private String id;
    private String username;
    private String password;

    private String type;
    private String status;
    private String pic;
    private String name;
    private String ob1;
    private String ob2;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public User() {
    }

    public User(String username, String password, String type, String status, String pic, String name, String ob1, String ob2) {
        this.username = username;
        this.password = password;
        this.type = type;
        this.status = status;
        this.pic = pic;
        this.name = name;
        this.ob1 = ob1;
        this.ob2 = ob2;
    }
}
