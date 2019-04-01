package cn.nicecoder.longtblog.controller;

import cn.nicecoder.longtblog.entity.Article;
import cn.nicecoder.longtblog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @Author: longt
 * @Date: 2019/4/1 14:52
 * @Description: 文章
 */
@RestController
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    ArticleService articleService;

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public Article create(@RequestParam(value = "title",required = true) String title,
                          @RequestParam(value = "content",required = true) String content,
                          @RequestParam(value = "catalog",required = true) String catalog,
                          @RequestParam(value = "status",required = true) String status){
        Article art = new Article(title, "longt", content, 0l, catalog, status, new Date(), new Date());
        return articleService.articleCreate(art);
    }

    @RequestMapping(value = "search", method = RequestMethod.POST)
    public Page<Model> search(@RequestParam(value = "currentPage",defaultValue = "0") int pageNumber,
                                @RequestParam(value = "pagesize",defaultValue = "5") int pageSize,
                                @RequestParam(value = "title",required = false) String title,
                                @RequestParam(value = "catalog",required = false) String catalog,
                                @RequestParam(value = "status",required = false) String status){
        return articleService.articleSearch(pageNumber, pageSize, title, catalog, status);
    }

    @RequestMapping(value = "/info/{id}", method = RequestMethod.GET)
    public Article detail(@PathVariable Long id){
        return articleService.articleDetail(id);
    }

}
