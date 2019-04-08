package cn.nicecoder.longtblog.controller;

import cn.nicecoder.longtblog.entity.Catalog;
import cn.nicecoder.longtblog.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/catalog")
public class CatalogController {
    @Autowired
    CatalogService catalogService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Catalog create(@RequestParam(value = "name",required = true) String name,
                          @RequestParam(value = "sort",required = false) Long sort,
                          @RequestParam(value = "id",required = false) Long id,
                          @RequestParam(value = "des",required = false) String des){
        Catalog catalog = new Catalog(name, 0l, sort, des);
        return catalogService.catalogCreate(catalog);
    }

    @RequestMapping(value="/page", method = RequestMethod.POST)
    public Page<Catalog> page(@RequestParam(value = "currentPage",defaultValue = "0") int pageNumber,
                              @RequestParam(value = "pagesize",defaultValue = "5") int pageSize){
        return catalogService.CatalogPage(pageNumber, pageSize);

    }

}
