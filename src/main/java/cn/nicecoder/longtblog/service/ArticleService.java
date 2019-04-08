package cn.nicecoder.longtblog.service;

import cn.nicecoder.longtblog.entity.Article;

import org.springframework.data.domain.Page;
import org.springframework.ui.Model;


public interface ArticleService {
    /**
     * 创建文章
     * @param article
     * @return
     */
    public Article articleCreate(Article article);


    /**
     * 查询文章（分页）
     * @param pageNumber
     * @param pageSize
     * @param title
     * @param catalog
     * @param status
     * @return
     */
    public Page<Model> articleSearch(int pageNumber, int pageSize, String title, String catalog, String status);


    /**
     * 文章详情
     * @param id
     * @return
     */
    public Article articleDetail(Long id);
}
