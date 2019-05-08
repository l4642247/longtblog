package cn.nicecoder.longtblog.controller;

import cn.nicecoder.longtblog.entity.Article;
import cn.nicecoder.longtblog.entity.Catalog;
import cn.nicecoder.longtblog.service.ArticleService;
import cn.nicecoder.longtblog.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

/**
 * @Author: longt
 * @Date: 2019/4/1 14:52
 * @Description: 文章
 */
@Controller
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    ArticleService articleService;
    @Autowired
    CatalogService catalogService;

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public ModelAndView create(@RequestParam(value = "title",required = true) String title,
                          @RequestParam(value = "content",required = true) String content,
                          @RequestParam(value = "catalog",required = true) Long catalogId,
                          @RequestParam(value = "status",required = false, defaultValue = "0") String status,
                          @RequestParam(value = "id",required = false) Long id){
        Catalog catalog = catalogService.findById(catalogId);
        Article art = null;
        if(id == null) {
            art = new Article(title, "longt", content, 0l, null, status, new Date(), new Date());
        }else{
            art = articleService.articleDetail(id);
            art.setTitle(title);
            art.setStatus(status);
            art.setContent(content);
        }
        //建立双向连接，顺序很重要
        catalog.getArticleList().add(art);
        art.setCatalog(catalog);
        articleService.articleCreate(art);
        ModelAndView mv = new ModelAndView("redirect:/admin/article-table");
        return mv;
    }

    @RequestMapping(value = "search", method = RequestMethod.POST)
    @ResponseBody
    public Page<Model> search(@RequestParam(value = "currentPage",defaultValue = "0") int pageNumber,
                                @RequestParam(value = "pagesize",defaultValue = "5") int pageSize,
                                @RequestParam(value = "title",required = false) String title,
                                @RequestParam(value = "catalog",required = false) String catalog,
                                @RequestParam(value = "status",required = false) String status){
        return articleService.articleSearch(pageNumber, pageSize, title, catalog, status);
    }

    @RequestMapping(value = "/info/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Article detail(@PathVariable Long id){
        return articleService.articleDetail(id);
    }

}
