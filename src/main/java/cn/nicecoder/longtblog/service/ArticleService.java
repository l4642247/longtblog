package cn.nicecoder.longtblog.service;

import cn.nicecoder.longtblog.entity.Article;

import org.springframework.data.domain.Page;
import org.springframework.ui.Model;


public interface ArticleService {
    public Article articleCreate(Article article);

    public Page<Model> articleSearch(int pageNumber, int pageSize, String title, String catalog, String status);

    public Article articleDetail(Long id);
}
