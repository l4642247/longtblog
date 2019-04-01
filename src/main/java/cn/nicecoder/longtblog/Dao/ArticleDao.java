package cn.nicecoder.longtblog.Dao;

import cn.nicecoder.longtblog.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ArticleDao extends JpaRepository<Article, Long>, JpaSpecificationExecutor {


}
