package cn.nicecoder.longtblog.service.Impl;

import cn.nicecoder.longtblog.dao.CatalogDao;
import cn.nicecoder.longtblog.entity.Catalog;
import cn.nicecoder.longtblog.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 * @Author: longt
 * @Date: 2019/3/29 15:50
 * @Description: 实现类
 */
@Service
public class CatalogServiceImpl implements CatalogService {
    @Autowired
    CatalogDao catalogDao;

    @Override
    public Page<Catalog> catalogPage(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.Direction.ASC, "sort");
        return catalogDao.findAll(pageable);
    }

    @Override
    public Catalog catalogCreate(Catalog catalog) {
        return catalogDao.save(catalog);
    }

    @Override
    public void deleteCatalog(Long id) {
        catalogDao.deleteById(id);
    }

    @Override
    public Catalog findById(Long id) {
        return catalogDao.findById(id).get();
    }
}
