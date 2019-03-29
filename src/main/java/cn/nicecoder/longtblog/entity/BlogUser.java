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
public class BlogUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private String password;
    //有了该继承关系，在显示detail视图的时候同时会把simple视图的所有字段也显示出来
    public interface UserSimpleView{};
    public interface UserDetailView extends UserSimpleView{};

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @JsonView(UserSimpleView.class)
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
}
