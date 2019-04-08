package cn.nicecoder.longtblog.entity;

import javax.persistence.*;
import java.util.List;

/**
 * @Author: longt
 * @Date: 2019/4/1 14:40
 * @Description:
 */
@Entity
public class Catalog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private Long   count;
    private Long   sort;
    private String des;

    @OneToMany(mappedBy = "catalog", cascade = CascadeType.PERSIST)
    private List<Article> articleList;

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

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Long getSort() {
        return sort;
    }

    public void setSort(Long sort) {
        this.sort = sort;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }


    public List<Article> getArticleList() {
        return articleList;
    }

    public void setArticleList(List<Article> articleList) {
        this.articleList = articleList;
    }

    public Catalog() {
    }

    public Catalog(String name, Long count, Long sort, String des) {
        this.name = name;
        this.count = count;
        this.sort = sort;
        this.des = des;
    }
}
