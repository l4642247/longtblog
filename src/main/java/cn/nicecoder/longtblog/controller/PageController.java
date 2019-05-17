package cn.nicecoder.longtblog.controller;

import cn.nicecoder.longtblog.entity.Article;
import cn.nicecoder.longtblog.entity.Catalog;
import cn.nicecoder.longtblog.entity.Tag;
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

import java.util.Set;

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

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index(){
        return new ModelAndView("redirect:index.html");
    }

    @RequestMapping(value = "/login.html", method = RequestMethod.GET)
    public ModelAndView loginPage(){
        return new ModelAndView("login");
    }

    @RequestMapping(value = "/admin.html", method = RequestMethod.GET)
    public ModelAndView adminPage(){
        return new ModelAndView("admin/index");
    }

    @RequestMapping(value = "/index.html", method = RequestMethod.GET)
    public ModelAndView index(@RequestParam(value = "currentPage",defaultValue = "0") int pageNumber,
                              @RequestParam(value = "pagesize",defaultValue = "5") int pageSize,
                              @RequestParam(value = "title",required = false) String title,
                              @RequestParam(value = "catalog",required = false) String catalog,
                              @RequestParam(value = "status",required = false) String status){
        Page<Model> articles =  articleService.articleSearch(pageNumber, pageSize, title, catalog, status);
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("articles", articles);
        return mv;
    }

    @RequestMapping(value = "/about.html", method = RequestMethod.GET)
    public ModelAndView about(){
        return new ModelAndView("about");
    }

    @RequestMapping(value = "/gbook.html", method = RequestMethod.GET)
    public ModelAndView gbook(){
        return new ModelAndView("gbook");
    }

    @RequestMapping(value = "/info.html", method = RequestMethod.GET)
    public ModelAndView info(){
        return new ModelAndView("info");
    }

    @RequestMapping(value = "/infopic.html", method = RequestMethod.GET)
    public ModelAndView infopic(){
        return new ModelAndView("infopic");
    }

    @RequestMapping(value = "/list.html", method = RequestMethod.GET)
    public ModelAndView list(){
        return new ModelAndView("list");
    }

    @RequestMapping(value = "/share.html", method = RequestMethod.GET)
    public ModelAndView share(){
        return new ModelAndView("share");
    }

    @RequestMapping(value = "/admin/article-edit.html", method = RequestMethod.GET)
    public ModelAndView articleEdit(@RequestParam(value = "id",required = false) Long id){
        ModelAndView mv = new ModelAndView("admin/article-editor");
        Article article = new Article();
        if(id != null) {
            article = articleService.articleDetail(id);
        }
        mv.addObject("article", article);
        Set<Tag> tagSet= article.getTags();
        String tags = "";
        for(Tag t : tagSet){
            tags += t.getName() +",";
        }
        mv.addObject("tags",tags);
        Page<Catalog> list = catalogService.catalogPage(0,20);
        mv.addObject("catalogList",list.getContent());
        return mv;
    }

    @RequestMapping(value = "/admin/catalog-edit.html", method = RequestMethod.GET)
    public ModelAndView catalogEdit(@RequestParam(value = "id",required = false) Long id){
        ModelAndView mv = new ModelAndView("admin/catalog-editor");
        Catalog catalog = new Catalog();
        if(id != null) {
            catalog = catalogService.findById(id);
        }
        mv.addObject("catalog", catalog);
        return mv;
    }

    @RequestMapping(value = "/admin/article-table.html", method = RequestMethod.GET)
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

    @RequestMapping(value = "/admin/catalog-table.html", method = RequestMethod.GET)
    public ModelAndView articleTable(){
        ModelAndView mv = new ModelAndView("admin/catalog-table");
        Page<Catalog> list = catalogService.catalogPage(0,20);
        mv.addObject("catalogList",list.getContent());
        return mv;
    }
}
