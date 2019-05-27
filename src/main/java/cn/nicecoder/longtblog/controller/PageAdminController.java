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
public class PageAdminController {
    @Autowired
    CatalogService catalogService;

    @Autowired
    ArticleService articleService;

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView("redirect:index.html");
        return mv;
    }

    @RequestMapping(value = "/admin/index.html", method = RequestMethod.GET)
    public ModelAndView realIndex(){
        ModelAndView mv = new ModelAndView("admin/index");
        return mv;
    }

    @RequestMapping(value = "/admin/article-edit.html", method = RequestMethod.GET)
    public ModelAndView articleEdit(@RequestParam(value = "id",required = false) Long id){
        ModelAndView mv = new ModelAndView("admin/article-editor");
        Article article = new Article();
        if(id != null) {
            article = articleService.articleDetail(id);
        }else{
            article.setContent("".getBytes());
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
                                         @RequestParam(value = "catalogId",required = false) Long catalogId,
                                         @RequestParam(value = "tag",required = false) String tag,
                                     @RequestParam(value = "status",required = false) String status){
        Page<Model> list = articleService.articleSearch(pageNumber, pageSize, title, catalogId, tag, status, null);
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
