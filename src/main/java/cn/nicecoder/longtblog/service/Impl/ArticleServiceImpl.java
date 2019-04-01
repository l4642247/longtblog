package cn.nicecoder.longtblog.service.Impl;

import cn.nicecoder.longtblog.Dao.ArticleDao;
import cn.nicecoder.longtblog.entity.Article;
import cn.nicecoder.longtblog.entity.BlogUser;
import cn.nicecoder.longtblog.service.ArticleService;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;


/**
 * @Author: longt
 * @Date: 2019/4/1 15:25
 * @Description:
 */
@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    ArticleDao articleDao;

    @Override
    public Article articleCreate(Article article) {
        return articleDao.save(article);
    }

    @Override
    public Page<Model> articleSearch(int pageNumber, int pageSize, String title, String catalog, String status) {
        Specification querySpeci = new Specification() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = Lists.newArrayList();
                if(!StringUtils.isEmpty(title)) {
                    predicates.add(criteriaBuilder
                            .like(root.get("title"), "%" + title + "%"));
                }
                if(!StringUtils.isEmpty(catalog)){
                    predicates.add(criteriaBuilder
                            .like(root.get("catalog"), "%" + catalog + "%"));
                }
                if(!StringUtils.isEmpty(status)){
                    predicates.add(criteriaBuilder
                            .like(root.get("status"), "%" + status + "%"));
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };
        return articleDao.findAll(querySpeci, PageRequest.of(pageNumber, pageSize, Sort.Direction.DESC, "keywords"));
    }

    @Override
    public Article articleDetail(Long id) {
        Article article  = null;
        //在空的Optional实例上调用get()，抛出NoSuchElementException
        if(articleDao.findById(id) != null && articleDao.findById(id).isPresent()){
            article = articleDao.findById(id).get();
        }
        return article;
    }
}
