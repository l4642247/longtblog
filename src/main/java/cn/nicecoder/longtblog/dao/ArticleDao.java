package cn.nicecoder.longtblog.dao;

import cn.nicecoder.longtblog.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface ArticleDao extends JpaRepository<Article, Long>, JpaSpecificationExecutor {

    @Query(value="SELECT * FROM article where id < ?1 limit 1", nativeQuery = true)
    Article findPre(Long id);

    @Query(value="SELECT * FROM article where id > ?1 limit 1", nativeQuery = true)
    Article findNext(Long id);


    @Transactional
    @Modifying
    @Query(value="update article set agree = agree + 1 where id = ?1", nativeQuery = true)
    void updateAgree(Long id);

    @Query(value="SELECT catalog_id FROM article where id = ?1 ", nativeQuery = true)
    Long findCatalogId(Long id);

}
