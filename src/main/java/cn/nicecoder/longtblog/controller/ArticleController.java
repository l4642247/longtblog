package cn.nicecoder.longtblog.controller;

import cn.hutool.json.JSONObject;
import cn.nicecoder.longtblog.entity.Article;
import cn.nicecoder.longtblog.entity.Catalog;
import cn.nicecoder.longtblog.entity.Tag;
import cn.nicecoder.longtblog.service.ArticleService;
import cn.nicecoder.longtblog.service.CatalogService;
import cn.nicecoder.longtblog.service.Impl.TagServiceImpl;
import cn.nicecoder.longtblog.util.RegUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    @Autowired
    TagServiceImpl tagService;

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public ModelAndView create(@RequestParam(value = "title",required = false) String title,
                               @RequestParam(value = "summary",required = false) String summary,
                               @RequestParam(value = "content",required = true) String content,
                               @RequestParam(value = "tags",required = false) String tagStr,
                               @RequestParam(value = "cover",required = false) String cover,
                               @RequestParam(value = "type",required = true) String type,
                               @RequestParam(value = "catalog",required = false) Long catalogId,
                               @RequestParam(value = "status",required = false, defaultValue = "0") String status,
                               @RequestParam(value = "id",required = false) Long id){
        Catalog catalog = catalogService.findById(catalogId);
        Article art = null;
        if(id == null) {
            art = new Article(title, summary, "longt", content.getBytes(), 0l, status, new Date(), new Date(), 0, type);
        }else{
            art = articleService.articleDetail(id);
            art.setTitle(title);
            art.setStatus(status);
            art.setContent(content.getBytes());
        }
        //建立双向连接，顺序很重要
        //关联类别
        art.setCatalog(catalog);
        Article article= articleService.articleCreate(art);

        //关联标签
        if(tagStr.contains(",")) {
            String tagArr[] = tagStr.split(",");
            Set<Tag> tags = new HashSet<Tag>();
            for (String tagName : tagArr) {
                Tag tag = tagService.findByName(tagName);
                if (tag == null) {
                    tag = new Tag();
                    tag.setName(tagName);
                    tag = tagService.tagCreate(tag);
                }
                tags.add(tag);
            }
            article.setTags(tags);
        }

        //封面
        if(cover == null){
            List<String> pictures = RegUtil.getImgSrc(content.replaceAll("\"","\\\""));
            if(pictures != null && pictures.size() > 0) {
                article.setCover(pictures.get(0));
            }
        }else{
            article.setCover(cover);
        }
        Article insertArt = articleService.articleCreate(article);

        ModelAndView mv = new ModelAndView("redirect:/admin/article-table.html");
        return mv;
    }

    @RequestMapping(value = "search", method = RequestMethod.POST)
    @ResponseBody
    public Page<Model> search(@RequestParam(value = "currentPage",defaultValue = "0") int pageNumber,
                                @RequestParam(value = "pagesize",defaultValue = "5") int pageSize,
                                @RequestParam(value = "title",required = false) String title,
                                @RequestParam(value = "catalogId",required = false) Long catalogId,
                                @RequestParam(value = "tag",required = false) String tag,
                                @RequestParam(value = "status",required = false) String status){
        return articleService.articleSearch(pageNumber, pageSize, title, catalogId, tag, status, null);
    }

    @RequestMapping(value = "/info/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Article detail(@PathVariable Long id){
        return articleService.articleDetail(id);
    }

    @RequestMapping(value = "/near/{id}", method = RequestMethod.GET)
    @ResponseBody
    public JSONObject nearlyArt(@PathVariable Long id){
        JSONObject jb = new JSONObject();
        jb.put("pre",articleService.articleNearly(id).get(0));
        jb.put("next",articleService.articleNearly(id).get(1));
        return jb;
    }

    @RequestMapping(value = "top8", method = RequestMethod.GET)
    @ResponseBody
    public List<Article> top8(){
        return articleService.findTop8();
    }

}
