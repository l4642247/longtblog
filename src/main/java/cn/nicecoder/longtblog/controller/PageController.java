package cn.nicecoder.longtblog.controller;

import cn.nicecoder.longtblog.entity.Article;
import cn.nicecoder.longtblog.entity.Catalog;
import cn.nicecoder.longtblog.service.ArticleService;
import cn.nicecoder.longtblog.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author: longt
 * @Date: 2019/3/29 10:41
 * @Description: 核心控制器
 */
@Controller
public class PageController {
    @Autowired
    CatalogService catalogService;

    @Autowired
    ArticleService articleService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView loginPage(){
        return new ModelAndView("login");
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public ModelAndView adminPage(){
        return new ModelAndView("admin/index");
    }

    @RequestMapping(value = "/admin/article-edit", method = RequestMethod.GET)
    public ModelAndView articleEdit(@RequestParam(value = "id",required = false) Long id){
        ModelAndView mv = new ModelAndView("admin/article-editor");
        Article article = new Article();
        if(id != null) {
            article = articleService.articleDetail(id);
        }
        mv.addObject("article", article);
        Page<Catalog> list = catalogService.CatalogPage(0,20);
        mv.addObject("catalogList",list.getContent());
        return mv;
    }

    @RequestMapping(value = "/admin/article-table", method = RequestMethod.GET)
    public ModelAndView articleTable(@RequestParam(value = "currentPage",defaultValue = "0") int pageNumber,
                                     @RequestParam(value = "pagesize",defaultValue = "5") int pageSize,
                                     @RequestParam(value = "title",required = false) String title,
                                     @RequestParam(value = "catalog",required = false) String catalog,
                                     @RequestParam(value = "status",required = false) String status){
        Page<Model> list = articleService.articleSearch(pageNumber, pageSize, title, catalog, status);
        ModelAndView mv = new ModelAndView("admin/article-table");
        mv.addObject("articleList",list.getContent());
        return mv;
    }
}
