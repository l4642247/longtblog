package cn.nicecoder.longtblog.entity;

import javax.persistence.*;
import java.util.List;

/**
 * @Author: longt
 * @Date: 2019/4/23 16:16
 * @Description:
 */
@Entity
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String des;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }


    public Tag() {
    }

    public Tag(String name, String des) {
        this.name = name;
        this.des = des;
    }
}
