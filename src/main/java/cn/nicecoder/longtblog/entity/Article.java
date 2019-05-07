package cn.nicecoder.longtblog.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * @Author: longt
 * @Date: 2019/4/1 14:40
 * @Description:
 */
@Entity
public class Article {
    /**
     *     @Id
     *     @Column(name = "ID")
     *     @GenericGenerator(name = "idGenerator", strategy = "uuid")
     *     @GeneratedValue(generator = "idGenerator") //可在ID上面加上ID生成策略
     */

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    private String author;
    private String content;
    private Long   click;
    private String status;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;


    @ManyToOne()
    @JoinColumn(name = "catalog_id")
    @JsonBackReference
    private Catalog catalog;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getClick() {
        return click;
    }

    public void setClick(Long click) {
        this.click = click;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(name=" content", columnDefinition="CLOB", nullable=true)
    public String getContent() {
        return content;
    }

    public Article() {
    }

    public Article(String title, String author, String content, Long click, Catalog catalog, String status, Date createTime, Date updateTime) {
        this.title = title;
        this.author = author;
        this.content = content;
        this.click = click;
        this.status = status;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }
}
