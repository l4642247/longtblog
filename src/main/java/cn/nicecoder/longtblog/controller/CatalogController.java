package cn.nicecoder.longtblog.controller;

import cn.nicecoder.longtblog.entity.Catalog;
import cn.nicecoder.longtblog.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/catalog")
public class CatalogController {
    @Autowired
    CatalogService catalogService;

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    @ResponseBody
    public Catalog create(@RequestParam(value = "name",required = true) String name,
                          @RequestParam(value = "sort",required = false) Long sort,
                          @RequestParam(value = "id",required = false) Long id,
                          @RequestParam(value = "des",required = false) String des){
        Catalog catalog = new Catalog(name, 0l, sort, des);
        return catalogService.catalogCreate(catalog);
    }

    @RequestMapping(value="/page", method = RequestMethod.GET)
    @ResponseBody
    public Page<Catalog> page(@RequestParam(value = "currentPage",defaultValue = "0") int pageNumber,
                              @RequestParam(value = "pagesize",defaultValue = "5") int pageSize){
        return catalogService.CatalogPage(pageNumber, pageSize);
    }
}
