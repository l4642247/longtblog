package cn.nicecoder.longtblog.Dao;

import cn.nicecoder.longtblog.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface ArticleDao extends JpaRepository<Article, Long>, JpaSpecificationExecutor {

    @Query(value="SELECT * FROM article where id < ?1 limit 1", nativeQuery = true)
    Article findPre(Long id);

    @Query(value="SELECT * FROM article where id > ?1 limit 1", nativeQuery = true)
    Article findNext(Long id);

}
